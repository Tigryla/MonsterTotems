package io.github.mspacedev.utils;

import io.github.mspacedev.entities.*;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class Reference
{
	public static final String NAME = "Monster Totems";
	public static final String MODID = "monstertotems";
	public static final String VERSION = "[1.10.2]";
	public static final String COMMON_PROXY = "io.github.mspacedev.proxies.CommonProxy";
	public static final String CLIENT_PROXY = "io.github.mspacedev.proxies.ClientProxy";

	public static final Class[] ENTITIES = {
			EntitySpiritZombie.class,
			EntitySpiritSkeleton.class,
			EntitySpiritCreeper.class,
			EntitySpiritSpider.class,
			EntitySpiritEnderman.class,
			EntitySpiritWitch.class,
			EntitySpiritSilverfish.class,
			EntitySpiritSlime.class,
			EntitySpiritBlaze.class,
			EntitySpiritPigZombie.class,
			EntitySpiritGhast.class,
			EntitySpiritMagmaCube.class,
			EntitySpiritHusk.class,
			EntitySpiritZombieVillager.class,
			EntitySpiritCaveSpider.class,
			EntitySpiritStray.class,
			EntitySpiritWitherSkeleton.class
	};

	public static final AxisAlignedBB[] TOTEM_BASE_BOUNDING_BOXES = {
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D),
			new AxisAlignedBB(0.875D, 0.0D, 0.875D, 1.03125D, 1.09375D, 1.03125D),
			new AxisAlignedBB(0.96875D, 1.0625D, 0.96875D, 1.09375D, 1.1875D, 1.09375D),
			new AxisAlignedBB(1.0625D, 1.125D, 1.0625D, 1.15625D, 1.3125D, 1.15625D),
			new AxisAlignedBB(1.0D, 1.28125D, 1.0625D, 1.09375D, 1.4375D, 1.15625D),
			new AxisAlignedBB(0.96875D, 1.40625D, 1.03125D, 1.03125D, 1.5625D, 1.09375D),
			new AxisAlignedBB(-0.03125D, 0.0D, 0.875D, 0.125D, 1.09375D, 1.03125D),
			new AxisAlignedBB(-0.09375D, 1.0625D, 0.96875D, 0.03125D, 1.1875D, 1.09375D),
			new AxisAlignedBB(-0.15625D, 1.125D, 1.0625D, -0.0625D, 1.3125D, 1.15625D),
			new AxisAlignedBB(-0.15625D, 1.28125D, 1.0D, -0.0625D, 1.4375D, 1.09375D),
			new AxisAlignedBB(-0.09375D, 1.40625D, 0.96875D, -0.03125D, 1.5625D, 1.03125D),
			new AxisAlignedBB(-0.03125D, 0.0D, -0.03125D, 0.125D, 1.09375D, 0.125D),
			new AxisAlignedBB(-0.09375D, 1.0625D, -0.09375D, 0.03125D, 1.1875D, 0.03125D),
			new AxisAlignedBB(-0.15625D, 1.125D, -0.15625D, -0.0625D, 1.3125D, -0.0625D),
			new AxisAlignedBB(-0.09375D, 1.28125D, -0.15625D, 0.0D, 1.4375D, -0.0625D),
			new AxisAlignedBB(-0.03125D, 1.40625D, -0.09375D, 0.03125D, 1.5625D, -0.03125D),
			new AxisAlignedBB(1.03125D, 1.40625D, -0.03125D, 1.09375D, 1.5625D, 0.03125D),
			new AxisAlignedBB(0.96875D, 1.0625D, -0.09375D, 1.09375D, 1.1875D, 0.03125D),
			new AxisAlignedBB(0.875D, 0.0D, -0.03125D, 1.03125D, 1.09375D, 0.125D),
			new AxisAlignedBB(1.0625D, 1.125D, -0.15625D, 1.15625D, 1.3125D, -0.0625D),
			new AxisAlignedBB(1.0625D, 1.28125D, -0.09375D, 1.15625D, 1.4375D, 0.0D)
	};

	public static final AxisAlignedBB MASTER_TOTEM_BOUNDING_BOX = new AxisAlignedBB(0.0D, -1.0D, 0.0D, 1.0D, 2.0D, 1.0D);
}
