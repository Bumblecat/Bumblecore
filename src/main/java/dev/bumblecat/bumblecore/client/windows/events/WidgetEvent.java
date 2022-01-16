package dev.bumblecat.bumblecore.client.windows.events;

import dev.bumblecat.bumblecore.client.windows.widgets.IWidget;

public class WidgetEvent extends Event {

    private final EventArgs<?> arguments;

    public WidgetEvent(IWidget widget, EventArgs<?> arguments) {
        super(widget.getWindow());
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
