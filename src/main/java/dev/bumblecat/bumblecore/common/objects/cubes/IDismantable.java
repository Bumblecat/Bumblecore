package dev.bumblecat.bumblecore.common.objects.cubes;

import net.minecraft.world.item.ItemStack;

public interface IDismantable {

    default ItemStack doDismantleCube() {
        return null;
    }

    default boolean isDismantable() {
        return false;
    }
}
