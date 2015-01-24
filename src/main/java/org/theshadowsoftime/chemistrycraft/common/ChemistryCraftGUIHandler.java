package org.theshadowsoftime.chemistrycraft.common;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.theshadowsoftime.chemistrycraft.client.guis.GuiGasCollector;
import org.theshadowsoftime.chemistrycraft.client.guis.GuiGeneratorCombustion;
import org.theshadowsoftime.chemistrycraft.common.inventory.ContainerGasCollector;
import org.theshadowsoftime.chemistrycraft.common.inventory.ContainerGeneratorCombustion;
import org.theshadowsoftime.chemistrycraft.common.tileentities.TileEntityGasCollector;
import org.theshadowsoftime.chemistrycraft.common.tileentities.TileEntityGeneratorCombustion;

public class ChemistryCraftGUIHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch(ID) {
            case 0:
                if (entity != null && entity instanceof TileEntityGasCollector) {
                    return new ContainerGasCollector(player.inventory, (TileEntityGasCollector)entity);
                } else {
                    return null;
                }
            case 1:
                if (entity != null && entity instanceof TileEntityGeneratorCombustion) {
                    return new ContainerGeneratorCombustion(player.inventory, (TileEntityGeneratorCombustion)entity);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch(ID) {
            case 0:
                if (entity != null && entity instanceof TileEntityGasCollector) {
                    return new GuiGasCollector(player.inventory, (TileEntityGasCollector)entity);
                } else {
                    return null;
                }
            case 1:
                if (entity != null && entity instanceof TileEntityGeneratorCombustion) {
                    return new GuiGeneratorCombustion(player.inventory, (TileEntityGeneratorCombustion)entity);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }
}
