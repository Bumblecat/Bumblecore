package dev.bumblecat.bumblecore.common.register;

import dev.bumblecat.bumblecore.common.Namespace;

import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Registry class.
 *
 * @param <T>
 */
public class Registry<T extends IForgeRegistryEntry<T>> {

    private static final Map<String, Registor> registors = new LinkedHashMap<>();

    /**
     * @param objectType
     * @param <T>
     *
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> Register<T> getRegister(T objectType) {
        return getRegister(Namespace.getDomain(), objectType);
    }

    /**
     * @param domain
     * @param object
     * @param <T>
     *
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> Register<T> getRegister(String domain, Class<T> object) {
        return getRegister(domain, object);
    }

    /**
     * @param domain
     * @param objectType
     * @param <T>
     *
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> Register<T> getRegister(String domain, T objectType) {
        if (!registors.containsKey(domain))
            registors.put(domain, new Registor(domain));

        return registors.get(domain).getRegister(objectType);
    }


    /**
     * @param object
     * @param supplier
     * @param <T>
     *
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> RegistryObject<T> register(String object, Supplier<T> supplier) {
        if (!object.contains(":"))
            return register(new ResourceLocation(Namespace.getDomain(), object), supplier);
        return register(new ResourceLocation(object), supplier);
    }


    /**
     * @param domain
     * @param object
     * @param supplier
     * @param <T>
     *
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> RegistryObject<T> register(String domain, String object, Supplier<T> supplier) {
        return register(new ResourceLocation(domain, object), supplier);
    }

    /**
     * @param resource
     * @param supplier
     * @param <T>
     *
     * @return
     */
    public static <T extends IForgeRegistryEntry<T>> RegistryObject<T> register(ResourceLocation resource, Supplier<T> supplier) {
        return getRegister(resource.getNamespace(), supplier.get()).register(resource, supplier);
    }


    /**
     * @todo create get methods to retrieve registered objects.
     */
}