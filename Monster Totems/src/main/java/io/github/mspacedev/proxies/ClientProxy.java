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
    public void genMagicParticle(Block block, BlockPos pos) {
        World world = Minecraft.getMinecraft().world;

        double rand = world.rand.nextDouble();
        double d1 = pos.getX() + 0.5;
        double d2 = pos.getY() + 0.5;
        double d3 = pos.getZ() + 0.5;
        ParticleMagic particleMagic = new ParticleMagic(world, d1, d2, d3, rand * 0.4D, 0.7D, rand * 0.4D);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleMagic);
    }
}
