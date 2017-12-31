package io.github.mspacedev.proxies;

import io.github.mspacedev.client.particles.ParticleMagic;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event){

    }

    @Override
    public void init(FMLInitializationEvent event){

    }

    @Override
    public void postInit(FMLPostInitializationEvent event){

    }

    @Override
    public void genMagicParticle(Block block, BlockPos pos, float r, float g, float b) {
        World world = Minecraft.getMinecraft().world;

        // Convert 255 RGB to 0-1 RGB notation
        r /= 255;
        g /= 255;
        b /= 255;

        double d1 = pos.getX() + 0.5;
        double d2 = pos.getY() + 0.5;
        double d3 = pos.getZ() + 0.5;
        ParticleMagic particleMagic = new ParticleMagic(world, d1, d2, d3, r, g, b);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleMagic);
    }
}
