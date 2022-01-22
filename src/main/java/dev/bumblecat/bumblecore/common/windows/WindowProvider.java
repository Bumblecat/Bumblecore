package dev.bumblecat.bumblecore.common.windows;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuConstructor;

public class WindowProvider<T extends CommonWindow> implements IWindowProvider {

    private final MenuConstructor constructor;
    private final TranslatableComponent description;

    /**
     * @param player
     * @param blockPos
     * @param window
     */
    public WindowProvider(Player player, BlockPos blockPos, IWindowType<T> window) {
        this.constructor = (windowId, inventory, serverPlayer) -> window.create(windowId, inventory, blockPos);
        this.description = new TranslatableComponent(player.getLevel().getBlockState(blockPos).getBlock().getDescriptionId());
    }

    /**
     * @param windowId
     * @param inventory
     * @param player
     *
     * @return
     */
    @Override
    public ICommonWindow getWindow(int windowId, Inventory inventory, Player player) {
        return (ICommonWindow) this.constructor.createMenu(windowId, inventory, player);
    }

    /**
     * @return
     */
    @Override
    public Component getDisplayName() {
        return this.description;
    }
}
