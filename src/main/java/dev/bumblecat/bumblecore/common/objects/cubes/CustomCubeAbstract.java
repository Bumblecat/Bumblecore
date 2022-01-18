package dev.bumblecat.bumblecore.common.objects.cubes;

import net.minecraft.world.level.block.Block;

abstract class CustomCubeAbstract extends Block {

    /**
     *
     */
    protected CustomCubeAbstract() {
        this(new Behaviour());
    }

    /**
     *
     * @param behaviour
     */
    protected CustomCubeAbstract(Behaviour behaviour) {
        this(behaviour.resolve());
    }

    /**
     *
     * @param properties
     */
    protected CustomCubeAbstract(Properties properties) {
        super(properties);
    }

}
