package dev.bumblecat.bumblecore.client.windows.events;

abstract class WindowEventArgs<T> extends EventArgs<T> {


    public WindowEventArgs(IEventType eventType) {
        super(eventType);
    }
}
