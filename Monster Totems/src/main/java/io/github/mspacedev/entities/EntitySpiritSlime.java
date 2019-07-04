package io.github.mspacedev.entities;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.World;

public class EntitySpiritSlime extends EntitySlime
{
    public EntitySpiritSlime(World worldIn)
    {
        super(worldIn);
    }

    public EntitySpiritSlime(World worldIn, int size) {
        super(worldIn);
        this.setSlimeSize(size, true);
    }

    @Override
    protected EntitySlime createInstance()
    {
        return new EntitySpiritSlime(this.world);
    }
}