package com.mspacedev;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main
{
	public static final String MODID = "monstertotems";
	public static final Logger LOGGER = LogManager.getLogger(Main.MODID);

	public Main()
	{
		LOGGER.debug("Monster Totems has been found! Starting load...");
	}
}
