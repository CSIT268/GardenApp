//******************************************************************
//	PlantInfo.java					Group Project: Garden App
//
//	Created by: Matt Matuk
//
//	This class will contain all the info for a Plant.
//		Name
//		type
//		hardiness zones
//		sun exposure
//		soil type
//		soil PH
//		description
//		image file name.
//		inGarden //boolean
//		Image id
//
//******************************************************************

package net.andoidbootcamp.gardenapp;

import java.util.ArrayList;
import java.util.List;

public class PlantInfo 
{

	private String name, type, soilType, soilPH, des, sunExp;
	private List<Integer> hardZones;
	private boolean inGarden;
	private String imageIdName;
	
	public PlantInfo()
	{
		name = null;
		type = null;
		soilType = null;
		soilPH =null;
		des = null;
		sunExp =null;
		hardZones = new ArrayList<Integer>();
		inGarden = false;
		imageIdName = null;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
		imageIdName = name.toLowerCase();
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public String getSoilType() 
	{
		return soilType;
	}

	public void setSoilType(String soilType) 
	{
		this.soilType = soilType;
	}

	public String getSoilPH() 
	{
		return soilPH;
	}

	public void setSoilPH(String soilPH) 
	{
		this.soilPH = soilPH;
	}

	public String getDes() 
	{
		return des;
	}

	public void setDes(String des) 
	{
		this.des = des;
	}

	public String getSunExp() 
	{
		return sunExp;
	}

	public void setSunExp(String sunExp) 
	{
		this.sunExp = sunExp;
	}

	public List<Integer> getHardZones() 
	{
		return hardZones;
	}

	public void setHardZones(ArrayList<Integer> hardZones) 
	{
		this.hardZones = hardZones;
	}
	
	public void setHardZones(String[] hardZones)
	{
		for (String str : hardZones)
		{
			this.hardZones.add(Integer.parseInt(str));
		}
	}

	public boolean isInGarden() {
		return inGarden;
	}

	public void setInGarden(boolean inGarden) {
		this.inGarden = inGarden;
	}

	public String getImageIdName() {
		return imageIdName;
	}
	
}
