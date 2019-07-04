package io.github.mspacedev.utils;

import io.github.mspacedev.entities.*;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class Reference {
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
}
