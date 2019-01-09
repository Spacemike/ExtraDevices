package li.cil.oc.common.template

object AdvDroneTemplate extends DroneTemplate {
  //override protected val suggestedComponents = Array(
  //  "BIOS" -> hasComponent(Constants.ItemName.EEPROM) _)

  //override protected def hostClass = classOf[internal.Drone]

  //def selectTier3(stack: ItemStack) = api.Items.get(stack) == api.Items.get(Constants.ItemName.DroneCaseTier3)
  public bool selectTier3(stack: ItemStack){
    return api.Items.get(stack) == api.Items.get("dronecase3");
  }

  /*def validate(inventory: IInventory): Array[AnyRef] = validateComputer(inventory)

  def assemble(inventory: IInventory) = {
    val items = (0 until inventory.getSizeInventory).map(inventory.getStackInSlot)
    val data = new DroneData()
    data.tier = caseTier(inventory)
    data.name = RobotData.randomName
    data.components = items.drop(1).filter(!_.isEmpty).toArray
    data.storedEnergy = Settings.get.bufferDrone.toInt
    val stack = api.Items.get(Constants.ItemName.Drone).createItemStack(1)
    data.save(stack)
    val energy = Settings.get.droneBaseCost + complexity(inventory) * Settings.get.droneComplexityCost

    Array(stack, Double.box(energy))
  }

  def selectDisassembler(stack: ItemStack) = api.Items.get(stack) == api.Items.get(Constants.ItemName.Drone)

  def disassemble(stack: ItemStack, ingredients: Array[ItemStack]) = {
    val info = new MicrocontrollerData(stack)
    val itemName = Constants.ItemName.DroneCase(info.tier)

    Array(api.Items.get(itemName).createItemStack(1)) ++ info.components
  }*/

  def register() {
    // Tier 1
    api.IMC.registerAssemblerTemplate(
      "Drone (Tier 3)",
      "li.cil.oc.common.template.DroneTemplate.selectTier3",
      "li.cil.oc.common.template.DroneTemplate.validate",
      "li.cil.oc.common.template.DroneTemplate.assemble",
      hostClass,
      null,
      Array(
        Tier.Three,
        Tier.Three,
        Tier.Two,
        Tier.Two,
        Tier.One,
      ),
      asJavaIterable(Iterable(
        (Slot.Card, Tier.Three),
        (Slot.Card, Tier.Two),
        (Slot.Card, Tier.Two),
        null,
        (Slot.CPU, Tier.Two),
        (Slot.Memory, Tier.Two),
        null,
        (Slot.EEPROM, Tier.Any)
      ).map(toPair)))

    // Disassembler
    /*api.IMC.registerDisassemblerTemplate(
      "Drone",
      "li.cil.oc.common.template.DroneTemplate.selectDisassembler",
      "li.cil.oc.common.template.DroneTemplate.disassemble")*/
  }

  override protected def maxComplexity(inventory: IInventory) =
    if (caseTier(inventory) == Tier.Three) 16

  override protected def caseTier(inventory: IInventory) = ItemUtils.caseTier(inventory.getStackInSlot(0))
}