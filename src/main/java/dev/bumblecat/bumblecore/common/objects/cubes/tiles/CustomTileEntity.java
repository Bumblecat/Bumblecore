package dev.bumblecat.bumblecore.common.objects.cubes.tiles;

import dev.bumblecat.bumblecore.common.objects.cubes.CustomCube;

import dev.bumblecat.bumblecore.common.objects.cubes.ICustomCube;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CustomTileEntity<T extends CustomCube> extends CustomTileEntityAbstract implements ICustomTileEntity {

    private final T object;

    /**
     * @param entityType
     * @param blockPos
     * @param blockState
     */
    public CustomTileEntity(BlockEntityType<?> entityType, BlockState blockState, BlockPos blockPos) {
        this(null, entityType, blockState, blockPos);
    }

    /**
     * @param object
     * @param entityType
     * @param blockPos
     * @param blockState
     */
    public CustomTileEntity(T object, BlockEntityType<?> entityType, BlockState blockState, BlockPos blockPos) {
        super(entityType, blockState, blockPos);
        this.object = object;
    }


    /**
     * @return
     */
    public TranslatableComponent getDescription() {
        return new TranslatableComponent(this.object.getDescriptionId());
    }


    /**
     * @param <T>
     * @return
     */
    @Override
    public <T extends CustomCube> T getOwner() {
        return (T) this.object;
    }
}
