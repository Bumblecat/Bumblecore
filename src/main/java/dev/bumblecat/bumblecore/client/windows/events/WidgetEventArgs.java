package dev.bumblecat.bumblecore.client.windows.events;

abstract class WidgetEventArgs<T> extends EventArgs<T> {

    public WidgetEventArgs(IEventType eventType) {
        super(eventType);
    }
}
