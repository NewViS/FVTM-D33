package net.fexcraft.mod.addon.d33lib;

import java.io.File;

import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.discovery.ContainerType;

@AddonClass(registryname = "fvtm:d33lib"/*,hasJson = false*/)
@Mod(modid = D33LIB.MODID, name = D33LIB.NAME, version = D33LIB.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33LIB {
	
    public static final String MODID = "d33lib";
    public static final String NAME = "D33 LIB";
    public static final String VERSION = "0.1";
    
    @AddonClass(registryname = "fvtm:d33", hasJson = false)
    public static class D33Addon extends Addon {
        
        public D33Addon(ContainerType type, File file){
            super(type, file);
            registryname = new ResourceLocation("fvtm:d33");
            name = NAME;
            version = VERSION;
            authors.add("NewViS");
            update_id = "test";
            url = "https://fexcraft.net/minecraft/mod?id=d33";
            license = "https://fexcraft.net/license?id=mods";
            registerer = new AutoRegisterer(this.getRegistryName().getPath());
            if(Static.side().isClient()){
                //(creativetabs = new HashMap<>()).put(AddonTab.DEFAULT, new AddonTab(this, AddonTab.DEFAULT));
                D33Prog.init();
            }
        }
        
    }
}
