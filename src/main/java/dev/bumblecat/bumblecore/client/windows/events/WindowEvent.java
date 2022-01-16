package dev.bumblecat.bumblecore.client.windows.events;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

public class WindowEvent extends Event {

    private final EventArgs<?> arguments;

    public WindowEvent(IClientWindow window, EventArgs<?> arguments) {
        super(window);
        this.arguments = arguments;
        this.arguments.setOwner(this);
    }


    /**
     * @return
     */
    public EventArgs<?> getArguments() {
        return this.arguments;
    }
}
