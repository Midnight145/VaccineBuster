package com.midnight.vaccinebuster.research;

import com.midnight.vaccinebuster.items.VBItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import powercrystals.minefactoryreloaded.setup.MFRThings;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.config.ConfigBlocks;
import thaumic.tinkerer.common.item.kami.ItemKamiResource;

public class AddedResearch {

	public static void init() {
		GameRegistry.addShapedRecipe(
				new ItemStack(VBItems.needle), 
				new Object[] { 
						"A", 	   
						"P" , 
				   'A', Items.arrow, 
				   'P', MFRThings.plasticSheetItem
	   });
		
		GameRegistry.addShapedRecipe(
				new ItemStack(VBItems.syringe), 
				new Object[] { 
						" N ",
						"P P",
						"P P",
					'N', VBItems.needle,
					'P', MFRThings.plasticSheetItem
		});
		
		InfusionRecipe taintVaccineRecipe = ThaumcraftApi.addInfusionCraftingRecipe("TAINTVACCINE", 
				new ItemStack(VBItems.vaccine, 4), 
				10, 
				new AspectList().add(Aspect.TAINT, 32).add(Aspect.HEAL, 64).add(Aspect.LIFE, 32).add(Aspect.MAGIC, 32).add(Aspect.MAN, 64).add(Aspect.PLANT, 32).add(Aspect.ORDER, 128), 
				new ItemStack(VBItems.syringe), 
				new ItemStack[] {
						new ItemStack(ConfigItems.itemResource, 1, 11), // tainted goo
						new ItemStack(ConfigItems.itemResource, 1, 11),
						new ItemStack(ConfigItems.itemResource, 1, 12), // taint tendril
						new ItemStack(ConfigItems.itemResource, 1, 12),
						new ItemStack(ConfigItems.itemResource, 1, 16), // void metal
						new ItemStack(ConfigItems.itemResource, 1, 16),
						new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4), // ethereal bloom
						new ItemStack(Items.golden_apple, 1, 1)
				}
		);
		
		ResearchItem taintVaccineResearch = new ResearchItem(
				"TAINTVACCINE", 
				"ALCHEMY", 
				new AspectList().add(Aspect.TAINT, 5).add(Aspect.MAGIC, 5).add(Aspect.HEAL, 5), 
				-1, -6, 4, new 
				ItemStack(VBItems.vaccine));
		
		taintVaccineResearch.setPages(new ResearchPage("tc.research_page.TAINTVACCINE.1"), new ResearchPage(taintVaccineRecipe));
		taintVaccineResearch.setConcealed();
		taintVaccineResearch.setParents("VOIDMETAL");
		taintVaccineResearch.registerResearchItem();
	}
	
}
