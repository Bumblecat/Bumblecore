package dev.bumblecat.bumblecore.common.register;

import dev.bumblecat.bumblecore.client.objects.cubes.IDyeableCube;
import dev.bumblecat.bumblecore.client.objects.items.IDyeableItem;

import net.minecraft.world.level.ItemLike;

import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryManager;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Supplier;

public class RegistryEventHandler {

    public static class RegisterEventListener<T extends IForgeRegistryEntry<T>> {

        private final Register<T> register;

        /**
         * @param register
         */
        public RegisterEventListener(final Register<T> register) {
            this.register = register;
        }

        /**
         * @return
         */
        public Register<T> getRegister() {
            return this.register;
        }

        /**
         * @param event
         */
        @SubscribeEvent
        public void onRegistryEvent(RegistryEvent.Register<?> event) {

            IForgeRegistry<T> registryType = getRegister().getRegistryType();

            if (registryType == null) {
                if (getRegister().getRegistrySuperType() != null) {
                    registryType = RegistryManager.ACTIVE.getRegistry(getRegister().getRegistrySuperType());
                }
            }

            if (registryType.getRegistrySuperType() == event.getGenericType()) {
                IForgeRegistry<T> registry = (IForgeRegistry<T>) event.getRegistry();
                for (Map.Entry<RegistryObject<T>, Supplier<? extends T>> entry : getRegister().getRegistryEntries().entrySet()) {
                    registry.register(entry.getValue().get());
                    entry.getKey().updateReference(registry);
                }
            }
        }
    }

    public static class DyeColorEventListener<T extends IForgeRegistryEntry<T>> {

        private final Register<T> register;

        /**
         * @param register
         */
        public DyeColorEventListener(final Register<T> register) {
            this.register = register;
        }

        /**
         * @return
         */
        public Register<T> getRegister() {
            return this.register;
        }

        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public void onItemColorHandlerEvent(ColorHandlerEvent.Item event) {
            for (Map.Entry<RegistryObject<T>, Supplier<? extends T>> entry : getRegister().getRegistryEntries().entrySet()) {
                if (entry.getKey().get() instanceof IDyeableItem) {

                    event.getItemColors().register(
                            ((IDyeableItem) entry.getKey().get()).getColor(null),
                            (ItemLike) entry.getKey().get()
                    );
                }
            }
        }


        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public void onCubeColorHandlerEvent(ColorHandlerEvent.Block event) {
            for (Map.Entry<RegistryObject<T>, Supplier<? extends T>> entry : getRegister().getRegistryEntries().entrySet()) {
                if (entry.getKey().get() instanceof IDyeableCube) {

                    //Logger.get().warn(" [=] @todo: dyeable Blocks.");
                    //Logger.get().warn(" [=] Dyeable: " + entry.getKey().get());
                }
            }
        }
    }
}