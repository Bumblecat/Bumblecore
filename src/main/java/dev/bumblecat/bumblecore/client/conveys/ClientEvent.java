package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;
import dev.bumblecat.bumblecore.common.conveys.Event;
import dev.bumblecat.bumblecore.common.conveys.IEventArgs;

abstract class ClientEvent extends Event implements IClientEvent {

    private final IClientWindow window;

    public ClientEvent(IClientWindow window, IEventArgs arguments) {
        super(arguments);

        this.window = window;
    }

    /**
     * @return
     */
    public IClientWindow getWindow() {
        return this.window;
    }
}
