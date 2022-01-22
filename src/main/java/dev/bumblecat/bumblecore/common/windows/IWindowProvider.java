package dev.bumblecat.bumblecore.common.windows;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import org.jetbrains.annotations.Nullable;

public interface IWindowProvider extends MenuProvider {

    /**
     * @param windowId
     * @param inventory
     * @param player
     *
     * @return
     */
    ICommonWindow getWindow(int windowId, Inventory inventory, Player player);

    /**
     * @return
     */
    @Override
    Component getDisplayName();

    /**
     * @param windowId
     * @param inventory
     * @param player
     *
     * @return
     */
    @Nullable
    @Override
    default AbstractContainerMenu createMenu(int windowId, Inventory inventory, Player player) {

        /**
         * re-route to getWindow(a, b, c)
         */
        return (CommonWindow) getWindow(windowId, inventory, player);
    }
}
