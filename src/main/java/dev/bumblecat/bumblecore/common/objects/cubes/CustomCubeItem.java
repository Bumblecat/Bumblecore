package dev.bumblecat.bumblecore.common.objects.cubes;

import dev.bumblecat.bumblecore.common.objects.items.Variables;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class CustomCubeItem extends BlockItem {

    public CustomCubeItem(CustomCube parent) {
        this(parent, new Variables());
    }

    public CustomCubeItem(CustomCube parent, Variables variables) {
        this(parent, variables.resolve());
    }


    public CustomCubeItem(Block parent, Properties properties) {
        super(parent, properties);
    }
}
