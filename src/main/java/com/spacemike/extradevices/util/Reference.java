package com.spacemike.extradevices.util;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class Reference {

	public static final String MOD_ID = "ed";
	public static final String NAME = "Extra Devices";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSION = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "com.spacemike.extradevices.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.spacemike.extradevices.proxy.CommonProxy";
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Baubles is installed: " + Loader.isModLoaded("baubles")); //This here checks if the soft dependency is loaded.
    }
}
