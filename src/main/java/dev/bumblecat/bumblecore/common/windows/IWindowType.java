package dev.bumblecat.bumblecore.common.windows;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;

public interface IWindowType<T> {

    /**
     * @param windowId
     * @param inventory
     * @param blockPos
     *
     * @return
     */
    T create(int windowId, Inventory inventory, BlockPos blockPos);

    /**
     * @param windowId
     * @param inventory
     * @param count
     *
     * @return
     */
    T create(int windowId, Inventory inventory, int count);
}
