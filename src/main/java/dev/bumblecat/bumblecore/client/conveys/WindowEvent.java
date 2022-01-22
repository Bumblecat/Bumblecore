package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;
import dev.bumblecat.bumblecore.common.conveys.IEventArgs;

public class WindowEvent extends ClientEvent {

    public WindowEvent(IClientWindow window, IEventArgs arguments) {
        super(window, arguments);
        this.getArguments().setEvent(this);
    }
}
