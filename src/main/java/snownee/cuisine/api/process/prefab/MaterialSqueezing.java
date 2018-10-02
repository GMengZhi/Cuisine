package snownee.cuisine.api.process.prefab;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import snownee.cuisine.CuisineRegistry;
import snownee.cuisine.api.Form;
import snownee.cuisine.api.Ingredient;
import snownee.cuisine.api.Material;
import snownee.cuisine.api.MaterialCategory;
import snownee.cuisine.api.process.BasinInteracting;
import snownee.cuisine.fluids.CuisineFluids;
import snownee.cuisine.internal.CuisinePersistenceCenter;

public class MaterialSqueezing implements BasinInteracting
{
    private final Material material;

    public MaterialSqueezing(Material material)
    {
        if (!(material.isValidForm(Form.JUICE) && (material.isUnderCategoryOf(MaterialCategory.FRUIT) || material.isUnderCategoryOf(MaterialCategory.VEGETABLES))))
        {
            throw new IllegalArgumentException(String.format("material {} cannot make juice", material));
        }
        this.material = material;
    }

    @Override
    public boolean matches(ItemStack item, @Nullable FluidStack fluid)
    {
        Ingredient ingredient = null;
        if (item.getItem() == CuisineRegistry.INGREDIENT)
        {
            NBTTagCompound data = item.getTagCompound();
            if (data == null)
            {
                return false;
            }
            ingredient = CuisinePersistenceCenter.deserializeIngredient(data);
        }
        else
        {
            ingredient = Ingredient.make(item, 0.5F);
        }
        return ingredient != null && ingredient.getMaterial() == material && (fluid == null || fluid.getFluid() == CuisineFluids.JUICE);
    }

    @Override
    public Output getOutput(ItemStack item, @Nullable FluidStack fluid)
    {
        Ingredient ingredient = null;
        if (item.getItem() == CuisineRegistry.INGREDIENT)
        {
            NBTTagCompound data = item.getTagCompound();
            if (data == null)
            {
                return null;
            }
            ingredient = CuisinePersistenceCenter.deserializeIngredient(data);
        }
        else
        {
            ingredient = Ingredient.make(item, 0.5F);
        }
        if (ingredient == null)
        {
            return null;
        }
        int amount = fluid == null ? 0 : fluid.amount;
        amount += ingredient.getSize() * 500; // TODO: fine tuning
        FluidStack outputFluid = fluid == null ? new FluidStack(CuisineFluids.JUICE, amount) : new FluidStack(fluid, amount);
        return new Output(outputFluid, ItemStack.EMPTY);
    }

}