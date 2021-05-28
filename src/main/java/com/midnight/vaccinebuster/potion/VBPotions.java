package com.midnight.vaccinebuster.potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.midnight.vaccinebuster.potion.PotionAntiTaint;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class VBPotions {

	static final int potions = 1;
	static final int potionOffset = Potion.potionTypes.length;
	
	public static int antiTaintID = 0;
	
	public static final Potion antiTaintPotion = new PotionAntiTaint(antiTaintID, false, 1000000);
	public static final PotionEffect antiTaintEffect = new PotionEffect(antiTaintID, 1, 1, false);
	
	public static boolean hasEffect(EntityLivingBase entity, Potion potion) {
		return entity.getActivePotionEffect(potion) != null;
	}
	public static void init() {
		if(Potion.potionTypes.length < 256) {
			extendPotionArray();
		}
		for (int i = 0; i < Potion.potionTypes.length; i++) {
			if (Potion.potionTypes[i] != null) {
				continue;
			}
			else {
				antiTaintID = i;
				break;
			}
		}
		PotionAntiTaint antiTaint = new PotionAntiTaint(antiTaintID, false, 0);
	}
	
	// Credit to Vazkii, author of Botania
	// Code sample found here: https://github.com/Vazkii/Botania/blob/eb37715da274e31fc29dad8de98c9160a7a8f985/src/main/java/vazkii/botania/common/brew/ModPotions.java
	// https://botaniamod.net/
	
	private static void extendPotionArray() {
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[])f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}
		}
	}
}
