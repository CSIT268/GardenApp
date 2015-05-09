package net.andoidbootcamp.gardenapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Plant extends Activity 
{

	private TextView txtViewName, txtViewType, txtViewZone, 
		txtViewSun, txtViewSoil, txtViewPh, txtViewDes; // text view for plant info
	private Button btnAdd; // add button
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant);

		intVar();
		displaySelectionPlantInfo();
		setButtonListeners();
	
	}
	
	/**
	 * Initializes variables.
	 */
	private void intVar()
	{
		txtViewName = (TextView)findViewById(R.id.txtViewPlantName);
		txtViewType = (TextView)findViewById(R.id.textViewPlantType);
		txtViewZone = (TextView)findViewById(R.id.TextViewZonesValue);
		txtViewSun = (TextView)findViewById(R.id.textViewSunValue);
		txtViewSoil = (TextView)findViewById(R.id.TextViewSoilValue);
		txtViewPh = (TextView)findViewById(R.id.TextViewSoilPhValue);
		txtViewDes = (TextView)findViewById(R.id.TextViewDesValue);
		
		btnAdd = (Button)findViewById(R.id.btnAddPlant);
	}
	
	/**
	 * Displays the selected plant info.
	 */
	private void displaySelectionPlantInfo()
	{
		txtViewName.setText(StaticVariables.selectedPlant.getName());
		txtViewType.setText(StaticVariables.selectedPlant.getType());
		txtViewZone.setText(StaticVariables.selectedPlant.getHardZones().toString());
		txtViewSun.setText(StaticVariables.selectedPlant.getSunExp());
		txtViewSoil.setText(StaticVariables.selectedPlant.getSoilType());
		txtViewPh.setText(StaticVariables.selectedPlant.getSoilPH());
		txtViewDes.setText(StaticVariables.selectedPlant.getDes());
		
		// if plant is already in garden.
		if (StaticVariables.selectedPlant.isInGarden())
		{
			btnAdd.setVisibility(View.INVISIBLE);
		}
	}
	
	/**
	 * Adds the selected plant to the users Garden.
	 */
	private void setButtonListeners()
	{
		// for the adding plant to myGarden
		btnAdd.setOnClickListener(new OnClickListener() 
		{
			
			/**
			 * Adds the selected plant to the users garden and makes the button
			 * hidden.
			 */
			@Override
			public void onClick(View v) 
			{
				StaticVariables.myGarden.add(StaticVariables.selectedPlant);
				btnAdd.setVisibility(View.INVISIBLE);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plant, menu);
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
		else if (id == R.id.mygarden) 
		{
            //Create Intent for Product Activity
            Intent myGardenIntent = new Intent(this,MyGarden.class); 
            //Start Product Activity
            startActivity(myGardenIntent);
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
