package dev.bumblecat.bumblecore.common.objects.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class Variables {

    private int stacksize;
    private int durability;
    private boolean repairable;
    private boolean fireproof;

    private Nutrients nutrients;

    private CreativeModeTab creativeTab;

    /**
     * @return
     */
    public int getStackSize() {
        return this.stacksize > 0 ? this.stacksize : 64;
    }

    /**
     * @param value
     *
     * @return
     */
    public Variables setStackSize(int value) {
        this.stacksize = value;
        return this;
    }

    /**
     * @return
     */
    public int getDurability() {
        return this.durability;
    }

    /**
     * @param value
     *
     * @return
     */
    public Variables setDurability(int value) {
        this.durability = value;
        return this;
    }

    /**
     * @return
     */
    public boolean getRepairable() {
        return this.repairable;
    }

    /**
     * @param value
     *
     * @return
     */
    public Variables setRepairable(boolean value) {
        this.repairable = value;
        return this;
    }

    /**
     * @return
     */
    public boolean getFireproof() {
        return this.fireproof;
    }

    /**
     * @param value
     *
     * @return
     */
    public Variables setFireproof(boolean value) {
        this.fireproof = value;
        return this;
    }

    /**
     * @return
     */
    public CreativeModeTab getCreativeTab() {
        return this.creativeTab;
    }

    /**
     * @param value
     *
     * @return
     */
    public <T extends CreativeModeTab> Variables setCreativeTab(T value) {
        this.creativeTab = value;
        return this;
    }

    /**
     * @return
     */
    public Nutrients getNutrients() {
        return this.nutrients;
    }

    /**
     * @param nutrients
     *
     * @return
     */
    public Variables setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
        return this;
    }

    /**
     * @return
     */
    public Item.Properties resolve() {
        Item.Properties properties = new Item.Properties()
                .stacksTo(getStackSize())
                .durability(getDurability());

        if (!getRepairable())
            properties.setNoRepair();

        if (getFireproof())
            properties.fireResistant();

        if (getNutrients() != null) {
            properties.food(getNutrients().resolve());
        }

        properties.tab(getCreativeTab() == null ? CreativeModeTab.TAB_SEARCH : getCreativeTab());

        return properties;
    }
}
