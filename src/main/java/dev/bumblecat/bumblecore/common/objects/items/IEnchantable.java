package dev.bumblecat.bumblecore.common.objects.items;

import net.minecraft.world.item.ItemStack;

public interface IEnchantable {

    /**
     * Returns whether this item can be enchanted or not.
     *
     * @param stack
     *
     * @return
     */
    boolean isEnchantable(ItemStack stack);
}
