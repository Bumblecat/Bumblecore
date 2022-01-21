package dev.bumblecat.bumblecore.common.modular;

import dev.bumblecat.bumblecore.common.Functions;
import dev.bumblecat.bumblecore.common.Namespace;
import dev.bumblecat.bumblecore.common.command.BumblecoreCommand;
import dev.bumblecat.bumblecore.common.network.INetwork;
import dev.bumblecat.bumblecore.common.network.Network;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

public abstract class Module {

    private static final INetwork network = Network.create(Namespace.getDomain());

    /**
     *
     */
    protected Module() {

        /**
         * Events to listen for.
         */
        Functions.Shortcuts.getEventBus().addListener(this::onCommonSetupEvent);
        Functions.Shortcuts.getEventBus().addListener(this::onClientSetupEvent);
        Functions.Shortcuts.getEventBus().addListener(this::onModuleReadyEvent);

        Functions.Shortcuts.getForgeEventBus().addListener(this::onRegisterCommandsEvent);
    }


    /**
     * @return
     */
    public static INetwork getNetwork() {
        return network;
    }

    /**
     * @param event
     */
    public void onCommonSetupEvent(FMLCommonSetupEvent event) {
        /**
         * No Op.
         */
    }

    /**
     * @param event
     */
    public void onClientSetupEvent(FMLClientSetupEvent event) {
        /**
         * No Op.
         */
    }

    /**
     * @param event
     */
    public void onModuleReadyEvent(FMLLoadCompleteEvent event) {
        /**
         * No Op.
         */
    }

    /**
     * @param event
     */
    public void onRegisterCommandsEvent(RegisterCommandsEvent event) {
        BumblecoreCommand.construct(event.getDispatcher());
    }
}
