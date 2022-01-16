package dev.bumblecat.bumblecore.client.windows.events;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

public abstract class Event {

    private final IClientWindow window;

    public Event(IClientWindow window) {
        this.window = window;
    }

    /**
     * @return
     */
    public IClientWindow getWindow() {
        return this.window;
    }


    public abstract EventArgs<?> getArguments();
}
