package dev.bumblecat.bumblecore.common.objects.items;

import net.minecraft.world.food.FoodProperties;

public class Nutrients {
    private int nutrition;
    private float saturation;

    private boolean typeofmeat;
    private boolean alwaysedible;
    private boolean fastfood;

    /**
     * @return
     */
    public int getNutrition() {
        return nutrition;
    }

    /**
     * @param value
     *
     * @return
     */
    public Nutrients setNutrition(int value) {
        this.nutrition = value;
        return this;
    }

    /**
     * @return
     */
    public float getSaturation() {
        return saturation;
    }

    /**
     * @param value
     *
     * @return
     */
    public Nutrients setSaturation(int value) {
        this.saturation = value;
        return this;
    }

    /**
     * @return
     */
    public boolean getIsTypeOfMeat() {
        return typeofmeat;
    }

    /**
     * @param value
     *
     * @return
     */
    public Nutrients setIsTypeOfMeat(boolean value) {
        this.typeofmeat = value;
        return this;
    }

    /**
     * @return
     */
    public boolean getAlwaysEdible() {
        return alwaysedible;
    }

    /**
     * @param value
     *
     * @return
     */
    public Nutrients setAlwaysEdible(boolean value) {
        this.alwaysedible = value;
        return this;
    }

    /**
     * @return
     */
    public boolean getIsFastFood() {
        return fastfood;
    }

    /**
     * @param value
     *
     * @return
     */
    public Nutrients setIsFastFood(boolean value) {
        this.fastfood = value;
        return this;
    }

    public FoodProperties resolve() {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(getNutrition())
                .saturationMod(getSaturation());

        if (getIsTypeOfMeat())
            builder.meat();
        if (getAlwaysEdible())
            builder.alwaysEat();
        if (getIsFastFood())
            builder.fast();

        // @todo add effects here.


        return builder.build();
    }
}
