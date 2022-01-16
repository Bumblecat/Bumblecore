package dev.bumblecat.bumblecore.client.objects.cubes;

import dev.bumblecat.bumblecore.client.objects.IDyeable;

import net.minecraft.client.color.block.BlockColor;

import net.minecraftforge.api.distmarker.*;

public interface IDyeableCube extends IDyeable {

    /**
     * @return
     */
    @OnlyIn(Dist.CLIENT)
    BlockColor getColor();
}
