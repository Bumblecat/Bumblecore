package dev.bumblecat.bumblecore.common.storage;

import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IInventoryProvider {

    /**
     * Gets the inventory associated with this.
     *
     * @return
     */
    @NotNull
    default IInventory getInventory() {
        return getInventory(null);
    }

    /**
     * Gets the inventory associated with the ItemStack
     * or This when ItemStack is null.
     *
     * @param stack
     *
     * @return
     */
    IInventory getInventory(@Nullable ItemStack stack);
}
