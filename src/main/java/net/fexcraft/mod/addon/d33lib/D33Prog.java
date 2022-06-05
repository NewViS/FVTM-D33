package net.fexcraft.mod.addon.d33lib;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonElement;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.root.Model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelGroup.Program;

public class D33Prog extends DefaultPrograms{
	public static void init(){
		ModelGroup.PROGRAMS.add(new SteerWh(0,0,0,0,0)); //isCent,x,y,z,rot
		ModelGroup.PROGRAMS.add(new ARotator("",false,0,0,0,0,0,0,0,0,0)); //Attr,bool,min,max,step,x,y,z,ax,ay,az
		ModelGroup.PROGRAMS.add(WIPERS);
		ModelGroup.PROGRAMS.add(new DCol(0,0,0)); //RGB
		ModelGroup.PROGRAMS.add(new DColA(0,0,0,1)); //RGBA
	}
	
	public static class SteerWh implements Program{
		private double d=0.0625;
		private int isCent; private double r,x,y,z; private String id = "d33:steer";
		public SteerWh(int isCent, double x, double y, double z, double r){
			this.isCent=isCent;this.x=x;this.y=y;this.z=z;this.r=r;
		}
		@Override
		public String getId(){
			return id;
		}
		
		@Override
		//public void preRender(ModelGroup list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
		public void preRender(ModelGroup list, ModelRenderData data){
			//d=0.0625;
			GL11.glPushMatrix();
			GL11.glTranslated(x*d, y*d, z*d);
			GL11.glRotated(-r, 1f, 0.0f, 0f);
			GL11.glRotated(data.vehicle.getAttribute("steering_angle").float_value() *3.14f * -15, 0F, 0f, 1f);
			//System.out.println(data.getAttribute(""));
						
			if(isCent==0){
			GL11.glRotated(r, 1f, 0.0f, 0f);
			GL11.glTranslated(-x*d, -y*d, -z*d);
			}
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			GL11.glPopMatrix();
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new SteerWh(elm.getAsJsonArray().get(0).getAsInt(), elm.getAsJsonArray().get(1).getAsDouble(), elm.getAsJsonArray().get(2).getAsDouble(), elm.getAsJsonArray().get(3).getAsDouble(), elm.getAsJsonArray().get(4).getAsDouble());
		}
		

		@Override
		public Program parse(String[] args){
			return new SteerWh(Integer.parseInt(args[0]), Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		}
	};
	
	public static class ARotator extends AttributeBased{
		private Attribute<?> attr;
		private Float current;
		
		private double d=0.0625;
		private boolean bool;
		private double min,max,step,x,y,z,ax,ay,az;
		private String id = "d33:atrot";
		public ARotator(String attr1,boolean bool,double min,double max,double step,double x,double y,double z,double ax,double ay, double az){
			super(attr1);
			this.bool=bool;
			this.min=min;this.max=max;this.step=step;this.x=x;this.y=y;this.z=z;this.ay=ay;this.ax=ax;this.az=az;
		}
		@Override
		public String getId(){
			return id;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			current = data.cache.getValue(cacheid);
			if(current == null) current = 0f;
			current = (float) (bool ? (attr.boolean_value() ? current + step : current - step) : attr.float_value() * step);
			if(current > max) current = (float) max;
			if(current < min) current = (float) min;
			
			GL11.glPushMatrix();
			GL11.glTranslated(x*d, y*d, -z*d);
			GL11.glRotated(current, ax, ay, az);
			GL11.glTranslated(-x*d, -y*d, z*d);
			
			data.cache.setValue(cacheid, current);
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			GL11.glPopMatrix();
		}
		
		/*@Override
		public Program parse(JsonElement elm){
			return new SteerWh(elm.getAsJsonArray().get(0).getAsInt(), elm.getAsJsonArray().get(1).getAsInt(), elm.getAsJsonArray().get(2).getAsInt(), elm.getAsJsonArray().get(3).getAsInt(), elm.getAsJsonArray().get(4).getAsDouble());
		}*/
		

		@Override
		public Program parse(String[] args){
			return new ARotator(args[0],Boolean.parseBoolean(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Double.parseDouble(args[5]),Double.parseDouble(args[6]),Double.parseDouble(args[7]),Double.parseDouble(args[8]),Double.parseDouble(args[9]),Double.parseDouble(args[10]));
		}
	};
	
	public static final Program WIPERS =new Program(){
		private boolean ison, ret = false;
		private float moved;
		private String id = "d33:wipers";
		@Override
		public String getId(){
			return id;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			ison = data.vehicle.getAttribute("windshield_wipers").boolean_value();
			moved = data.cache.getValue("wipers_moved", 0f);
			if(ison && !ret){
				moved += 0.5f;
			}
			if(moved >= 110 || ret || (!ison && moved > 0)){
				ret = true;
				moved -= 0.5f;
			}
			if(moved <= 0f){
				ret = false;
				moved = 0f;
			}
			if(moved != 0f){
				for(ModelRendererTurbo mrt : list) mrt.rotationAngleX = moved;
			}
			data.cache.setValue("wipers_moved", moved);
		}
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(moved != 0f) for(ModelRendererTurbo mrt : list){ mrt.rotationAngleX = 0; }
		}
	};

	public static class DCol implements Program{
		//private double d=0.0625;
		private int r,g,b; private String id = "d33:col";
		public DCol(int r, int g, int b){
			this.r=r;this.g=g;this.b=b;
		}
		@Override
		public String getId(){
			return id;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			//d=0.0625;
			//GL11.glPushMatrix();
			GL11.glColor3f(r/255F, g/255F, b/255F);
			
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			RGB.glColorReset();
			//GL11.glPopMatrix();
		}
		
		
		@Override
		public Program parse(JsonElement elm){
			return new DCol(elm.getAsJsonArray().get(0).getAsInt(), elm.getAsJsonArray().get(1).getAsInt(), elm.getAsJsonArray().get(2).getAsInt());
		}
		

		@Override
		public Program parse(String[] args){
			return new DCol(Integer.parseInt(args[0]), Integer.parseInt(args[1]),Integer.parseInt(args[2]));
		}
	};
	
	public static class DColA implements Program{
		//private double d=0.0625;
		private int r,g,b; private String id = "d33:cola"; private double a;
		public DColA(int r, int g, int b, double a){
			this.r=r;this.g=g;this.b=b;this.a=a;
		}
		@Override
		public String getId(){
			return id;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			//d=0.0625;
			//GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glColor4d(r/255F, g/255F, b/255F, a);
			
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			RGB.glColorReset();
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
			//GL11.glPopMatrix();
		}
		
		
		@Override
		public Program parse(JsonElement elm){
			return new DColA(elm.getAsJsonArray().get(0).getAsInt(), elm.getAsJsonArray().get(1).getAsInt(), elm.getAsJsonArray().get(2).getAsInt(), elm.getAsJsonArray().get(3).getAsDouble());
		}
		

		@Override
		public Program parse(String[] args){
			return new DColA(Integer.parseInt(args[0]), Integer.parseInt(args[1]),Integer.parseInt(args[2]),Double.parseDouble(args[3]));
		}
	};
}
