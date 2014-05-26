package com.example.fecstask;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener{

	private static final String TAG = "MainActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public void onClick(View v){
    	switch (v.getId()){
    	case R.id.Google_button:
    		Log.i(TAG, "Google button Pressed");
    		Intent intent = new Intent(this, BrowseActivity.class);
    		startActivity(intent);
    		break;
    	case R.id.out_of_switch:
    		Log.i(TAG, "Screen Pressed");
    		displayToast();
    		break;
    	}
    }
    
    public void displayToast(){
    	EditText input = (EditText) findViewById(R.id.String_inputer);
    	Toast.makeText(this, input.getText(), Toast.LENGTH_SHORT).show();
    	
    	Uri uri = Uri.parse(input.getText().toString());
    	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    	try{
    		startActivity(intent);
    	}catch(ActivityNotFoundException e){
    		Toast.makeText(this, "input URL", Toast.LENGTH_SHORT).show();
    	}
    }

}
