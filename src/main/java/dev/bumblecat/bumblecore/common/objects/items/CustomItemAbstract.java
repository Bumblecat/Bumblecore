package dev.bumblecat.bumblecore.common.objects.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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


    /**
     * @param level
     * @param player
     * @param hand
     * @return
     */
    public abstract InteractionResultHolder<ItemStack> onInteract(Level level, Player player, InteractionHand hand);


    /**
     * @param p_41432_
     * @param p_41433_
     * @param p_41434_
     * @return
     */
    @Override
    public final InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        return this.onInteract(p_41432_, p_41433_, p_41434_);
        //return new InteractionResultHolder<>(this.onInteract(p_41432_, p_41433_, p_41434_), p_41433_.getItemInHand(p_41434_));
        //return super.use(p_41432_, p_41433_, p_41434_);
    }
}
