package net.fexcraft.mod.addon.d33ford.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33ford:models/part/m15_white") 
public class M15_white extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33ford:textures/model/wheel/m15_white.obj");
	static ResourceLocation mdl_tyre = new ResourceLocation("d33ford:textures/model/wheel/m15_tyre.obj");

	public M15_white(){
		super(mdl_rim, mdl_tyre);
		
		rad = 1.15;
		wid = 1.3;
		
		e34wheel = new ResourceLocation("d33ford:textures/model/wheel/m15_white.png");
		status_tyre = new ResourceLocation("d33ford:textures/model/wheel/p991_tyre.png");
	}
}