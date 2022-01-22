package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.common.conveys.EventArgs;
import dev.bumblecat.bumblecore.common.conveys.IEventType;

abstract class WindowEventArgs<T> extends EventArgs<T> {


    public WindowEventArgs(IEventType eventType) {
        super(eventType);
    }
}
