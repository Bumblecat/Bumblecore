package dev.bumblecat.bumblecore.common.conveys;

import dev.bumblecat.bumblecore.common.objects.IObject;

public class InteractionEvent<T> extends Event {

    private final IObject object;

    /**
     * @param arguments
     */
    public InteractionEvent(IObject object, IEventArgs arguments) {
        super(arguments);
        this.object = object;
    }
}
