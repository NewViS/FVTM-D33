package net.fexcraft.mod.addon.d33bmw;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33bmw"/*,hasJson = false*/)
@Mod(modid = D33BMW.MODID, name = D33BMW.NAME, version = D33BMW.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33BMW {
	
    public static final String MODID = "d33bmw";
    public static final String NAME = "D33 BMW";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
