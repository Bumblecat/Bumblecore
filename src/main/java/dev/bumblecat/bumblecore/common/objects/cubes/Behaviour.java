package dev.bumblecat.bumblecore.common.objects.cubes;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class Behaviour {


    private CreativeModeTab creativeTab;

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
    public <T extends CreativeModeTab> Behaviour setCreativeTab(T value) {
        this.creativeTab = value;
        return this;
    }


    public BlockBehaviour.Properties resolve() {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(Material.AIR);


        return properties;
    }
}
