package io.github.mspacedev.entities;

import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.World;

public class EntitySpiritMagmaCube extends EntityMagmaCube
{
    public EntitySpiritMagmaCube(World worldIn)
    {
        super(worldIn);
    }

    public EntitySpiritMagmaCube(World worldIn, int size) {
        super(worldIn);
        this.setSlimeSize(size, true);
    }
}