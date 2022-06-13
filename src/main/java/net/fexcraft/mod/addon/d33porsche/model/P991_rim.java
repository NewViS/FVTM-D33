package net.fexcraft.mod.addon.d33porsche.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33porsche:models/part/p991_wheel") 
public class P991_rim extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33porsche:textures/model/wheel/p991_disk.obj");
	static ResourceLocation mdl_tyre = new ResourceLocation("d33porsche:textures/model/wheel/p991_tyre.obj");

	public P991_rim(){
		super(mdl_rim, mdl_tyre);
		
		rad = 1.05;
		wid = 1.4;
		
		e34wheel = new ResourceLocation("d33porsche:textures/model/wheel/p991_rim.png");
		status_tyre = new ResourceLocation("d33porsche:textures/model/wheel/p991_tyre.png");
	}
}