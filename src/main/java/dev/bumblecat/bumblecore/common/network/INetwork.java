package dev.bumblecat.bumblecore.common.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface INetwork {
    /**
     * @param message
     * @param encoder
     * @param decoder
     * @param consumer
     * @param <T>
     */
    <T> void registerMessage(Class<T> message, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> consumer);

    /**
     * @param message
     * @param encoder
     * @param decoder
     * @param consumer
     * @param <T>
     */
    <T> void registerMessageEnqueued(Class<T> message, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> consumer);

    /**
     * @param object
     */
    void sendToServer(Object object);


    /**
     * @param object
     */
    void sendToGlobal(Object object);

    /**
     * @param object
     * @param player
     */
    void sendToPlayer(Object object, ServerPlayer player);


    /**
     * @param object
     * @param target
     */
    void send(Object object, ResourceKey<Level> target);

    /**
     * @param object
     * @param target
     */
    void send(Object object, LevelChunk target);

    /**
     * @param object
     * @param target
     * @param x
     * @param y
     * @param z
     * @param r
     */
    void send(Object object, ResourceKey<Level> target, double x, double y, double z, double r);

    /**
     * @param object
     * @param target
     */
    void send(Object object, PacketDistributor.TargetPoint target);

    /**
     * @param object
     * @param target
     */
    void send(Object object, PacketDistributor.PacketTarget target);
}
