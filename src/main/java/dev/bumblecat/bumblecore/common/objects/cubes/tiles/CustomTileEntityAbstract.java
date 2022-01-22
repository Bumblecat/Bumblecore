package dev.bumblecat.bumblecore.common.objects.cubes.tiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

abstract class CustomTileEntityAbstract extends BlockEntity {


    public CustomTileEntityAbstract(BlockEntityType<?> entityType, BlockState blockState, BlockPos blockPos) {
        super(entityType, blockPos, blockState);
    }
}
