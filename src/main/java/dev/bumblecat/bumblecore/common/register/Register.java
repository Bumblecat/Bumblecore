package dev.bumblecat.bumblecore.common.register;

import dev.bumblecat.bumblecore.common.Functions;
import dev.bumblecat.bumblecore.common.Namespace;

import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Slightly altered version of net.minecraftforge.registries.DeferredRegister.java
 *
 * @param <T>
 */
public class Register<T extends IForgeRegistryEntry<T>> {

    private final String domain;
    private final Map<RegistryObject<T>, Supplier<? extends T>> entries = new LinkedHashMap<>();

    private final Class<T> classSuperType;
    private IForgeRegistry<T> registryType;

    /**
     * @param domain
     * @param registry
     */
    private Register(String domain, IForgeRegistry<T> registry) {
        this(domain, registry.getRegistrySuperType());
        this.registryType = registry;
    }


    /**
     * @param domain
     * @param registry
     */
    private Register(String domain, Class<T> registry) {
        this.classSuperType = registry;
        this.domain = domain;

        this.initialize(Functions.Shortcuts.getEventBus());
    }

    /**
     * @param domain
     * @param registry
     * @param <B>
     *
     * @return
     */
    public static <B extends IForgeRegistryEntry<B>> Register<B> create(String domain, IForgeRegistry<B> registry) {
        return new Register<B>(domain, registry);
    }

    /**
     * @param domain
     * @param registry
     * @param <B>
     *
     * @return
     */
    public static <B extends IForgeRegistryEntry<B>> Register<B> create(String domain, Class<B> registry) {
        return new Register<B>(domain, registry);
    }

    /**
     * @param eventbus
     */
    private void initialize(IEventBus eventbus) {
        eventbus.register(new RegistryEventHandler.RegisterEventListener<T>(this));
        eventbus.register(new RegistryEventHandler.DyeColorEventListener<T>(this));
    }

    /**
     * @param object
     * @param supplier
     * @param <E>
     *
     * @return
     */
    public <E extends T> RegistryObject<E> register(String object, Supplier<? extends E> supplier) {
        if (!object.contains(":"))
            return register(new ResourceLocation(Namespace.getDomain(), object), supplier);
        return register(new ResourceLocation(object), supplier);
    }


    /**
     * @param domain
     * @param object
     * @param supplier
     * @param <E>
     *
     * @return
     */
    public <E extends T> RegistryObject<E> register(String domain, String object, Supplier<? extends E> supplier) {
        return register(new ResourceLocation(domain, object), supplier);
    }

    /**
     * @param resource
     * @param supplier
     * @param <E>
     *
     * @return
     */
    public <E extends T> RegistryObject<E> register(ResourceLocation resource, Supplier<? extends E> supplier) {

        Objects.requireNonNull(resource);
        Objects.requireNonNull(supplier);

        RegistryObject<E> object;
        if (this.getRegistryType() != null) {
            object = RegistryObject.of(resource, this.getRegistryType());
        } else if (this.getRegistrySuperType() != null) {
            object = RegistryObject.of(resource, this.getRegistrySuperType(), this.domain);
        } else {
            throw new IllegalStateException("Could not create RegistryObject.");
        }

        if (entries.putIfAbsent((RegistryObject<T>) object, () -> supplier.get().setRegistryName(resource)) != null) {
            throw new IllegalArgumentException("Duplicate registration: " + resource);
        }

        return object;
    }


    /**
     * @return
     */
    public IForgeRegistry<T> getRegistryType() {
        return registryType;
    }

    /**
     * @return
     */
    public Class<T> getRegistrySuperType() {
        return classSuperType;
    }

    /**
     * @return
     */
    public Map<RegistryObject<T>, Supplier<? extends T>> getRegistryEntries() {
        return entries;
    }

    /**
     * @return
     */
    public String getDomain() {
        return this.domain;
    }
}