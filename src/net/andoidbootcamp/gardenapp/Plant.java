package net.andoidbootcamp.gardenapp;

import android.R.id;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Plant extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant);
		ImageView plantImage = (ImageView)findViewById(R.id.plantImage);
		ListView plantDetails = (ListView)findViewById(R.id.plantDetails);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plant, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		else if (id == R.id.mygarden) {
            //Create Intent for Product Activity
            Intent myGardenIntent = new Intent(this,MyGarden.class); 
            //Start Product Activity
            startActivity(myGardenIntent);
            return true;
        }
		else if (id == R.id.browse) {
            //Create Intent for Product Activity
            Intent browseIntent = new Intent(this,Browse.class); 
            //Start Product Activity
            startActivity(browseIntent);
            return true;
        }
        //When Search action item is clicked
        else if (id == R.id.search) {
            //Display Toast
            Toast.makeText(getApplicationContext(), "Search!!", Toast.LENGTH_LONG).show();
            return true;	
	}
        return super.onOptionsItemSelected(item);
}
}
