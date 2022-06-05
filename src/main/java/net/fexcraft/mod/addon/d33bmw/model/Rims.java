package net.fexcraft.mod.addon.d33bmw.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;
@fModel(registryname = "d33bmw:models/part/f90_wheel")
public class Rims extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33bmw:textures/model/wheel/m5wheel_m5rims.obj");
	public Rims(){
		super(mdl_rim);
		e34wheel = new ResourceLocation("d33bmw:textures/model/wheel/m5wheel.png");
		rad = 1.2;
		wid = 1.5;
	}
}
