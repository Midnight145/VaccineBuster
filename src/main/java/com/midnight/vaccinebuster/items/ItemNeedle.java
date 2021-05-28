package com.midnight.vaccinebuster.items;

import com.midnight.vaccinebuster.VBStrings;
import com.midnight.vaccinebuster.VaccineBuster;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNeedle extends Item {

	public ItemNeedle() 
	{
		setUnlocalizedName(VaccineBuster.MODID + "_" + VBStrings.ItemNeedleName);
		GameRegistry.registerItem(this, VBStrings.ItemNeedleName);
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(VaccineBuster.MODID + ":" + VBStrings.ItemNeedleName);
	}

}
