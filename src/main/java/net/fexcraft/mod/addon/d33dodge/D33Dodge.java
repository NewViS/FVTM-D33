package net.fexcraft.mod.addon.d33dodge;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33dodge"/*,hasJson = false*/)
@Mod(modid = D33Dodge.MODID, name = D33Dodge.NAME, version = D33Dodge.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33Dodge {
	
    public static final String MODID = "d33dodge";
    public static final String NAME = "D33 Dodge";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
