package dev.bumblecat.bumblecore.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Functions {


    public class Shortcuts {

        /**
         * @return
         */
        public static IEventBus getEventBus() {
            return FMLJavaModLoadingContext.get().getModEventBus();
        }

        public static IEventBus getForgeEventBus() {
            return MinecraftForge.EVENT_BUS;
        }

        /**
         * @return
         */
        public static ModContainer getContainer() {
            return ModLoadingContext.get().getActiveContainer();
        }
    }
}
