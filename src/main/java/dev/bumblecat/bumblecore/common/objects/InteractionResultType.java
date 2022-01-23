package dev.bumblecat.bumblecore.common.objects;

import net.minecraft.world.InteractionResult;

public enum InteractionResultType {
    SUCCESS(InteractionResult.SUCCESS),
    CONSUME(InteractionResult.CONSUME),
    CONSUME_PARTIAL(InteractionResult.CONSUME_PARTIAL),
    PASS(InteractionResult.PASS),
    FAIL(InteractionResult.FAIL);

    private final InteractionResult result;


    InteractionResultType(InteractionResult result) {
        this.result = result;
    }

    public InteractionResult getResult() {
        return this.result;
    }
}
