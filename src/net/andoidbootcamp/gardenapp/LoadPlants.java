package net.andoidbootcamp.gardenapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.content.res.AssetManager;
import android.util.Log;

public class LoadPlants 
{
	public LoadPlants()
	{
		
	}
	
	/**
	 *  Loads all plants from the plnats_info.txt file and creates a ArrayList.
	 *  
	 * @param assets Passed Assets for the assets folder
	 * @return The arrayList with all the plants created.
	 */
	public static ArrayList<PlantInfo> loadBrowsePlants(AssetManager assets)
	{
		ArrayList<PlantInfo> plants = new ArrayList<PlantInfo>();

		try 
		{
			BufferedReader read = new BufferedReader(new InputStreamReader(assets.open("plant_info.txt")));
			String line = "";
			
			line = read.readLine();
			
			// creates plants and adds them to a list
			while (line != null)
			{
				PlantInfo tmp = new PlantInfo();
				
				tmp.setName(line);
				tmp.setType(read.readLine());
				
				line = read.readLine();
				tmp.setHardZones(line.split(","));
				
				tmp.setSunExp(read.readLine());
				tmp.setSoilType(read.readLine());
				tmp.setSoilPH(read.readLine());
				tmp.setDes(read.readLine());
				read.readLine();
				
				line = read.readLine();
								
				plants.add(tmp);
			}
			
		}
		catch (FileNotFoundException e)
		{
			Log.d("File not Found", "Plant info file not found");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return plants;
	}

}
