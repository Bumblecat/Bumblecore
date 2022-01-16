package dev.bumblecat.bumblecore.client.windows.events;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

abstract class Event {

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
}
