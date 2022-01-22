package dev.bumblecat.bumblecore.client.windows;

import dev.bumblecat.bumblecore.client.conveys.WidgetEvent;
import dev.bumblecat.bumblecore.client.conveys.WindowEvent;
import dev.bumblecat.bumblecore.client.windows.widgets.IWidget;

import java.awt.*;

import org.jetbrains.annotations.NotNull;

public interface IClientWindow {

    default void onWindowCreated() {
    }

    default void onWindowLoading() {
    }

    default void onWindowRendering(WindowEvent event) {
    }

    default void onWidgetRendering(WidgetEvent event) {
    }

    default void onWidgetAttached(IWidget widget) {
    }

    default void onWidgetDetached(IWidget widget) {
    }


    /**
     * Defines what texture is to be used to draw the window.
     * (WindowType.Generic & WindowType.Machine)
     *
     * @return
     */
    @NotNull WindowType getWindowType();

    /**
     * @return
     */
    int getLabelColor();

    /**
     * @param value
     */
    void setLabelColor(int value);

    /**
     * @return
     */
    Point getLocation();


    /**
     * @return
     */
    Dimension getScreenSize();

    /**
     * @return
     */
    Dimension getSize();

    /**
     * @param dimension
     */
    void setSize(Dimension dimension);

    /**
     * @param w
     * @param h
     */
    void setSize(int w, int h);


}
