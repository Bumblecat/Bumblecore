package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.client.windows.widgets.IWidget;
import dev.bumblecat.bumblecore.common.conveys.IEventArgs;

public class WidgetEvent extends ClientEvent {

    private final IWidget widget;

    public WidgetEvent(IWidget widget, IEventArgs arguments) {
        super(widget.getWindow(), arguments);

        this.widget = widget;
        this.getArguments().setEvent(this);
    }

    /**
     * @return
     */
    public IWidget getWidget() {
        return this.widget;
    }
}
