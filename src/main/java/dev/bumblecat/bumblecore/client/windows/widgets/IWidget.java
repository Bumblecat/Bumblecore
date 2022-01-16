package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

import net.minecraft.resources.ResourceLocation;

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
     * @return
     */
    IWidget setVisible();

    /**
     * Sets whether this widget is visible on screen.
     *
     * @param value
     *
     * @return
     */
    IWidget setVisible(boolean value);





    ResourceLocation getTexture();


    boolean getTexture3x3();

    IWidget setTexture3x3();

    IWidget setTexture3x3(boolean value);










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
    <T extends IWidget> IWidget onMouseHover(Runnable runnable);

    /**
     * @param runnable
     * @param <T>
     *
     * @return
     */
    <T extends IWidget> IWidget onMouseMoved(Runnable runnable);

    /**
     *
     * @param runnable
     * @param <T>
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
}
