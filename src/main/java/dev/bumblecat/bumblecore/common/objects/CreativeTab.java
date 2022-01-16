package dev.bumblecat.bumblecore.common.objects;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import org.jetbrains.annotations.NotNull;

public class CreativeTab extends CreativeModeTab {

    private ItemStack image;

    /**
     * @param label
     */
    public CreativeTab(@NotNull String label) {
        this(label, new ItemStack(Items.COMMAND_BLOCK), -1);
    }


    /**
     * @param label
     * @param image
     */
    public CreativeTab(@NotNull String label, ItemStack image) {
        this(label, image, -1);
    }

    /**
     * @param label
     * @param image
     * @param index
     */
    public CreativeTab(@NotNull String label, ItemStack image, int index) {
        super(index, label);
        this.image = image;
    }

    /**
     * @return
     */
    @Override
    public final ItemStack getIconItem() {
        return this.image != ItemStack.EMPTY ? this.image : makeIcon();
    }

    /**
     * @param object
     *
     * @return
     */
    public void setIconItem(@NotNull Item object) {
        setIconItem(new ItemStack(object));
    }

    /**
     * @param stack
     *
     * @return
     */
    public void setIconItem(@NotNull ItemStack stack) {
        this.image = stack;
    }

    /**
     * @return
     */
    @Override
    public final ItemStack makeIcon() {
        return this.image;
    }
}
