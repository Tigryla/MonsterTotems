package io.github.mspacedev.utils;

import net.minecraft.client.renderer.GlStateManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class Utils {

    public static Logger logger;

    public static Logger getLogger(){
        if(logger == null){
            logger = LogManager.getFormatterLogger(Reference.MODID);
        }
        return logger;
    }

    public static void PushMatrix()
    {
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
    }

    public static void PopMatrix()
    {
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}
