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
    public CustomTileEntity(BlockEntityType<?> entityType, BlockPos blockPos, BlockState blockState) {
        this(null, entityType, blockPos, blockState);
    }

    /**
     *
     * @param object
     * @param entityType
     * @param blockPos
     * @param blockState
     */
    public CustomTileEntity(T object, BlockEntityType<?> entityType, BlockPos blockPos, BlockState blockState) {
        super(entityType, blockPos, blockState);
        this.object = object;
    }


    /**
     *
     * @return
     */
    public TranslatableComponent getDescription() {
        return new TranslatableComponent(this.object.getDescriptionId());
    }

    /**
     *
     * @return
     */
    public  T getOwner() {
        return (T)this.object;
    }
}
