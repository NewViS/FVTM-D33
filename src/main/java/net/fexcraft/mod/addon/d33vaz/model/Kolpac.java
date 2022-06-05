package net.fexcraft.mod.addon.d33vaz.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33vaz:models/part/kolpac_wheel") 
public class Kolpac extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33vaz:textures/model/wheel/statusdisk_kolpac.obj");
	public Kolpac(){
		super(mdl_rim);
		e34wheel = new ResourceLocation("d33lib:textures/model/wheel/statusdisk.png");
	}
}