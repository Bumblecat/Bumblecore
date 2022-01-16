package dev.bumblecat.bumblecore.client.windows;

import dev.bumblecat.bumblecore.client.windows.events.RenderEventArgs;
import dev.bumblecat.bumblecore.client.windows.events.WidgetEvent;
import dev.bumblecat.bumblecore.client.windows.events.WindowEvent;
import dev.bumblecat.bumblecore.common.windows.CommonWindow;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public abstract class ClientWindow<T extends CommonWindow> extends ClientWindowAbstract<T> implements IClientWindow {

    /**
     * @param container
     * @param inventory
     * @param component
     */
    public ClientWindow(T container, Inventory inventory, Component component) {
        super(container, inventory, component);
    }

    /**
     *
     * @param event
     */
    @Override
    public void onWindowRendering(WindowEvent event) {

        int grid = 16;
        int originX = 0, originY = 0;

        for (int i = 0; i < (getSize().getWidth() / grid); ++i) {
            for (int j = 0; j < ((getSize().getHeight() - 16) / grid); ++j) {

                int textureX = originX + (i >= (getSize().getWidth() / grid) - 1 ? grid * 2 : i > 0 ? grid : 0);
                int textureY = originY + (j >= ((getSize().getHeight() - 16) / grid) - 1 ? grid * 2 : j > 0 ? grid : 0);

                this.blit(((RenderEventArgs) event.getArguments()).getMatrix(),
                        (int) getLocation().getX() + i * grid,
                        (int) getLocation().getY() + j * grid,
                        textureX, textureY, grid, grid
                );
            }
        }
    }

    /**
     *
     * @param event
     */
    @Override
    public void onWidgetRendering(WidgetEvent event) {

        int destX = (int) (getLocation().getX() + event.getWidget().getLocation().getX());
        int destY = (int) (getLocation().getY() + event.getWidget().getLocation().getY());

        if (!event.getWidget().getTexture3x3()) {

            this.blit(((RenderEventArgs)event.getArguments()).getMatrix(), destX, destY,
                    (int) event.getWidget().getSpritePosition().getX(), (int) event.getWidget().getSpritePosition().getY(),
                    (int) event.getWidget().getSpritePosition().getWidth(), (int) event.getWidget().getSpritePosition().getHeight()
            );
        } else {

            int originX = (int) event.getWidget().getSpritePosition().getX();
            int originY = (int) event.getWidget().getSpritePosition().getY();

            int gridX = (int) Math.ceil(event.getWidget().getSpritePosition().getWidth() / 3);
            int gridY = (int) Math.ceil(event.getWidget().getSpritePosition().getHeight() / 3);

            for (int i = 0; i < (int) Math.floor(event.getWidget().getSize().getWidth() / gridX); ++i) {
                for (int j = 0; j < (int) Math.floor(event.getWidget().getSize().getHeight() / gridY); ++j) {

                    int textureX = originX + (i >= (event.getWidget().getSize().getWidth() / gridX) - 1
                            ? (int) event.getWidget().getSpritePosition().getWidth() - gridX : i > 0 ? gridX : 0);
                    int textureY = originY + (j >= (event.getWidget().getSize().getHeight() / gridY) - 1
                            ? (int) event.getWidget().getSpritePosition().getHeight() - gridY : j > 0 ? gridY : 0);

                    blit(((RenderEventArgs)event.getArguments()).getMatrix(),
                            (destX + (i * gridX)), (destY + (j * gridY)), textureX, textureY, gridX, gridY);
                }
            }
        }
    }
}
