package dev.bumblecat.bumblecore.common.objects.cubes;

import dev.bumblecat.bumblecore.common.objects.cubes.tiles.ICustomTileEntity;
import dev.bumblecat.bumblecore.common.windows.IWindowProvider;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import net.minecraftforge.network.NetworkHooks;

public class CustomCube extends CustomCubeAbstract implements ICustomCube {

    /**
     *
     */
    public CustomCube() {
        this(new Behaviour());
    }

    /**
     * @param behaviour
     */
    public CustomCube(Behaviour behaviour) {
        super(behaviour);
    }

    /**
     *
     * @param level
     * @param player
     * @param hand
     * @param blockState
     * @param blockPos
     * @param hitResult
     * @return
     */
    @Override
    public InteractionResult onInteract(Level level, Player player, InteractionHand hand, BlockState blockState, BlockPos blockPos, BlockHitResult hitResult) {
        if (level.isClientSide())
            return InteractionResult.SUCCESS;

        if (this instanceof ITileEntityCube) {
            ICustomTileEntity entity = ((ITileEntityCube) this).getTileEntity(blockState, blockPos);
            if (entity != null && entity instanceof IWindowProvider) {
                NetworkHooks.openGui((ServerPlayer) player, (IWindowProvider) entity, ((BlockEntity) entity).getBlockPos());
            }
        }
        return InteractionResult.PASS;
    }
}
