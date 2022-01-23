package dev.bumblecat.bumblecore.common.objects.items;

import dev.bumblecat.bumblecore.common.objects.InteractionResult;
import dev.bumblecat.bumblecore.common.objects.ObjectEventItemArgs;
import dev.bumblecat.bumblecore.common.objects.ObjectEventType;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
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
     * @param stack
     * @param arguments
     *
     * @return
     */
    public abstract InteractionResult<ItemStack> onInteraction(ItemStack stack, ObjectEventItemArgs arguments);

    /**
     * @param stack
     * @param arguments
     *
     * @return
     */
    public abstract InteractionResult<ItemStack> onInteractionFinished(ItemStack stack, ObjectEventItemArgs arguments);

    /**
     * @param p_41432_
     * @param p_41433_
     * @param p_41434_
     *
     * @return
     */
    @Deprecated
    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        InteractionResult<ItemStack> result = this.onInteraction(p_41433_.getItemInHand(p_41434_),
                new ObjectEventItemArgs(ObjectEventType.Interacting, p_41432_, p_41433_, p_41434_));

        return new InteractionResultHolder<>(result.getResult(), result.getObject());


    }

    /**
     * @param p_41409_
     * @param p_41410_
     * @param p_41411_
     *
     * @return
     */
    @Deprecated
    @Override
    public ItemStack finishUsingItem(ItemStack p_41409_, Level p_41410_, LivingEntity p_41411_) {
        return (ItemStack) this.onInteractionFinished(p_41409_,
                new ObjectEventItemArgs(ObjectEventType.InteractingFinished, p_41410_, p_41411_)).getObject();
    }
}
