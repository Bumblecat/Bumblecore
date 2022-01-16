package dev.bumblecat.bumblecore.common.storage;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.items.ItemStackHandler;

public class InventoryHandler extends ItemStackHandler implements IInventory {

    /**
     *
     */
    public InventoryHandler() {
        this(1);
    }

    /**
     * @param size
     */
    public InventoryHandler(int size) {
        super(size);
    }

    /**
     * @param stacks
     */
    public InventoryHandler(NonNullList<ItemStack> stacks) {
        super(stacks);
    }


    /**
     * @return
     */
    @Override
    public int getObjectCount() {
        int num = 0;
        for (int i = 0; i < getSlots(); i++) {
            if (getStackInSlot(i) != ItemStack.EMPTY) {
                num += getStackInSlot(i).getCount();
            }
        }
        return num;
    }

    /**
     * @return
     */
    @Override
    public int getObjectCountByStackSize() {
        int num = 0;
        for (int i = 0; i < getSlots(); i++) {
            if (getStackInSlot(i) != ItemStack.EMPTY) {
                num += Math.max(getSlotLimit(i), getStackInSlot(i).getCount());
            }
        }
        return num;
    }


    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return !(getObjectCount() > 0);
    }
}
