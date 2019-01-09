package com.spacemike.extradevices.template;

import li.cil.oc.api.*;
import li.cil.oc.api.network.EnvironmentHost;
import li.cil.oc.common.Slot;
import li.cil.oc.common.Tier;
import li.cil.oc.util.ItemUtils;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;

//import scala.collection.convert.WrapAsJava._

public class AdvDroneTemplate {
	
	/*public final Class<? extends EnvironmentHost> hostClass() {
		return li.cil.oc.api.internal.Drone.class;
	}*/
	public static boolean selectTier3(ItemStack stack) {
		System.out.println("itemtest");
		System.out.println(Items.get("dronecase3"));
		System.out.println(Items.get(stack));
		return (Items.get(stack) == Items.get("dronecase3"));
	}

	public static void register() {
		ArrayList<Pair<String, Integer>> containerSlots = new ArrayList<Pair<String, Integer>>();
		containerSlots.add(Pair.of(Slot.Card(), Tier.Three()));
		containerSlots.add(Pair.of(Slot.Card(), Tier.Two()));
		containerSlots.add(Pair.of(Slot.Card(), Tier.Two()));
		containerSlots.add(Pair.of(Slot.CPU(), Tier.Two()));
		containerSlots.add(Pair.of(Slot.Memory(), Tier.Two()));
		containerSlots.add(Pair.of(Slot.Memory(), Tier.Two()));
		containerSlots.add(Pair.of(Slot.EEPROM(), Tier.Any()));
		
		Class<? extends EnvironmentHost> hostClass = li.cil.oc.api.internal.Drone.class;
		
		// Tier 3
	    IMC.registerAssemblerTemplate(
	      "Drone (Tier 3)",
	      "com.spacemike.extradevices.template.AdvDroneTemplate.selectTier3",
	      "li.cil.oc.common.template.DroneTemplate.validate",
	      "li.cil.oc.common.template.DroneTemplate.assemble",
	      hostClass,
	      null,
	      new int[] {
	    	Tier.Three(),
	    	Tier.Three(),
	    	Tier.Two(),
	    	Tier.Two(),
	    	Tier.One()
	      },
	      //
	      containerSlots
	      );
		
		/*NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("select", "com.spacemike.extradevices.template.AdvDroneTemplate.selectTier3");
		nbt.setString("validate", "li.cil.oc.common.template.DroneTemplate.validate");
		nbt.setString("assemble", "li.cil.oc.common.template.DroneTemplate.assemble");
		nbt.setString("hostClass", "com.spacemike.extradevices.template.AdvDroneTemplate.hostClass");
		NBTTagList upgslots = new NBTTagList();
		NBTTagCompound upgslot1 = new NBTTagCompound();
		upgslot1.setString("type", value);
		upgslots.appendTag(nbt);*/
	}

	public int maxComplexity(IInventory inventory) {
		if (caseTier(inventory) == 2) return 16;
		return 5;
	}

	public int caseTier(IInventory inventory) {
		return ItemUtils.caseTier(inventory.getStackInSlot(0));
	}
}