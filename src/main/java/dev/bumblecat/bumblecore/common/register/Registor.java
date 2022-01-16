package dev.bumblecat.bumblecore.common.register;

import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.LinkedHashMap;
import java.util.Map;

public class Registor {

    private final Map<Class<?>, Register<?>> registries = new LinkedHashMap<>();
    private final String domain;

    /**
     * @param domain
     */
    public Registor(String domain) {
        this.domain = domain;
    }

    /**
     * @param object
     * @param <T>
     *
     * @return
     */
    public <T extends IForgeRegistryEntry<T>> Register<T> getRegister(T object) {
        if (!registries.containsKey(object.getRegistryType()))
            registries.put(object.getRegistryType(), Register.create(domain, object.getRegistryType()));

        return (Register<T>) registries.get(object.getRegistryType());
    }


    /**
     * @return
     */
    public Map<Class<?>, Register<?>> getRegistries() {
        return registries;
    }
}
