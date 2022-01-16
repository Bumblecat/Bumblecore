package dev.bumblecat.bumblecore.client.windows.events;

import dev.bumblecat.bumblecore.client.windows.widgets.IWidget;

abstract class WidgetEventArgs<T> extends EventArgs<T> {

    private final IWidget widget;

    /**
     *
     * @param widget
     */
    public WidgetEventArgs(IWidget widget) {
        this.widget = widget;
    }
}
