package dev.bumblecat.bumblecore.common.windows;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;

abstract class CommonWindowAbstract extends AbstractContainerMenu {

    private final int slotCount;

    /**
     * @param windowType
     * @param windowId
     * @param slots
     */
    protected CommonWindowAbstract(@Nullable MenuType<?> windowType, int windowId, int slots) {
        super(windowType, windowId);
        this.slotCount = slots;
    }

    /**
     * @param player
     * @param index
     *
     * @return
     */
    @Override
    public ItemStack quickMoveStack(Player player, int index) {

        ItemStack current, results = ItemStack.EMPTY;
        Slot slot = getSlot(index);

        if (slot.hasItem()) {
            current = slot.getItem();
            results = current.copy();

            if (index < this.getTotalSlots()) {
                if (!moveItemStackTo(current, 9, slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(current, 0, 9, false)) {
                return ItemStack.EMPTY;
            }

            if (current.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return results;
    }


    /**
     * @return
     */
    public int getTotalSlots() {
        return this.slotCount;
    }

    /**
     * @param player
     *
     * @return
     */
    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
