package me.towdium.jecalculation.data.label.labels;

import me.towdium.jecalculation.data.label.ILabel;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class LContext<T extends IForgeRegistryEntry<T>> extends ILabel.Impl {
    public LContext(long amount, boolean percent) {
        super(amount, percent);
    }

    public LContext(Impl lsa) {
        super(lsa);
    }

    public LContext(CompoundTag nbt) {
        super(nbt);
    }

    public abstract Context<T> getContext();
}
