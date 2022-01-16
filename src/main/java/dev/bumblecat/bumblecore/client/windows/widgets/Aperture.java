package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public class Aperture extends Widget<Aperture> implements IWidget {

    /**
     * @param window
     * @param destination
     */
    public Aperture(IClientWindow window, Rectangle destination) {
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
        return new Rectangle(48,0,16,16);
    }
}
