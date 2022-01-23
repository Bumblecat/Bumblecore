package dev.bumblecat.bumblecore.common.objects.cubes;

import dev.bumblecat.bumblecore.common.objects.IObject;
import dev.bumblecat.bumblecore.common.objects.InteractionResult;
import dev.bumblecat.bumblecore.common.objects.ObjectEventCubeArgs;
import dev.bumblecat.bumblecore.common.objects.ObjectEventType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

abstract class CustomCubeAbstract extends Block {

    /**
     *
     */
    protected CustomCubeAbstract() {
        this(new Behaviour());
    }

    /**
     * @param behaviour
     */
    protected CustomCubeAbstract(Behaviour behaviour) {
        this(behaviour.resolve());
    }

    /**
     * @param properties
     */
    protected CustomCubeAbstract(Properties properties) {
        super(properties);
    }


    //public abstract InteractionResult onInteract(Level level, Player player, InteractionHand hand, BlockState blockState, BlockPos blockPos, BlockHitResult hitResult);


    public abstract InteractionResult<BlockState> onInteract(BlockState state, ObjectEventCubeArgs arguments);
    //public abstract InteractionResult<BlockState> onInteractFinished(BlockState state, ObjectEventCubeArgs arguments);



    @Override
    public net.minecraft.world.InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
        return onInteract(p_60503_, new ObjectEventCubeArgs(ObjectEventType.Interacting, p_60504_, p_60506_, p_60507_, p_60503_, p_60505_, p_60508_)).getResult();
    }






    /**
     * @param p_60503_
     * @param p_60504_
     * @param p_60505_
     * @param p_60506_
     * @param p_60507_
     * @param p_60508_
     *
     * @return
     */
    @SuppressWarnings("deprecation")
//    @Override
//    public final InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
//        return onInteract(p_60504_, p_60506_, p_60507_, p_60503_, p_60505_, p_60508_);
//    }





    /**
     * @param blockPos
     * @param blockState
     *
     * @return
     */
    public final BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        if (this instanceof ITileEntityCube) {
            return (BlockEntity) ((ITileEntityCube) this).getTileEntity(blockState, blockPos);
        }
        return null;
    }
}
