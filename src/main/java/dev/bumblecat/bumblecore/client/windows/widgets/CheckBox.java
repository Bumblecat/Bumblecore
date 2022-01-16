package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public class CheckBox extends Widget<CheckBox> implements IWidget {

    private boolean checked;

    /**
     * @param window
     * @param destination
     */
    public CheckBox(IClientWindow window, Rectangle destination) {
        super(window, destination);
    }

    /**
     * @return
     */
    public boolean getValue() {
        return this.checked;
    }

    /**
     * @param value
     *
     * @return
     */
    public void setValue(boolean value) {
        this.checked = value;
    }

    /**
     * Gets the custom texture to be used.
     *
     * @return
     */
    @Override
    public ResourceLocation getTexture() {
        return null;
    }

    /**
     * Gets the location and size of the sprite to be drawn.
     *
     * @return
     */
    @Override
    public Rectangle getSpritePosition() {
        return null;
    }
}
