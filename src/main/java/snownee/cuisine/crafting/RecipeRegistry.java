package snownee.cuisine.crafting;

import com.google.common.collect.ImmutableList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import snownee.cuisine.Cuisine;
import snownee.cuisine.CuisineConfig;
import snownee.cuisine.CuisineRegistry;
import snownee.cuisine.api.CulinaryHub;
import snownee.cuisine.api.Form;
import snownee.cuisine.api.MaterialCategory;
import snownee.cuisine.api.process.Chopping;
import snownee.cuisine.api.process.Grinding;
import snownee.cuisine.api.process.Milling;
import snownee.cuisine.api.process.Processing;
import snownee.cuisine.api.process.Vessel;
import snownee.cuisine.api.process.prefab.DistillationBoiling;
import snownee.cuisine.api.process.prefab.MaterialSqueezing;
import snownee.cuisine.api.process.prefab.SimpleSqueezing;
import snownee.cuisine.api.process.prefab.SimpleThrowing;
import snownee.cuisine.fluids.CuisineFluids;
import snownee.cuisine.fluids.FluidJuice;
import snownee.cuisine.items.ItemBasicFood;
import snownee.kiwi.util.definition.ItemDefinition;
import snownee.kiwi.util.definition.OreDictDefinition;

public class RecipeRegistry
{
    public static void postInit()
    {
        DrinkBrewingRecipe.add(CulinaryHub.CommonMaterials.CORN);
        DrinkBrewingRecipe.add(CulinaryHub.CommonMaterials.CUCUMBER);
        DrinkBrewingRecipe.add(CulinaryHub.CommonMaterials.TOMATO);
        DrinkBrewingRecipe.add(CulinaryHub.CommonMaterials.PUMPKIN);
        DrinkBrewingRecipe.add(CulinaryHub.CommonMaterials.GINGER);
    }

    public static void init()
    {
        if (CuisineConfig.GENERAL.axeChopping)
        {
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "stick"), OreDictDefinition.of("plankWood"), new ItemStack(Items.STICK, CuisineConfig.GENERAL.axeChoppingStickOutput)));
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "oak"), ItemDefinition.of(Blocks.LOG), new ItemStack(Blocks.PLANKS, CuisineConfig.GENERAL.axeChoppingPlanksOutput)));
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "spruce"), ItemDefinition.of(Blocks.LOG, 1), new ItemStack(Blocks.PLANKS, CuisineConfig.GENERAL.axeChoppingPlanksOutput, 1)));
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "birch"), ItemDefinition.of(Blocks.LOG, 2), new ItemStack(Blocks.PLANKS, CuisineConfig.GENERAL.axeChoppingPlanksOutput, 2)));
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "jungle"), ItemDefinition.of(Blocks.LOG, 3), new ItemStack(Blocks.PLANKS, CuisineConfig.GENERAL.axeChoppingPlanksOutput, 3)));
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "acacia"), ItemDefinition.of(Blocks.LOG2), new ItemStack(Blocks.PLANKS, CuisineConfig.GENERAL.axeChoppingPlanksOutput, 4)));
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "dark_oak"), ItemDefinition.of(Blocks.LOG2, 1), new ItemStack(Blocks.PLANKS, CuisineConfig.GENERAL.axeChoppingPlanksOutput, 5)));
            Processing.CHOPPING.add(new Chopping(new ResourceLocation(Cuisine.MODID, "citrus"), ItemDefinition.of(CuisineRegistry.LOG), new ItemStack(CuisineRegistry.PLANKS, CuisineConfig.GENERAL.axeChoppingPlanksOutput)));
        }

        Processing.GRINDING.add(new Grinding(new ResourceLocation(Cuisine.MODID, "rice"), ImmutableList.of(OreDictDefinition.of("cropRice", 1)), CuisineRegistry.BASIC_FOOD.getItemStack(ItemBasicFood.Variant.WHITE_RICE), 4));
        Processing.GRINDING.add(new Grinding(new ResourceLocation(Cuisine.MODID, "salt"), ImmutableList.of(OreDictDefinition.of("dustCrudesalt", 1)), CuisineRegistry.MATERIAL.getItemStack(Cuisine.Materials.SALT), 10));

        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "chili_powder"), OreDictDefinition.of("cropChilipepper"), CuisineRegistry.MATERIAL.getItemStack(Cuisine.Materials.CHILI_POWDER)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "sichuan_pepper_powder"), OreDictDefinition.of("cropSichuanpepper"), CuisineRegistry.MATERIAL.getItemStack(Cuisine.Materials.SICHUAN_PEPPER_POWDER)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "flour"), new ItemStack(Items.WHEAT), CuisineRegistry.BASIC_FOOD.getItemStack(ItemBasicFood.Variant.FLOUR)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "rice_powder"), OreDictDefinition.of("foodRice"), CuisineRegistry.BASIC_FOOD.getItemStack(ItemBasicFood.Variant.RICE_POWDER)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "salt"), OreDictDefinition.of("dustCrudesalt"), CuisineRegistry.MATERIAL.getItemStack(Cuisine.Materials.SALT)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "sesame_oil"), OreDictDefinition.of("cropSesame"), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.SESAME_OIL, 20)));

        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_peanut"), OreDictDefinition.of("cropPeanut"), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 100)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_rice"), OreDictDefinition.of("cropRice"), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 20)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_rice_seed"), OreDictDefinition.of("seedRice"), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 20)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_corn"), OreDictDefinition.of("cropCorn"), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 100)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_beet_seed"), new ItemStack(Items.BEETROOT_SEEDS), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 20)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_melon_seed"), new ItemStack(Items.MELON_SEEDS), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 40)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_pumpkin_seed"), new ItemStack(Items.PUMPKIN_SEEDS), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 40)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "oil_from_wheat_seed"), new ItemStack(Items.WHEAT_SEEDS), ItemStack.EMPTY, null, new FluidStack(CuisineFluids.EDIBLE_OIL, 20)));

        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "soybean_milk"), OreDictDefinition.of("cropSoybean"), ItemStack.EMPTY, new FluidStack(FluidRegistry.WATER, 100), new FluidStack(CuisineFluids.SOY_MILK, 100)));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "bonemeal"), OreDictDefinition.of("bone"), new ItemStack(Items.DYE, 4, 15), null, null));
        Processing.MILLING.add(new Milling(new ResourceLocation(Cuisine.MODID, "prismarine_crystals"), new ItemStack(Items.PRISMARINE_SHARD), new ItemStack(Items.PRISMARINE_CRYSTALS), null, null));

        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_rice_powder"), ItemDefinition.of(CuisineRegistry.BASIC_FOOD, ItemBasicFood.Variant.RICE_POWDER.getMeta()), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.RICE_VINEGAR, 20)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_rice"), OreDictDefinition.of("cropRice"), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.RICE_VINEGAR, 30)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_rice_seed"), OreDictDefinition.of("foodRice"), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.RICE_VINEGAR, 20)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "pickled_pepper"), OreDictDefinition.of("cropChilipepper"), FluidRegistry.WATER, ItemDefinition.of(CuisineRegistry.BASIC_FOOD, ItemBasicFood.Variant.PICKLED_PEPPER.getMeta()), null, OreDictDefinition.of("dustSalt")));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "pickled_cucumber"), OreDictDefinition.of("cropCucumber"), FluidRegistry.WATER, ItemDefinition.of(CuisineRegistry.BASIC_FOOD, ItemBasicFood.Variant.PICKLED_CUCUMBER.getMeta()), null, OreDictDefinition.of("dustSalt")));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "pickled_cabbage"), OreDictDefinition.of("cropCabbage"), FluidRegistry.WATER, ItemDefinition.of(CuisineRegistry.BASIC_FOOD, ItemBasicFood.Variant.PICKLED_CABBAGE.getMeta()), null, OreDictDefinition.of("dustSalt")));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "pickled_turnip"), OreDictDefinition.of("cropTurnip"), FluidRegistry.WATER, ItemDefinition.of(CuisineRegistry.BASIC_FOOD, ItemBasicFood.Variant.PICKLED_TURNIP.getMeta()), null, OreDictDefinition.of("dustSalt")));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "soy_sauce"), OreDictDefinition.of("cropSoybean"), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.SOY_SAUCE, 20)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_apple"), ItemDefinition.of(Items.APPLE), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.FRUIT_VINEGAR, 10)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_golden_apple"), ItemDefinition.of(Items.GOLDEN_APPLE), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.FRUIT_VINEGAR, 20)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_enchanted_apple"), ItemDefinition.of(Items.GOLDEN_APPLE, 1), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.FRUIT_VINEGAR, 100)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_melon"), ItemDefinition.of(Items.MELON), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.FRUIT_VINEGAR, 5)));
        Processing.VESSEL.add(new Vessel(new ResourceLocation(Cuisine.MODID, "vinegar_from_melon_block"), ItemDefinition.of(Blocks.MELON_BLOCK), FluidRegistry.WATER, ItemDefinition.EMPTY, new FluidStack(CuisineFluids.FRUIT_VINEGAR, 50)));

        Processing.BOILING.add(new DistillationBoiling(new ResourceLocation(Cuisine.MODID, "crude_salt"), new FluidStack(FluidRegistry.WATER, 200), CuisineRegistry.MATERIAL.getItemStack(Cuisine.Materials.CRUDE_SALT), 0));
        Processing.BOILING.add(new DistillationBoiling(new ResourceLocation(Cuisine.MODID, "unfined_sugar_from_sugarcane"), new FluidStack(CuisineFluids.SUGARCANE_JUICE, 200), CuisineRegistry.MATERIAL.getItemStack(Cuisine.Materials.UNREFINED_SUGAR), 2));
        Processing.BOILING.add(new DistillationBoiling(new ResourceLocation(Cuisine.MODID, "unfined_sugar_from_beet"), FluidJuice.make(CulinaryHub.CommonMaterials.BEETROOT, 200), CuisineRegistry.MATERIAL.getItemStack(Cuisine.Materials.UNREFINED_SUGAR), 2));

        ItemStack sugar = new ItemStack(Items.SUGAR);
        Processing.BASIN_THROWING.add(new SimpleThrowing(new ResourceLocation(Cuisine.MODID, "sugar_from_bamboo_and_sugarcane"), ItemDefinition.of(CuisineRegistry.MATERIAL, Cuisine.Materials.BAMBOO_CHARCOAL.getMeta()), new FluidStack(CuisineFluids.SUGARCANE_JUICE, 200), sugar));
        Processing.BASIN_THROWING.add(new SimpleThrowing(new ResourceLocation(Cuisine.MODID, "sugar_from_charcoal_and_sugarcane"), ItemDefinition.of(Items.COAL, 1), new FluidStack(CuisineFluids.SUGARCANE_JUICE, 200), sugar));
        Processing.BASIN_THROWING.add(new SimpleThrowing(new ResourceLocation(Cuisine.MODID, "sugar_from_bamboo_and_beet"), ItemDefinition.of(CuisineRegistry.MATERIAL, Cuisine.Materials.BAMBOO_CHARCOAL.getMeta()), FluidJuice.make(CulinaryHub.CommonMaterials.BEETROOT, 200), sugar));
        Processing.BASIN_THROWING.add(new SimpleThrowing(new ResourceLocation(Cuisine.MODID, "sugar_from_charcoal_and_beet"), ItemDefinition.of(Items.COAL, 1), FluidJuice.make(CulinaryHub.CommonMaterials.BEETROOT, 200), sugar));
        if (CuisineConfig.GENERAL.basinConvertingConcrete)
        {
            FluidStack inputFluid = new FluidStack(FluidRegistry.WATER, 125);
            for (int i = 0; i < 16; i++)
            {
                Processing.BASIN_THROWING.add(new SimpleThrowing(new ResourceLocation(Cuisine.MODID, EnumDyeColor.byMetadata(i).getName() + "_concrete"), ItemDefinition.of(Blocks.CONCRETE_POWDER, i), inputFluid, new ItemStack(Blocks.CONCRETE, 1, i)));
            }
        }

        Processing.SQUEEZING.add(new SimpleSqueezing(new ResourceLocation(Cuisine.MODID, "sugarcane_squeezing"), OreDictDefinition.of("sugarcane"), new FluidStack(CuisineFluids.SUGARCANE_JUICE, 200)));

        CulinaryHub.API_INSTANCE.getKnownMaterials().stream().filter(m -> m.isValidForm(Form.JUICE)).filter(m -> m.isUnderCategoryOf(MaterialCategory.FRUIT) || m.isUnderCategoryOf(MaterialCategory.VEGETABLES) || m.isUnderCategoryOf(MaterialCategory.GRAIN)).forEach(m -> Processing.SQUEEZING.add(new MaterialSqueezing(m)));

    }
}
