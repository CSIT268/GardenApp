package net.andoidbootcamp.gardenapp;

import java.util.List;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Browse extends Activity 
{
	private static List<PlantInfo> plants = null; // list of all plants
	private ListView listViewPlants;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse);
		
		TextView test = (TextView)findViewById(R.id.textView1);
		
		listViewPlants = (ListView)findViewById(R.id.listViewPlants);
		loadPlants(getAssets());
		
		for (PlantInfo plant : plants)
		{
			Log.d("test", plant.getDes());	
		}
		
		
		
	}

	/**
	 * Loads all the plants info into the plants array by reading the plant_info.txt file
	 */
	private void loadPlants(AssetManager assets)
	{
		if (plants == null)
		{			
			plants = LoadPlants.loadBrowsePlants(assets);
		}
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
