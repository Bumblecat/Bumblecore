package dev.bumblecat.bumblecore.common.storage;

import net.minecraft.nbt.CompoundTag;

import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandler;

public interface IInventory extends IItemHandler, INBTSerializable<CompoundTag> {

    /**
     * Returns whether this inventory is empty or not.
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Returns the amount of objects stored in this inventory
     *
     * @return
     */
    int getObjectCount();

    /**
     * Returns the amount of objects stored in this inventory, taking StackSize into account.
     * i.e. un-stackable items count as a full stack.
     *
     * @return
     */
    int getObjectCountByStackSize();
}
