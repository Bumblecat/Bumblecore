package dev.bumblecat.bumblecore.common.windows;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.network.NetworkHooks;

public class WindowFactory {

    /**
     * @param window
     * @param <T>
     *
     * @return
     */
    public static <T extends CommonWindow> MenuType<T> construct(IWindowType<T> window) {
        return new MenuType<>(factorize(window));
    }

    /**
     * @param window
     * @param <T>
     *
     * @return
     */
    public static <T extends CommonWindow> IContainerFactory<T> factorize(IWindowType<T> window) {
        return (windowId, inventory, byteBuffer) -> window.create(windowId, inventory, byteBuffer.readBlockPos());
    }


    /**
     * @param player
     * @param provider
     * @param <T>
     *
     * @return
     */
    public static <T extends CommonWindow> InteractionResult callWindow(Player player, IWindowProvider provider) {
        if (player.getLevel().isClientSide())
            return InteractionResult.SUCCESS;

        NetworkHooks.openGui((ServerPlayer) player, provider);
        return InteractionResult.CONSUME;
    }


    /**
     * @param player
     * @param blockPos
     * @param window
     * @param <T>
     *
     * @return
     */
    public static <T extends CommonWindow> InteractionResult callWindow(Player player, BlockPos blockPos, IWindowType<T> window) {
        if (player.getLevel().isClientSide())
            return InteractionResult.SUCCESS;

        NetworkHooks.openGui((ServerPlayer) player, new WindowProvider<>(player, blockPos, window), buffer -> buffer.writeBlockPos(blockPos));
        return InteractionResult.CONSUME;
    }
}
