package dev.bumblecat.bumblecore.common.objects.items;

import net.minecraft.world.item.Item;

import org.jetbrains.annotations.Nullable;

abstract class CustomItemAbstract extends Item {

    /**
     *
     */
    protected CustomItemAbstract() {
        this(new Variables());
    }

    /**
     * @param variables
     */
    protected CustomItemAbstract(Variables variables) {
        this(variables, null);
    }

    /**
     * @param nutrients
     */
    protected CustomItemAbstract(Nutrients nutrients) {
        this(new Variables(), nutrients);
    }

    /**
     * @param variables
     */
    protected CustomItemAbstract(Variables variables, @Nullable Nutrients nutrients) {
        this(nutrients == null ? variables.resolve() : variables.setNutrients(nutrients).resolve());
    }


    /**
     * @param properties
     */
    private CustomItemAbstract(Properties properties) {
        super(properties);
    }
}
