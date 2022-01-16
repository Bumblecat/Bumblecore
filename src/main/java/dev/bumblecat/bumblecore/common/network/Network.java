package dev.bumblecat.bumblecore.common.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Network implements INetwork {
    private final SimpleChannel channel;
    private int index = 0;

    /**
     * @param channel
     * @param protocol
     * @param clientValidator
     * @param serverValidator
     */
    private Network(ResourceLocation channel, Supplier<String> protocol, Predicate<String> clientValidator, Predicate<String> serverValidator) {
        this.channel = NetworkRegistry.newSimpleChannel(channel, protocol, clientValidator, serverValidator);
    }

    /**
     * @param domain
     *
     * @return
     */
    public static Network create(String domain) {
        return create(domain, "main");
    }

    /**
     * @param domain
     * @param channel
     *
     * @return
     */
    public static Network create(String domain, String channel) {
        return create(domain, channel, 1);
    }

    /**
     * @param domain
     * @param channel
     * @param protocol
     *
     * @return
     */
    public static Network create(String domain, String channel, int protocol) {
        return new Network(new ResourceLocation(domain, channel),
                () -> Integer.toString(protocol),
                Integer.toString(protocol)::equals,
                Integer.toString(protocol)::equals
        );
    }

    /**
     * @param message
     * @param encoder
     * @param decoder
     * @param consumer
     * @param <T>
     */
    public <T> void registerMessage(Class<T> message, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> consumer) {

        this.registerMessageEnqueued(message, encoder, decoder, (m, c) -> c.get().enqueueWork(() -> {
            consumer.accept(m, c);
            c.get().setPacketHandled(true);
        }));
    }

    /**
     * @param message
     * @param encoder
     * @param decoder
     * @param consumer
     * @param <T>
     */
    public <T> void registerMessageEnqueued(Class<T> message, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> consumer) {
        this.channel.registerMessage(this.index, message, encoder, decoder, consumer);
        this.index++;
    }

    /**
     * @param object
     */
    public void sendToServer(Object object) {
        this.send(object, PacketDistributor.SERVER.noArg());
    }

    /**
     * @param object
     */
    public void sendToGlobal(Object object) {
        this.send(object, PacketDistributor.ALL.noArg());
    }

    /**
     * @param object
     * @param player
     */
    public void sendToPlayer(Object object, ServerPlayer player) {
        this.send(object, PacketDistributor.PLAYER.with(() -> player));
    }


    /**
     * @param object
     * @param target
     */
    public void send(Object object, ResourceKey<Level> target) {
        this.send(object, PacketDistributor.DIMENSION.with(() -> target));
    }

    /**
     * @param object
     * @param target
     */
    public void send(Object object, LevelChunk target) {
        this.send(object, PacketDistributor.TRACKING_CHUNK.with(() -> target));
    }

    /**
     * @param object
     * @param target
     * @param x
     * @param y
     * @param z
     * @param r
     */
    public void send(Object object, ResourceKey<Level> target, double x, double y, double z, double r) {
        this.send(object, new PacketDistributor.TargetPoint(x, y, z, r, target));
    }

    /**
     * @param object
     * @param target
     */
    public void send(Object object, PacketDistributor.TargetPoint target) {
        this.send(object, PacketDistributor.NEAR.with(() -> target));
    }

    /**
     * @param object
     * @param target
     */
    public void send(Object object, PacketDistributor.PacketTarget target) {
        this.channel.send(target, object);
    }
}
