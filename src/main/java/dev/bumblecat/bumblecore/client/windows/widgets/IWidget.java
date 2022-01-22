package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;
import dev.bumblecat.bumblecore.client.conveys.WidgetEvent;

import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public interface IWidget {

    /**
     * Gets the window this widget was placed on.
     *
     * @return
     */
    IClientWindow getWindow();


    /**
     * Gets whether this widget is visible on screen.
     *
     * @return
     */
    boolean getVisible();

    /**
     * Sets whether this widget is visible on screen.
     *
     * @param value
     *
     * @return
     */
    IWidget setVisible(boolean value);

    /**
     * Sets whether this widget is visible on screen.
     *
     * @return
     */
    IWidget setVisible();

    /**
     * @return
     */
    Point getLocation();


    /**
     * @return
     */
    Dimension getSize();

    /**
     * @param dimension
     */
    IWidget setSize(Dimension dimension);

    /**
     * @param w
     * @param h
     */
    IWidget setSize(int w, int h);

    /**
     * Gets the custom texture to be used.
     *
     * @return
     */
    ResourceLocation getTexture();

    /**
     * Gets the location and size of the sprite to be drawn.
     *
     * @return
     */
    Rectangle getSpritePosition();


    /**
     * Gets whether the texture for this widget should
     * be treated as a 3x3 gridded texture.
     *
     * @return
     */
    boolean getTexture3x3();

    /**
     * Sets whether the texture for this widget should
     * be treated as a 3x3 gridded texture.
     *
     * @param value
     *
     * @return
     */
    IWidget setTexture3x3(boolean value);

    /**
     * Sets whether the texture for this widget should
     * be treated as a 3x3 gridded texture.
     *
     * @return
     */
    IWidget setTexture3x3();

    /**
     * @param runnable
     * @param <T>
     *
     * @return
     */
    <T extends IWidget> IWidget onMousePressed(Runnable runnable);

    /**
     * @param runnable
     * @param <T>
     *
     * @return
     */
    <T extends IWidget> IWidget onMouseRelease(Runnable runnable);

    /**
     * @param runnable
     * @param <T>
     *
     * @return
     */
    <T extends IWidget> IWidget onMouseScroll(Runnable runnable);

    /**
     * @param runnable
     * @param <T>
     *
     * @return
     */
    <T extends IWidget> IWidget onMouseMoving(Runnable runnable);

    /**
     * @param runnable
     * @param <T>
     *
     * @return
     */
    <T extends IWidget> IWidget onValueChanged(Runnable runnable);

    /**
     * @param runnable
     * @param <T>
     *
     * @return
     */
    <T extends IWidget> IWidget onVisibleChanged(Runnable runnable);

    void doValidateEvent(WidgetEvent widgetEvent);
}
