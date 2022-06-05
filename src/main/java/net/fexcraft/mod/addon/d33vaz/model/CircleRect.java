package net.fexcraft.mod.addon.d33vaz.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33vaz:models/part/circlerect_wheel") 
public class CircleRect extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33vaz:textures/model/wheel/statusdisk_circlerect.obj");
	public CircleRect(){
		super(mdl_rim);
		e34wheel = new ResourceLocation("d33lib:textures/model/wheel/statusdisk.png");
	}
}