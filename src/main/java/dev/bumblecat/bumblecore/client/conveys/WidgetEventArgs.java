package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.common.conveys.EventArgs;
import dev.bumblecat.bumblecore.common.conveys.IEventType;

abstract class WidgetEventArgs<T> extends EventArgs<T> {

    public WidgetEventArgs(IEventType eventType) {
        super(eventType);
    }
}
