package net.fexcraft.mod.addon.d33trail;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33trail"/*,hasJson = false*/)
@Mod(modid = D33Trail.MODID, name = D33Trail.NAME, version = D33Trail.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33Trail {
	
    public static final String MODID = "d33trail";
    public static final String NAME = "D33 Trailer";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
