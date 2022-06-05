package net.fexcraft.mod.addon.d33ford;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33ford"/*,hasJson = false*/)
@Mod(modid = D33Ford.MODID, name = D33Ford.NAME, version = D33Ford.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33Ford {
	
    public static final String MODID = "d33ford";
    public static final String NAME = "D33 Ford";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
