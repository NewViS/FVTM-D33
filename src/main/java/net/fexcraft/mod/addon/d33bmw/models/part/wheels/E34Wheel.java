package net.fexcraft.mod.addon.d33bmw.models.part.wheels;
import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.part.PartData;
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

@fModel(registryname = "d33bmw:models/part/e34_wheel")
public class E34Wheel extends PartModel {
	ResourceLocation mdl_tyre = new ResourceLocation("d33lib:textures/model/wheel/tyre.obj");
	ResourceLocation mdl_rim = new ResourceLocation("d33bmw:textures/model/wheel/e34wheel_e34rims.obj");
	//IModelCustom tyre = AdvancedModelLoader.loadModel(mdl_tyre);
	//IModelCustom rim = AdvancedModelLoader.loadModel(mdl_rim);
	ResourceLocation e34wheel = new ResourceLocation("d33bmw:textures/model/wheel/e34wheel.png");
	ResourceLocation status_tyre = new ResourceLocation("d33lib:textures/model/wheel/status_tyre.png");
	ObjModel tyrem = new ObjParser(Resources.getModelInputStream(mdl_tyre)).flipAxes(false).readComments(false).noNormals(false).parse();
	ObjModel rimm = new ObjParser(Resources.getModelInputStream(mdl_rim)).flipAxes(false).readComments(false).noNormals(false).parse();
	
	public E34Wheel(){
		super(); textureX = 512; textureY = 256;
		ModelGroup rim = new ModelGroup("rim");
		rim.add(new ModelRendererTurbo(null, 0, 0, textureX, textureY)
			.copyTo(rimm.polygons.get("wheel_rim"))
			.copyTo(rimm.polygons.get("___________"))
			.copyTo(rimm.polygons.get("disk"))
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
	@Override
	public void render(ModelRenderData data){
        GL11.glPushMatrix();
        GL11.glScaled(1.1, 1.1, 1.2);
        Minecraft.getMinecraft().renderEngine.bindTexture(e34wheel);
        //bindTexture(e34wheel);
		 	groups.get("rim").render(data);
		Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		//bindTexture(status_tyre);
			groups.get("tyre").render(data);
		GL11.glPopMatrix();
	}
	@Override
	public void renderItem(ItemStack item, PartData data){
        GL11.glPushMatrix();
        GL11.glScaled(1.1, 1.1, 1.2);
        Minecraft.getMinecraft().renderEngine.bindTexture(e34wheel);
        //bindTexture(e34wheel);
		 	groups.get("rim").render();
		Minecraft.getMinecraft().renderEngine.bindTexture(status_tyre);
		//bindTexture(status_tyre);
			groups.get("tyre").render();
		GL11.glPopMatrix();
	}
}
