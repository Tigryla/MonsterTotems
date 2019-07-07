package io.github.mspacedev.blocks;

import io.github.mspacedev.blocks.infusedlogs.*;
import io.github.mspacedev.blocks.totembases.BlockTotemBaseI;
import io.github.mspacedev.blocks.totembases.BlockTotemBaseII;
import io.github.mspacedev.blocks.totembases.BlockTotemBaseIII;
import io.github.mspacedev.blocks.totemheads.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ModBlocks
{
	// Infused Logs
	public static final Block zombie_infused_log = new BlockZombieInfusedLog("zombie_infused_log", Material.WOOD);
	public static final Block skeleton_infused_log = new BlockSkeletonInfusedLog("skeleton_infused_log", Material.WOOD);
	public static final Block creeper_infused_log = new BlockCreeperInfusedLog("creeper_infused_log", Material.WOOD);
	public static final Block spider_infused_log = new BlockSpiderInfusedLog("spider_infused_log", Material.WOOD);
	public static final Block enderman_infused_log = new BlockEndermanInfusedLog("enderman_infused_log", Material.WOOD);
	public static final Block witch_infused_log = new BlockWitchInfusedLog("witch_infused_log", Material.WOOD);
	public static final Block silverfish_infused_log = new BlockSilverfishInfusedLog("silverfish_infused_log", Material.WOOD);
	public static final Block slime_infused_log = new BlockSlimeInfusedLog("slime_infused_log", Material.WOOD);
	public static final Block blaze_infused_log = new BlockBlazeInfusedLog("blaze_infused_log", Material.WOOD);
	public static final Block zombie_pigman_infused_log = new BlockZombiePigmanInfusedLog("zombie_pigman_infused_log", Material.WOOD);
	public static final Block ghast_infused_log = new BlockGhastInfusedLog("ghast_infused_log", Material.WOOD);
	public static final Block magma_cube_infused_log = new BlockMagmaCubeInfusedLog("magma_cube_infused_log", Material.WOOD);

	// Totem Heads
	public static final Block zombie_totem = new BlockZombieTotem("zombie_totem", Material.WOOD);
	public static final Block skeleton_totem = new BlockSkeletonTotem("skeleton_totem", Material.WOOD);
	public static final Block creeper_totem = new BlockCreeperTotem("creeper_totem", Material.WOOD);
	public static final Block spider_totem = new BlockSpiderTotem("spider_totem", Material.WOOD);
	public static final Block enderman_totem = new BlockEndermanTotem("enderman_totem", Material.WOOD);
	public static final Block witch_totem = new BlockWitchTotem("witch_totem", Material.WOOD);
	public static final Block silverfish_totem = new BlockSilverfishTotem("silverfish_totem", Material.WOOD);
	public static final Block slime_totem = new BlockSlimeTotem("slime_totem", Material.WOOD);
	public static final Block blaze_totem = new BlockBlazeTotem("blaze_totem", Material.WOOD);
	public static final Block zombie_pigman_totem = new BlockZombiePigmanTotem("zombie_pigman_totem", Material.WOOD);
	public static final Block ghast_totem = new BlockGhastTotem("ghast_totem", Material.WOOD);
	public static final Block magma_cube_totem = new BlockMagmaCubeTotem("magma_cube_totem", Material.WOOD);

	// Totem Bases
	public static final Block totem_base_i = new BlockTotemBaseI("totem_base_i", Material.WOOD);
	public static final Block totem_base_ii = new BlockTotemBaseII("totem_base_ii", Material.WOOD);
	public static final Block totem_base_iii = new BlockTotemBaseIII("totem_base_iii", Material.WOOD);

	// Misc Totems

	public static final Block[] BLOCKS = {
			// Infused Logs
			zombie_infused_log,
			skeleton_infused_log,
			creeper_infused_log,
			spider_infused_log,
			enderman_infused_log,
			witch_infused_log,
			silverfish_infused_log,
			slime_infused_log,
			blaze_infused_log,
			zombie_pigman_infused_log,
			ghast_infused_log,
			magma_cube_infused_log,
			// Totem Heads
			zombie_totem,
			skeleton_totem,
			creeper_totem,
			spider_totem,
			enderman_totem,
			witch_totem,
			silverfish_totem,
			slime_totem,
			blaze_totem,
			zombie_pigman_totem,
			ghast_totem,
			magma_cube_totem,
			// Totem Bases
			totem_base_i,
			totem_base_ii,
			totem_base_iii,
	};
}
