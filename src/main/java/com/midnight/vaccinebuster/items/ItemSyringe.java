package com.midnight.vaccinebuster.items;

import com.midnight.vaccinebuster.VBStrings;
import com.midnight.vaccinebuster.VaccineBuster;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSyringe extends Item {
	
	public ItemSyringe() 
	{
		setUnlocalizedName(VaccineBuster.MODID + "_" + VBStrings.ItemSyringeName);
		GameRegistry.registerItem(this, VBStrings.ItemSyringeName);
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(VaccineBuster.MODID + ":" + VBStrings.ItemSyringeName);
	}

}
