package dev.bumblecat.bumblecore.client.windows.events;

import dev.bumblecat.bumblecore.client.windows.widgets.IWidget;

public class WidgetEvent extends Event {

    private final EventArgs<?> arguments;

    private final IWidget widget;

    public WidgetEvent(IWidget widget, EventArgs<?> arguments) {
        super(widget.getWindow());
        this.widget = widget;
        this.arguments = arguments;
        this.arguments.setOwner(this);
    }

    /**
     * @return
     */
    public IWidget getWidget() {
        return this.widget;
    }

    /**
     * @return
     */
    public EventArgs<?> getArguments() {
        return this.arguments;
    }
}
