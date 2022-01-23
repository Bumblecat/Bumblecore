package dev.bumblecat.bumblecore.common.objects;

import dev.bumblecat.bumblecore.common.conveys.Event;
import dev.bumblecat.bumblecore.common.conveys.IEvent;
import dev.bumblecat.bumblecore.common.conveys.IEventArgs;

public class ObjectEvent<T> extends Event implements IEvent {

    private final T object;

    /**
     * @param arguments
     */
    public ObjectEvent(T object, IEventArgs arguments) {
        super(arguments);
        this.object = object;
    }

    /**
     * @return
     */
    public T getObject() {
        return this.object;
    }
}
