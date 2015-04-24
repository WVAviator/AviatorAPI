package com.wvaviator.aviatorapi;

import java.io.File;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptableRemoteVersions = "*")
public class AviatorAPI {
	
	public static Logger logger;
	public static EventBus EVENT_BUS = new EventBus();
	public static Configuration config;
	public static File configurationDirectory;
	
	@EventHandler
	public void onPreInitialization(FMLPreInitializationEvent e) {
		
		logger = e.getModLog();
		config = new Configuration(e.getSuggestedConfigurationFile());
		configurationDirectory = e.getModConfigurationDirectory();
		
	}

}
