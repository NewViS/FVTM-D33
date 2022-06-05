package ru.stannis.graphics.model.techne;

import net.minecraft.util.ResourceLocation;
import ru.d33.graphics.model.IModelCustom;
import ru.d33.graphics.model.IModelCustomLoader;
import ru.d33.graphics.model.ModelFormatException;

public class TechneModelLoader implements IModelCustomLoader {
    
    @Override
    public String getType()
    {
        return "Techne model";
    }

    private static final String[] types = { "tcn" };
    @Override
    public String[] getSuffixes()
    {
        return types;
    }

    @Override
    public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
    {
        return new TechneModel(resource);
    }

}
