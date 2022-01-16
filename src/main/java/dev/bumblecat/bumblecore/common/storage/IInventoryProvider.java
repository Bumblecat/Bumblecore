package dev.bumblecat.bumblecore.common.storage;

import net.minecraft.world.item.ItemStack;

public interface IInventoryProvider {

    /**
     * Gets the inventory associated with the ItemStack.
     *
     * @param itemStack
     *
     * @return
     */
    IInventory getInventory(ItemStack itemStack);
}
