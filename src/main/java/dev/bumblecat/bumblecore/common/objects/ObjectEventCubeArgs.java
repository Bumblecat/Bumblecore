package dev.bumblecat.bumblecore.common.objects;

import dev.bumblecat.bumblecore.common.conveys.IEventType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ObjectEventCubeArgs extends ObjectEventArgs {

    private final BlockState blockState;
    private final BlockPos blockPos;
    private final BlockHitResult hitResult;


    public ObjectEventCubeArgs(IEventType eventType, Level level, Entity entity, InteractionHand hand) {
        this(eventType, level, entity, hand, null, null);
    }


    public ObjectEventCubeArgs(IEventType eventType, Level level, Entity entity, InteractionHand hand, BlockState blockState, BlockPos blockPos) {
        this(eventType, level, entity, hand, blockState, blockPos, null);
    }

    public ObjectEventCubeArgs(IEventType eventType, Level level, Entity entity, InteractionHand hand, BlockState blockState, BlockPos blockPos, BlockHitResult hitResult) {
        super(eventType, level, entity, hand);

        this.blockState = blockState;
        this.blockPos = blockPos;
        this.hitResult = hitResult;
    }



    public BlockState getBlockState() {
        return this.blockState;
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public BlockHitResult getHitResult() {
        return this.hitResult;
    }
}
