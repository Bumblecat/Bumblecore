package dev.bumblecat.bumblecore.common.windows;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import java.awt.*;

import org.jetbrains.annotations.Nullable;

public abstract class CommonWindow extends CommonWindowAbstract implements ICommonWindow {

    private final Inventory playerInventory;

    /**
     * @param windowType
     * @param windowId
     * @param inventory
     */
    public CommonWindow(@Nullable MenuType<?> windowType, int windowId, Inventory inventory) {
        this(windowType, windowId, inventory, 0);
    }

    /**
     * @param windowType
     * @param windowId
     * @param inventory
     * @param slots
     */
    public CommonWindow(@Nullable MenuType<?> windowType, int windowId, Inventory inventory, int slots) {
        super(windowType, windowId, slots);
        this.playerInventory = inventory;
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


    /**
     * @return
     */
    public Inventory getPlayerInventory() {
        return this.playerInventory;
    }
}
