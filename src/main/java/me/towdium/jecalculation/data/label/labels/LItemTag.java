package me.towdium.jecalculation.data.label.labels;

import me.towdium.jecalculation.gui.JecaGui;
import me.towdium.jecalculation.gui.Resource;
import me.towdium.jecalculation.utils.Utilities;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Author: towdium
 * Date:   17-9-10.
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class LItemTag extends LTag<Item> {
    public static final String IDENTIFIER = "itemTag";

    public LItemTag(TagKey<Item> name) {
        super(name);
    }

    public LItemTag(TagKey<Item> name, long amount) {
        super(name, amount);
    }

    public LItemTag(LTag<Item> lt) {
        super(lt);
    }

    public LItemTag(CompoundTag nbt) {
        super(nbt);
    }

    @Override
    protected IForgeRegistry<Item> getRegistry() {
        return ForgeRegistries.ITEMS;
    }

    @Override
    protected void drawLabel(int xPos, int yPos, JecaGui gui, boolean hand) {
        Object o = getRepresentation();
        if (o instanceof ItemStack) gui.drawItemStack(xPos, yPos, (ItemStack) o, false, hand);
        gui.drawResource(Resource.LBL_FRAME, xPos, yPos);
    }

    @Override
    public LTag<Item> copy() {
        return new LItemTag(this);
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public Context<Item> getContext() {
        return Context.ITEM;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getDisplayName() {
        return Utilities.I18n.get("label.item_tag.name", name.location());
    }
}
