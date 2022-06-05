package net.fexcraft.mod.addon.d33lambo;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33lambo"/*,hasJson = false*/)
@Mod(modid = D33Lambo.MODID, name = D33Lambo.NAME, version = D33Lambo.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33Lambo {
	
    public static final String MODID = "d33lambo";
    public static final String NAME = "D33 Lamborghini";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
