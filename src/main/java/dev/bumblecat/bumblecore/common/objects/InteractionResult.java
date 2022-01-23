package dev.bumblecat.bumblecore.common.objects;

import net.minecraft.world.InteractionResultHolder;

public class InteractionResult<T> extends InteractionResultHolder<T> {

    public InteractionResult(T object, InteractionResultType result) {
        super(result.getResult(), object);
    }

    @Override
    public net.minecraft.world.InteractionResult getResult() {
        return super.getResult();
    }
}
