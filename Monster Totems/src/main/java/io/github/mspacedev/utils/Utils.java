package io.github.mspacedev.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class Utils
{

	public static Logger logger;

	public static Logger getLogger()
	{
		if (logger == null)
		{
			logger = LogManager.getFormatterLogger(Reference.MODID);
		}
		return logger;
	}
}
