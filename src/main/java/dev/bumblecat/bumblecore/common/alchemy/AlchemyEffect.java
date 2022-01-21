package dev.bumblecat.bumblecore.common.alchemy;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class AlchemyEffect extends MobEffect {

    /**
     *
     */
    public AlchemyEffect() {
        this(0xF0F0EE);
    }

    /**
     * @param color
     */
    public AlchemyEffect(int color) {
        this(MobEffectCategory.NEUTRAL, color);
    }

    /**
     * @param category
     * @param color
     */
    public AlchemyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
}
