package dev.bumblecat.bumblecore.config;

import dev.bumblecat.bumblecore.common.Namespace;

import java.util.LinkedHashMap;
import java.util.Map;

public class Configuration {

    private final Map<String, IConfigurationCategory> categories = new LinkedHashMap<String, IConfigurationCategory>();


    /**
     *
     */
    public Configuration() {
        this(Namespace.getDomain());
    }

    /**
     * @param domain
     */
    public Configuration(String domain) {

    }
}
