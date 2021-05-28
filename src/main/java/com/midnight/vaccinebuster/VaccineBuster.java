package com.midnight.vaccinebuster;

import com.midnight.vaccinebuster.items.VBItems;
import com.midnight.vaccinebuster.potion.VBPotions;
import com.midnight.vaccinebuster.research.AddedResearch;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import powercrystals.minefactoryreloaded.setup.MFRThings;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.potions.PotionFluxTaint;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;
import thaumic.tinkerer.common.item.kami.ItemKamiResource;

@Mod(modid = VaccineBuster.MODID, version = VaccineBuster.VERSION)
public class VaccineBuster
{
    public static final String MODID = "vaccinebuster";
    public static final String VERSION = "1.0";
    
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		VBItems.init();
		VBPotions.init();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	PotionFluxTaint.instance.setPotionName("COVID-19");
    	AddedResearch.init();
    }
}
