package net.andoidbootcamp.gardenapp;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MyGarden extends Activity 
{
	private TextView txtViewMyZone;
	private Button btnChangeZone;
	private ListView listViewMyPlants;
	private ArrayList<String> strListMyPlantsNames;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_garden);
		
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(android.R.color.transparent);
        
        intVar();
        
        // ads plant names
        for (PlantInfo plant : StaticVariables.myGarden)
        {
        	strListMyPlantsNames.add(plant.getName());
        }
        
        setListeners();

	}
	
	/**
	 * Initlizes all variables.
	 */
	private void intVar()
	{
		btnChangeZone = (Button)findViewById(R.id.btnMyGardenChangeZone);
		txtViewMyZone = (TextView)findViewById(R.id.textViewMyGardenZoneValue);
		listViewMyPlants = (ListView)findViewById(R.id.listViewMyGardenList);
		strListMyPlantsNames = new ArrayList<String>();
	}
	
	private void setListeners()
	{
		// change zone button 
		btnChangeZone.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				
			}
		});
		
		// list view of my garden plants
		listViewMyPlants.setAdapter(new ArrayAdapter<String>(
				this, R.layout.activity_browse, R.id.textViewbrowsePlantName, strListMyPlantsNames));
		listViewMyPlants.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> l, View v, int position,
					long id) 
			{
				StaticVariables.selectedPlant = StaticVariables.plants.get(position);
				startActivity(new Intent(MyGarden.this, Plant.class));
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_garden, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		else if (id == R.id.browse) 
		{
            //Create Intent for Product Activity
            Intent browseIntent = new Intent(this,Browse.class); 
            //Start Product Activity
            startActivity(browseIntent);
            return true;
        }
		else if (id == R.id.plant) 
		{
            //Create Intent for Product Activity
            Intent plantIntent = new Intent(this,Plant.class); 
            //Start Product Activity
            plantIntent.putExtra("plant", 0);
            startActivity(plantIntent);
            return true;
        }
        //When Search action item is clicked
        else if (id == R.id.search) 
        {
            //Display Toast
            Toast.makeText(getApplicationContext(), "Search!!", Toast.LENGTH_LONG).show();
            return true;	
        }
        return super.onOptionsItemSelected(item);
	}
}
