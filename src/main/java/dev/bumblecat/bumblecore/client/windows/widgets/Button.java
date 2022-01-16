package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public class Button extends Widget<Button> implements IWidget {

    /**
     * @param window
     * @param destination
     */
    public Button(IClientWindow window, Rectangle destination) {
        super(window, destination);
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
