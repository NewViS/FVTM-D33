package net.fexcraft.mod.addon.d33gaz;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33gaz"/*,hasJson = false*/)
@Mod(modid = D33Gaz.MODID, name = D33Gaz.NAME, version = D33Gaz.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33Gaz {
	
    public static final String MODID = "d33gaz";
    public static final String NAME = "D33 GAZ";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
