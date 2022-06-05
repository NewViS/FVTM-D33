package net.fexcraft.mod.addon.d33vaz;

import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.minecraftforge.fml.common.Mod;

@AddonClass(registryname = "fvtm:d33vaz"/*,hasJson = false*/)
@Mod(modid = D33Vaz.MODID, name = D33Vaz.NAME, version = D33Vaz.VERSION, useMetadata = true, dependencies = "required-after:fcl;required-after:fvtm")
public class D33Vaz {
	
    public static final String MODID = "d33vaz";
    public static final String NAME = "D33 VAZ";
    public static final String VERSION = "0.1";
    
    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    }*/
}
