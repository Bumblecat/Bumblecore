package dev.bumblecat.bumblecore.common.alchemy;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

import org.jetbrains.annotations.Nullable;

public class AlchemyObject extends MobEffectInstance {

    /**
     * @param effect
     */
    public AlchemyObject(AlchemyEffect effect) {
        this(effect, 0);
    }

    public AlchemyObject(MobEffect effect, int duration) {
        this(effect, duration, 0);
    }

    public AlchemyObject(MobEffect effect, int duration, int strength) {
        super(effect, duration, strength);
    }

    public AlchemyObject(MobEffect p_19522_, int p_19523_, int p_19524_, boolean p_19525_, boolean p_19526_) {
        super(p_19522_, p_19523_, p_19524_, p_19525_, p_19526_);
    }

    public AlchemyObject(MobEffect p_19528_, int p_19529_, int p_19530_, boolean p_19531_, boolean p_19532_, boolean p_19533_) {
        super(p_19528_, p_19529_, p_19530_, p_19531_, p_19532_, p_19533_);
    }

    public AlchemyObject(MobEffect p_19535_, int p_19536_, int p_19537_, boolean p_19538_, boolean p_19539_, boolean p_19540_, @Nullable MobEffectInstance p_19541_) {
        super(p_19535_, p_19536_, p_19537_, p_19538_, p_19539_, p_19540_, p_19541_);
    }

    public AlchemyObject(MobEffectInstance p_19543_) {
        super(p_19543_);
    }
}
