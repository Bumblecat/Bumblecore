package dev.bumblecat.bumblecore.common.objects.cubes;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

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
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(Material.STONE);

        properties.noOcclusion();


        return properties;
    }
}
