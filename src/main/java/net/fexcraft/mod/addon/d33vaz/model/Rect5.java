package net.fexcraft.mod.addon.d33vaz.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;
@fModel(registryname = "d33vaz:models/part/rect5_wheel")
public class Rect5 extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33lib:textures/model/wheel/statusdisk_5rect.obj");
	public Rect5(){
		super(mdl_rim);
		e34wheel = new ResourceLocation("d33lib:textures/model/wheel/statusdisk.png");
	}
}
