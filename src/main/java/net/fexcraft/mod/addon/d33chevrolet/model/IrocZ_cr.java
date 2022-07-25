package net.fexcraft.mod.addon.d33chevrolet.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33chevrolet:models/part/iroczcr_wheel") 
public class IrocZ_cr extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33chevrolet:textures/model/wheel/irocz_ri.obj");
	public IrocZ_cr(){
		super(mdl_rim);
		rad = 1.15;
		wid = 1.3;
		e34wheel = new ResourceLocation("d33chevrolet:textures/model/wheel/irocz_cr.png");
	}
}