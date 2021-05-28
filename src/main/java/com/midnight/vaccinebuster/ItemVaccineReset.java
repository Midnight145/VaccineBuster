package com.midnight.vaccinebuster;

import com.midnight.vaccinebuster.potion.PotionAntiTaint;
import com.midnight.vaccinebuster.potion.VBPotions;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemVaccineReset extends Item {
	
	public ItemVaccineReset() 
	{
		setUnlocalizedName(VaccineBuster.MODID + "_" + VBStrings.ItemVaccineResetName);
		GameRegistry.registerItem(this, VBStrings.ItemVaccineResetName);
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(VaccineBuster.MODID + ":" + VBStrings.ItemVaccineResetName);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!player.getEntityData().getBoolean("TaintVaccine")) {
			return itemstack;
		}
		writeCustomNBT((EntityLivingBase) player);
		if (PotionAntiTaint.vaccinatedPlayers.contains(player.getDisplayName())) {
			PotionAntiTaint.vaccinatedPlayers.remove(player.getDisplayName());
		}
		player.removePotionEffect(VBPotions.antiTaintID);
		return itemstack;
		
	}
	public static void writeCustomNBT(EntityLivingBase entity) {
		if (!entity.getEntityData().getBoolean("TaintVaccine")) {
			entity.getEntityData().setBoolean("TaintVaccine", false);
		}
	}
	
}
