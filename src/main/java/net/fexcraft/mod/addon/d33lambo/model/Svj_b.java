package net.fexcraft.mod.addon.d33lambo.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33lambo:models/part/svjb_wheel") 
public class Svj_b extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33lambo:textures/model/wheel/avrims_disk.obj");
	public Svj_b(){
		super(mdl_rim);
		rad = 1.25;
		wid = 1.6;
		e34wheel = new ResourceLocation("d33lambo:textures/model/wheel/svjb.png");
	}
}