package com.midnight.vaccinebuster.items;

import com.midnight.vaccinebuster.ItemVaccineReset;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import powercrystals.minefactoryreloaded.setup.MFRThings;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;
import thaumic.tinkerer.common.item.kami.ItemKamiResource;

public class VBItems {

	public static Item vaccine;
	public static Item syringe;
	public static Item needle;
	public static Item vaccineReset;

	public static void init() {
		vaccine = new ItemVaccine();
		syringe = new ItemSyringe();
		needle = new ItemNeedle();
		vaccineReset = new ItemVaccineReset();
	}

}
