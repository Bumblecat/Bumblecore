package dev.bumblecat.bumblecore.common.objects.items;

import org.jetbrains.annotations.Nullable;

public class CustomItemPotion extends CustomItem {

    /**
     *
     */
    public CustomItemPotion() {
    }

    /**
     * @param variables
     */
    public CustomItemPotion(Variables variables) {
        super(variables);
    }

    /**
     * @param nutrients
     */
    public CustomItemPotion(@Nullable Nutrients nutrients) {
        super(nutrients);
    }

    /**
     * @param variables
     * @param nutrients
     */
    public CustomItemPotion(Variables variables, @Nullable Nutrients nutrients) {
        super(variables, nutrients);
    }
}
