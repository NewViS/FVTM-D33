package net.fexcraft.mod.addon.d33porsche;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33porsche"/*,hasJson = false*/)
@Mod(modid = D33Porsche.MODID, name = D33Porsche.NAME, version = D33Porsche.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33Porsche {
	
    public static final String MODID = "d33porsche";
    public static final String NAME = "D33 Porsche";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
