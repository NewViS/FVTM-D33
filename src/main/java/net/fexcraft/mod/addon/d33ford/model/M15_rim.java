package net.fexcraft.mod.addon.d33ford.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33ford:models/part/m15_wheel") 
public class M15_rim extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33ford:textures/model/wheel/m15_disk.obj");
	static ResourceLocation mdl_tyre = new ResourceLocation("d33ford:textures/model/wheel/m15_tyre.obj");

	public M15_rim(){
		super(mdl_rim, mdl_tyre);
		
		rad = 1.15;
		wid = 1.3;
		
		e34wheel = new ResourceLocation("d33ford:textures/model/wheel/m15_rim.png");
		status_tyre = new ResourceLocation("d33ford:textures/model/wheel/p991_tyre.png");
	}
}