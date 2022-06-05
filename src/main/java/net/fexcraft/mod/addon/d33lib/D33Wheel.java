package net.fexcraft.mod.addon.d33lib;
import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.8 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */

//@fModel(registryname = "d33bmw:models/part/e34_wheel")
public class D33Wheel extends PartModel {
	public ResourceLocation mdl_tyre = new ResourceLocation("d33lib:textures/model/wheel/tyre.obj");
	//public double[] scale = {1,1,1};
	public double rad = 1;
	public double wid = 1;
	//IModelCustom tyre = AdvancedModelLoader.loadModel(mdl_tyre);
	//IModelCustom rim = AdvancedModelLoader.loadModel(mdl_rim);
	public ResourceLocation e34wheel = new ResourceLocation("d33lib:textures/model/wheel/statusdisk.png");
	public ResourceLocation status_tyre = new ResourceLocation("d33lib:textures/model/wheel/status_tyre.png");
	ObjModel tyrem = new ObjParser(Resources.getModelInputStream(mdl_tyre)).flipAxes(false).readComments(false).noNormals(false).parse();
	
	public D33Wheel(ResourceLocation mdl_rim){
		super(); 
		
		ModelGroup rim = new ModelGroup("rim");
		rim.add(new ModelRendererTurbo(null, 0, 0, textureX, textureY)
			.addObj(Resources.getModelInputStream(mdl_rim))
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 180F, 0)
		);
		rim.addProgram(DefaultPrograms.WHEEL_AUTO_ALL);
		this.groups.add(rim);
		
		ModelGroup tyre = new ModelGroup("tyre");
		tyre.add(new ModelRendererTurbo(null, 0, 0, textureX, textureY)
			.copyTo(tyrem.polygons.get("status_tyre"))
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 180F, 0)
		);
		tyre.addProgram(DefaultPrograms.WHEEL_AUTO_ALL);
		this.groups.add(tyre);
	}
	
	public D33Wheel(ResourceLocation mdl_rim, ResourceLocation mdl_tyre){
		super(); 
		
		ModelGroup rim = new ModelGroup("rim");
		rim.add(new ModelRendererTurbo(null, 0, 0, textureX, textureY)
			.addObj(Resources.getModelInputStream(mdl_rim))
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 180F, 0)
		);
		rim.addProgram(DefaultPrograms.WHEEL_AUTO_ALL);
		this.groups.add(rim);
		
		ModelGroup tyre = new ModelGroup("tyre");
		tyre.add(new ModelRendererTurbo(null, 0, 0, textureX, textureY)
			.addObj(Resources.getModelInputStream(mdl_tyre))
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 180F, 0)
		);
		tyre.addProgram(DefaultPrograms.WHEEL_AUTO_ALL);
		this.groups.add(tyre);
	}
	
	@Override
	public void render(ModelRenderData data){
        GL11.glPushMatrix();
        /*rad = 1.2;
        wid = 1.5;*/
        GL11.glScaled(rad, rad, wid);
        Minecraft.getMinecraft().renderEngine.bindTexture(e34wheel);
		 	groups.get("rim").render(data);
		Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
			groups.get("tyre").render(data);
		GL11.glPopMatrix();
	}
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
        GL11.glPushMatrix();
        GL11.glScaled(rad, rad, wid);
        Minecraft.getMinecraft().renderEngine.bindTexture(e34wheel);
        //bindTexture(e34wheel);
		 	groups.get("rim").render();
		Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		//bindTexture(status_tyre);
			groups.get("tyre").render();
		GL11.glPopMatrix();
	}
}
