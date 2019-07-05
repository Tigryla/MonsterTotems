package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityTotemBase;
import io.github.mspacedev.utils.Utils;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.Random;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockTotemBase extends BlockWoodBase {
    private String radiusText;
    private String tooltipText;

    public BlockTotemBase(String name, Material materialIn, String radiusText) {
        super(name, materialIn);
        this.tooltipText = "tooltip.totem_base";
        this.radiusText = radiusText;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if(!worldIn.isRemote) {
            if(worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityTotemBase) {
                    TileEntityTotemBase totem_base = (TileEntityTotemBase) worldIn.getTileEntity(pos);
                    totem_base.setTotemProperties();
                }
            }
        }

        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote) {
            if(worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityTotemBase) {
                    TileEntityTotemBase totem_base = (TileEntityTotemBase) worldIn.getTileEntity(pos);
                    totem_base.setTotemProperties();
                }
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        if(tooltipText == null){
            tooltip.add(I18n.format("tooltip.missing"));
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add(I18n.format(tooltipText));
            tooltip.add(I18n.format(radiusText));
        } else {
            tooltip.add(I18n.format("tooltip.shift"));
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        if (!world.isRemote)
        {
            TileEntity base = world.getTileEntity(pos);

            if (base instanceof TileEntityTotemBase)
            {
                TileEntityTotemBase tile = (TileEntityTotemBase) base;

                if (tile.isCooldownOver())
                {
                    ITextComponent component = new TextComponentString("");

                    if (tile.hasActiveTotemHeads())
                    {
                        component.appendText(I18n.format("base.prevent"));
                        if (tile.hasZombie)
                            component.appendText("\n" + I18n.format("base.zombies"));
                        if (tile.hasCreeper)
                            component.appendText("\n" + I18n.format("base.creepers"));
                        if (tile.hasSkeleton)
                            component.appendText("\n" + I18n.format("base.skeletons"));
                        if (tile.hasSpider)
                            component.appendText("\n" + I18n.format("base.spiders"));
                        if (tile.hasEnderman)
                            component.appendText("\n" + I18n.format("base.endermen"));
                        if (tile.hasWitch)
                            component.appendText("\n" + I18n.format("base.witches"));
                        if (tile.hasSilverfish)
                            component.appendText("\n" + I18n.format("base.silverfish"));
                        if (tile.hasSlime)
                            component.appendText("\n" + I18n.format("base.slimes"));
                        if (tile.hasBlaze)
                            component.appendText("\n" + I18n.format("base.blazes"));
                        if (tile.hasZombiePigman)
                            component.appendText("\n" + I18n.format("base.zombie_pigmen"));
                        if (tile.hasGhast)
                            component.appendText("\n" + I18n.format("base.ghasts"));
                        if (tile.hasMagmaCube)
                            component.appendText("\n" + I18n.format("base.magma_cubes"));
                    }
                    else
                    {
                        component.appendText(I18n.format("base.no_active_heads"));
                    }

                    player.sendMessage(component);
                }
            }
        }

        return true;
    }
}
