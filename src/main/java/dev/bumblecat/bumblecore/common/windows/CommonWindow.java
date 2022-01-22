package dev.bumblecat.bumblecore.common.windows;

import dev.bumblecat.bumblecore.common.objects.cubes.tiles.ICustomTileEntity;
import dev.bumblecat.bumblecore.common.storage.IInventory;
import dev.bumblecat.bumblecore.common.storage.IInventoryProvider;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public abstract class CommonWindow<T extends ICustomTileEntity> extends CommonWindowAbstract implements ICommonWindow {

    private final IInventory inventory;
    private final T blockEntity;

    /**
     * @param provider
     * @param windowId
     * @param inventory
     */
    public CommonWindow(MenuType<?> provider, int windowId, Inventory inventory) {
        this(provider, windowId, inventory, 0);
    }

    /**
     * @param provider
     * @param windowId
     * @param inventory
     * @param blockPos
     */
    public CommonWindow(MenuType<?> provider, int windowId, Inventory inventory, BlockPos blockPos) {
        this(provider, windowId, inventory, blockPos, 0);
    }

    /**
     * @param provider
     * @param windowId
     * @param inventory
     * @param slotCount
     */
    public CommonWindow(MenuType<?> provider, int windowId, Inventory inventory, int slotCount) {
        this(provider, windowId, inventory, null, slotCount);
    }

    /**
     * @param provider
     * @param windowId
     * @param inventory
     * @param slotCount
     * @param blockPos
     */
    public CommonWindow(MenuType<?> provider, int windowId, Inventory inventory, BlockPos blockPos, int slotCount) {
        super(provider, windowId, inventory, slotCount);

        this.blockEntity = (blockPos != null) ? (T) getPlayer().getLevel().getBlockEntity(blockPos) : null;
        this.inventory = (this.blockEntity instanceof IInventoryProvider) ? ((IInventoryProvider) this.blockEntity).getInventory() : null;
    }

    /**
     * @return
     */
    public T getBlockEntity() {
        return this.blockEntity;
    }

    /**
     * @return
     */
    public IInventory getWindowInventory() {
        return this.inventory;
    }
}