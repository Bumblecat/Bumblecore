package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;
import dev.bumblecat.bumblecore.client.windows.events.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvents;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

abstract class Widget<T extends IWidget> implements IWidget {

    private final Map<IEventType, Runnable> runnables = new HashMap<>();

    private final IClientWindow window;
    private final Rectangle bounds;

    private boolean visible;
    private boolean gridded;

    public Widget(IClientWindow window) {
        this(window, new Rectangle(0, 0, 0, 0));
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
     * @return
     */
    public Point getLocation() {
        return this.bounds.getLocation();
    }

    /**
     * @return
     */
    public Dimension getSize() {
        return this.bounds.getSize();
    }

    /**
     * @param w
     * @param h
     *
     * @return
     */
    public IWidget setSize(int w, int h) {
        return this.setSize(new Dimension(w, h));
    }

    /**
     * @param size
     *
     * @return
     */
    public IWidget setSize(Dimension size) {
        this.bounds.setSize(size);
        return this;
    }

    /**
     * Gets whether the texture for this widget should
     * be treated as a 3x3 gridded texture.
     *
     * @return
     */
    @Override
    public boolean getTexture3x3() {
        return this.gridded;
    }

    /**
     * Sets whether the texture for this widget should
     * be treated as a 3x3 gridded texture.
     *
     * @return
     */
    @Override
    public IWidget setTexture3x3() {
        return setTexture3x3(true);
    }

    /**
     * Sets whether the texture for this widget should
     * be treated as a 3x3 gridded texture.
     *
     * @param value
     *
     * @return
     */
    @Override
    public IWidget setTexture3x3(boolean value) {
        this.gridded = value;
        return this;
    }


    /**
     * @param event
     */
    @Override
    public void doValidateEvent(WidgetEvent event) {

        if (event.getArguments() instanceof ValueChangedEventArgs<?>) {
            switch ((WidgetEventType) event.getArguments().getEventType()) {
                case ValueChanged -> {
                    if (runnables.containsKey(WidgetEventType.ValueChanged)) {
                        runnables.get(WidgetEventType.ValueChanged).run();
                    }
                }
            }
        }

        if (event.getArguments() instanceof MouseEventArgs) {
            switch ((MouseEventType) event.getArguments().getEventType()) {
                case MousePressed -> {
                    if (this.onMousePressed((MouseEventArgs) event.getArguments())) {
                        if (runnables.containsKey(MouseEventType.MousePressed)) {
                            runnables.get(MouseEventType.MousePressed).run();
                        }
                    }
                }
                case MouseRelease -> {
                    if (this.onMouseRelease((MouseEventArgs) event.getArguments())) {
                        if (runnables.containsKey(MouseEventType.MouseRelease)) {
                            runnables.get(MouseEventType.MouseRelease).run();
                        }
                    }
                }
                case MouseScroll -> {
                    if (this.onMouseScroll((MouseEventArgs) event.getArguments())) {
                        if (runnables.containsKey(MouseEventType.MouseScroll)) {
                            runnables.get(MouseEventType.MouseScroll).run();
                        }
                    }
                }
                case MouseMoving -> {
                    if (this.onMouseMoving((MouseEventArgs) event.getArguments())) {
                        if (runnables.containsKey(MouseEventType.MouseMoving)) {
                            runnables.get(MouseEventType.MouseMoving).run();
                        }
                    }
                }
            }
        }
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMousePressed(Runnable runnable) {
        runnables.putIfAbsent(MouseEventType.MousePressed, runnable);
        return this;
    }

    /**
     * @param arguments
     *
     * @return
     */
    public boolean onMousePressed(MouseEventArgs arguments) {
        return this.bounds.contains(arguments.getMousePointOnWindow());
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMouseRelease(Runnable runnable) {
        runnables.putIfAbsent(MouseEventType.MouseRelease, runnable);
        return this;
    }

    /**
     * @param arguments
     *
     * @return
     */
    public boolean onMouseRelease(MouseEventArgs arguments) {
        return this.bounds.contains(arguments.getMousePointOnWindow());
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMouseScroll(Runnable runnable) {
        runnables.putIfAbsent(MouseEventType.MouseScroll, runnable);
        return this;
    }


    /**
     * @param arguments
     *
     * @return
     */
    public boolean onMouseScroll(MouseEventArgs arguments) {
        return true;
    }

    /**
     * @param runnable
     *
     * @return
     */
    @Override
    public <T extends IWidget> IWidget onMouseMoving(Runnable runnable) {
        runnables.putIfAbsent(MouseEventType.MouseMoving, runnable);
        return this;
    }

    /**
     * @param arguments
     *
     * @return
     */
    public boolean onMouseMoving(MouseEventArgs arguments) {
        return this.bounds.contains(arguments.getMousePointOnWindow());
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

    /**
     *
     */
    protected void playClickSound() {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
    }
}
