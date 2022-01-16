package dev.bumblecat.bumblecore.client.objects.items;

import dev.bumblecat.bumblecore.client.objects.IDyeable;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.*;

import org.jetbrains.annotations.Nullable;

public interface IDyeableItem extends IDyeable {

    /**
     * @param stack
     *
     * @return
     */
    @OnlyIn(Dist.CLIENT)
    ItemColor getColor(@Nullable ItemStack stack);
}
