package dev.bumblecat.bumblecore.common.objects.cubes.tiles;

import dev.bumblecat.bumblecore.common.objects.IObject;
import dev.bumblecat.bumblecore.common.objects.cubes.CustomCube;
import net.minecraftforge.common.extensions.IForgeBlockEntity;

public interface ICustomTileEntity extends IObject, IForgeBlockEntity {

    <T extends CustomCube> T getOwner();
}
