package dev.bumblecat.bumblecore.common.windows;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.awt.*;

abstract class CommonWindowAbstract extends AbstractContainerMenu {

    private final Inventory inventory;
    private final int slotCount;

    protected CommonWindowAbstract(MenuType<?> provider, int providerId, Inventory inventory) {
        this(provider, providerId, inventory, 0);
    }


    protected CommonWindowAbstract(MenuType<?> provider, int providerId, Inventory inventory, int slotCount) {
        super(provider, providerId);

        this.inventory = inventory;
        this.slotCount = slotCount;
    }


    /**
     * @param position
     */
    public void addPlayerInventory(Point position) {

        int posX = 0, posY = 0;
        for (int i = 0; i < 3; ++i) {
            posY = i * 18;
            for (int j = 0; j < 9; ++j) {
                posX = j * 18;
                addSlot(new Slot(this.getPlayerInventory(), j + i * 9 + 9,
                        (int) (position.getX() + 8) + posX,
                        (int) (position.getY() + 18) + posY
                ));
            }
        }

        posY = posY + (4 + 18);
        for (int i = 0; i < 9; ++i) {
            posX = i * 18;
            addSlot(new Slot(this.getPlayerInventory(), i,
                    (int) (position.getX() + 8) + posX,
                    (int) (position.getY() + 18) + posY
            ));
        }
    }


    public Player getPlayer() {
        return this.inventory.player;
    }

    /**
     * @return
     */
    public Inventory getPlayerInventory() {
        return this.inventory;
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
