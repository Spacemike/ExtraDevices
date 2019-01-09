package li.cil.oc.integration.opencomputers

import li.cil.oc.api

object ModExtraDevices extends ModProxy {
  override def getMod = Mods.OpenComputers

  override def initialize() {
    AdvDroneTemplate.register()
}
