package net.andoidbootcamp.gardenapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Browse extends Activity 
{
	private ArrayList<String> plantNames;
	private ListView listViewPlants;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse);
		
		intVar();
		loadPlants();
			
		for (PlantInfo plant : StaticVariables.plants)
		{
			plantNames.add(plant.getName());
		}
		
		listViewPlants.setAdapter(new ArrayAdapter<String>(
				this, R.layout.activity_browse, R.id.textViewbrowsePlantName, plantNames));
		listViewPlants.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> l, View v, int position,
					long id) 
			{
				StaticVariables.selectedPlant = StaticVariables.plants.get(position);
				startActivity(new Intent(Browse.this, Plant.class));
			}
			
		});

	}
	
	/**
	 * Initializes variables.
	 */
	private void intVar()
	{
		plantNames = new ArrayList<String>();
		listViewPlants = (ListView)findViewById(R.id.listViewBrowsePlants);
	}
	
	/**
	 * Loads all the plants info into the plants array by reading the plant_info.txt file
	 */
	private void loadPlants()
	{
		StaticVariables.plants = LoadPlants.loadBrowsePlants(getAssets());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.browse, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
