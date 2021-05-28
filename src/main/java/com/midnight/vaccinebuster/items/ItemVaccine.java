package com.midnight.vaccinebuster.items;

import com.midnight.vaccinebuster.VBStrings;
import com.midnight.vaccinebuster.VaccineBuster;
import com.midnight.vaccinebuster.potion.PotionAntiTaint;
import com.midnight.vaccinebuster.potion.VBPotions;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemVaccine extends Item {

	public ItemVaccine() 
	{
		setUnlocalizedName(VaccineBuster.MODID + "_" + VBStrings.ItemVaccineName);
		GameRegistry.registerItem(this, VBStrings.ItemVaccineName);
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureName(VaccineBuster.MODID + ":" + VBStrings.ItemVaccineName);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (player.getEntityData().getBoolean("TaintVaccine")) {

			return itemstack;
		}
		writeCustomNBT((EntityLivingBase) player);
		if (!PotionAntiTaint.vaccinatedPlayers.contains(player.getDisplayName())) {
			PotionAntiTaint.vaccinatedPlayers.add(player.getDisplayName());
		}
		player.addPotionEffect(new PotionEffect(VBPotions.antiTaintID, 1));
		itemstack.stackSize--;
		return itemstack;
		
	}
	public static void writeCustomNBT(EntityLivingBase entity) {
		System.out.println("In writeCustomNBT");
		if (!entity.getEntityData().getBoolean("TaintVaccine")) {
			entity.getEntityData().setBoolean("TaintVaccine", true);
		}
			boolean temp = entity.getEntityData().getBoolean("TaintVaccine");
			System.out.println("Value of temp: " + Boolean.toString(temp));
			System.out.println("after println getboolean");
	}
}
