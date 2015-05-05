package net.andoidbootcamp.gardenapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyGarden extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_garden);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(android.R.color.transparent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_garden, menu);
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
		else if (id == R.id.browse) {
            //Create Intent for Product Activity
            Intent browseIntent = new Intent(this,Browse.class); 
            //Start Product Activity
            startActivity(browseIntent);
            return true;
        }
		else if (id == R.id.plant) {
            //Create Intent for Product Activity
            Intent plantIntent = new Intent(this,Plant.class); 
            //Start Product Activity
            plantIntent.putExtra("plant", 0);
            startActivity(plantIntent);
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
