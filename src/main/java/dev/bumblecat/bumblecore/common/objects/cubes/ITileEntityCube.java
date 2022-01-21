package dev.bumblecat.bumblecore.common.objects.cubes;

import dev.bumblecat.bumblecore.common.objects.cubes.tiles.ICustomTileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.Nullable;

public interface ITileEntityCube extends EntityBlock, IDismantable {


    /**
     *
     * @param blockState
     * @param blockPos
     * @return
     */
    ICustomTileEntity getTileEntity(BlockState blockState, BlockPos blockPos);


    /**
     * @param blockPos
     * @param blockState
     *
     * @return
     */
    @Nullable
    @Override
    default BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return (BlockEntity) getTileEntity(blockState, blockPos);
    }
}
