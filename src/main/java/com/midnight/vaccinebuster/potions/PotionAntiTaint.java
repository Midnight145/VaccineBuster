package com.midnight.vaccinebuster.potions;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import thaumcraft.api.damagesource.DamageSourceThaumcraft;
import thaumcraft.api.entities.ITaintedMob;
import thaumcraft.api.potions.PotionFluxTaint;
import thaumcraft.common.config.Config;

import java.util.ArrayList;

import com.midnight.vaccinebuster.items.ItemVaccine;
import com.midnight.vaccinebuster.potions.VBPotions;

public class PotionAntiTaint extends Potion {

	public static ArrayList vaccinatedPlayers = new ArrayList<String>();
	
    public PotionAntiTaint(int par1, boolean par2, int par3)
    {
     //potion id, isBadEffect, liquid color
        super(par1, par2, par3);
        this.setPotionName("potion.antitaint");
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
    }

    @Override
    public Potion setIconIndex(int par1, int par2)
    {
        super.setIconIndex(par1, par2);
        return this;
    }
    
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;

		if(!(entity instanceof ITaintedMob) && VBPotions.hasEffect(entity, (Potion) this)) {
			if (entity instanceof EntityPlayer && !vaccinatedPlayers.contains(((EntityPlayer) entity).getDisplayName())) {
				vaccinatedPlayers.add(((EntityPlayer) entity).getDisplayName());
			}
			
			NBTTagCompound tag = entity.getEntityData();
			
			if (VBPotions.hasEffect(entity, PotionFluxTaint.instance)) { 
				entity.removePotionEffect(Config.potionTaintPoisonID); 
			}
		}
		if (entity.getEntityData().getBoolean("TaintVaccine")) {
			entity.addPotionEffect(new PotionEffect(VBPotions.antiTaintID, 2));
		}
	}
	
	@SubscribeEvent
	public void playerRespawn(PlayerRespawnEvent event) {
		if (vaccinatedPlayers.contains(event.player.getDisplayName())) {
			System.out.println("in vaccinatedPlayers.contains()");
			ItemVaccine.writeCustomNBT(event.player);
		}
	}
}
