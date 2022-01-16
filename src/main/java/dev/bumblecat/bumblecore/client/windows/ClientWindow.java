package dev.bumblecat.bumblecore.client.windows;

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


    @Override
    public void onWindowRendering(WindowEvent event) {

    }

    @Override
    public void onWidgetRendering(WidgetEvent event) {

    }
}
