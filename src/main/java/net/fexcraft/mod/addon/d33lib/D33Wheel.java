package net.fexcraft.mod.addon.d33lib;
import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler.WheelData;
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
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof PartItem == false) return;
		PartData data = item.getCapability(Capabilities.VAPDATA, null).getPartData();
		if(data == null) return;
		PartModel model = (PartModel)data.getType().getModel();
		if(model == null) return;
		//
		GL11.glPushMatrix();
		switch(type){
			case GROUND: {
				GL11.glTranslatef(-0.45F, -0.05F, 0);
				break;
			}
			case FIXED: {
				GL11.glRotatef(180f, 0F, 1F, 0F);
				GL11.glTranslatef(0, 0, -0.15f);
				break;
			}
			case THIRD_PERSON_RIGHT_HAND:{
				GL11.glRotatef(90f, 0F, 1F, 0F);
				//GL11.glTranslatef(-(func.getWidth() * Static.sixteenth), -0.2f, 0);
				GL11.glScalef(.75f, .75f, .75f);
				break;
			}
			case THIRD_PERSON_LEFT_HAND: {
				GL11.glRotatef(-90f, 0F, 1F, 0F);
				//GL11.glTranslatef(-(func.getWidth() * Static.sixteenth), -0.2f, 0);
				GL11.glScalef(.75f, .75f, .75f);
				break;
			}
			case FIRST_PERSON_LEFT_HAND: {
				GL11.glRotatef(60f, 0F, 1F, 0F);
				GL11.glScalef(.5f, .5f, .5f);
				break;
			}
			case FIRST_PERSON_RIGHT_HAND: {
				GL11.glRotatef(-60f, 0F, 1F, 0F);
				GL11.glScalef(.5f, .5f, .5f);
				break;
			}
			case GUI: {
				WheelData ihdata = data.getType().getInstallationHandlerData();
				if(ihdata.getRadius() > 8){
					for(int i = (int)ihdata.getRadius(); i > 8; i--)
					GL11.glScalef(1 - Static.sixteenth, 1 - Static.sixteenth, 1 - Static.sixteenth);
				}
				break;
			}
			case HEAD: {
				// TODO
				break;
			}
			default: break;
		}
		GL11.glPushMatrix();
		GL11.glRotatef(1, 0, 180, 0);
		model.transforms.apply();
		model.renderItem(item, data);
		model.transforms.deapply();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	@Override
	public void render(ModelRenderData data){
        GL11.glPushMatrix();
        GL11.glScaled(rad, rad, wid);
        Minecraft.getMinecraft().renderEngine.bindTexture(e34wheel);
		 	groups.get("rim").render(data);
		Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
			groups.get("tyre").render(data);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderItem(ItemStack item, PartData data){
        GL11.glPushMatrix();
        GL11.glScaled(rad, rad, wid);
        Minecraft.getMinecraft().renderEngine.bindTexture(e34wheel);
		 	groups.get("rim").render();
		Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
			groups.get("tyre").render();
		GL11.glPopMatrix();
	}
}
