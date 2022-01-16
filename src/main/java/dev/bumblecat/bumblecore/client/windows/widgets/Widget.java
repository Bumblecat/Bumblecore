package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;
import dev.bumblecat.bumblecore.client.windows.events.IEventType;
import dev.bumblecat.bumblecore.client.windows.events.WidgetEventType;

import net.minecraft.resources.ResourceLocation;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

abstract class Widget<T extends IWidget> implements IWidget {

    private final Map<IEventType, Runnable> runnables = new HashMap<>();

    private final IClientWindow window;
    private final Rectangle bounds;

    private boolean visible;

    public Widget(IClientWindow window) {
        this(window, new Rectangle(7, 7, 18, 18));
    }

    /**
     * @param window
     * @param destination
     */
    public Widget(IClientWindow window, Rectangle destination) {
        this.window = window;
        this.bounds = destination;
    }

    /**
     * Gets the window this widget was placed on.
     *
     * @return
     */
    @Override
    public IClientWindow getWindow() {
        return this.window;
    }

    /**
     * Gets whether this widget is visible on screen.
     *
     * @return
     */
    @Override
    public boolean getVisible() {
        return this.visible;
    }

    /**
     * Sets whether this widget is visible on screen.
     *
     * @return
     */
    @Override
    public IWidget setVisible() {
        return this.setVisible(true);
    }

    /**
     * Sets whether this widget is visible on screen.
     *
     * @param value
     *
     * @return
     */
    @Override
    public IWidget setVisible(boolean value) {
        this.visible = value;
        return this;
    }

    /**
     *
     * @return
     */
    public Point getLocation() {
        return this.bounds.getLocation();
    }

    /**
     *
     * @return
     */
    public Dimension getSize() {
        return this.bounds.getSize();
    }

    /**
     *
     * @param w
     * @param h
     * @return
     */
    public IWidget setSize(int w, int h) {
        return this.setSize(new Dimension(w, h));
    }

    /**
     *
     * @param size
     * @return
     */
    public IWidget setSize(Dimension size) {
        this.bounds.setSize(size);
        return this;
    }









    @Override
    public ResourceLocation getTexture() {
        return null;
    }

    @Override
    public boolean getTexture3x3() {
        return false;
    }

    @Override
    public IWidget setTexture3x3() {
        return null;
    }

    @Override
    public IWidget setTexture3x3(boolean value) {
        return null;
    }


    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMousePressed(Runnable runnable) {
        return null;
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMouseRelease(Runnable runnable) {
        return null;
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMouseHover(Runnable runnable) {
        return null;
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMouseMoved(Runnable runnable) {
        return null;
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onValueChanged(Runnable runnable) {
        this.runnables.putIfAbsent(WidgetEventType.ValueChanged, runnable);
        return this;
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onVisibleChanged(Runnable runnable) {
        this.runnables.putIfAbsent(WidgetEventType.VisibilityChanged, runnable);
        return this;
    }
}
