package net.fexcraft.mod.addon.d33gaz.model;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.addon.d33lib.D33Wheel;
import net.minecraft.util.ResourceLocation;

@fModel(registryname = "d33gaz:models/part/vlg3102_wheel") 
public class vlg3102_rim extends D33Wheel{
	static ResourceLocation mdl_rim = new ResourceLocation("d33gaz:textures/model/wheel/volgamain_volga3102.obj");

	public vlg3102_rim(){
		super(mdl_rim);
		
		rad = 1.1;
		wid = 1.1;
		
		e34wheel = new ResourceLocation("d33lib:textures/model/volga_main.png");
	}
}