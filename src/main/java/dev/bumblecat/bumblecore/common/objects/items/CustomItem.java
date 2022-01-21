package dev.bumblecat.bumblecore.common.objects.items;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.Nullable;

public class CustomItem extends CustomItemAbstract implements ICustomItem {

    /**
     *
     */
    public CustomItem() {
        this(new Variables());
    }

    /**
     * @param variables
     */
    public CustomItem(Variables variables) {
        this(variables, null);
    }

    /**
     * @param nutrients
     */
    public CustomItem(@Nullable Nutrients nutrients) {
        this(new Variables(), nutrients);
    }

    /**
     * @param variables
     * @param nutrients
     */
    public CustomItem(Variables variables, @Nullable Nutrients nutrients) {
        super(variables, nutrients);
    }


    /**
     * @param stack
     *
     * @return
     */
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(Math.max(0F, (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage()) / 3F, 1F, 1F);
    }

    /**
     * @param stack
     * @param enchantment
     *
     * @return
     */
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return ((this instanceof IEnchantable) && isEnchantable(stack)) && enchantment.category.canEnchant(stack.getItem());
    }

    /**
     * @param state
     * @param level
     * @param blockPos
     * @param player
     *
     * @return
     */
    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos blockPos, Player player) {
        return (this instanceof IImpractical) ? !((IImpractical) this).isImpractical() : super.canAttackBlock(state, level, blockPos, player);
    }

    /**
     * @param stack
     * @param state
     *
     * @return
     */
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {

        return (this instanceof IImpractical) ? 0 : super.getDestroySpeed(stack, state);
    }
}
