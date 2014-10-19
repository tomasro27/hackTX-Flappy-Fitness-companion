package com.hacktx.vrfitness;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD:VRFitness/mobile/src/main/java/com/hacktx/vrfitness/Home.java
=======
import com.parse.Parse;
import com.parse.ParseAnalytics;
>>>>>>> eff5abaed3633686b4576a08fe4654a305681740:VRFitness/mobile/src/main/java/com/hacktx/vrfitness/MainActivity.java


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Parse.initialize(this, "6vrJyNw2yXC9lXa86z0zqP3w7rcqcY6NmogzZjw1", "YF1txyQ3vHGUaFm1SMkaFWsvgjST9MpruqcxmemO");

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.container);

<<<<<<< HEAD:VRFitness/mobile/src/main/java/com/hacktx/vrfitness/Home.java
=======
        if(fragment == null) {
            fragment = new LoginFragment();
            manager.beginTransaction().add(R.id.container, fragment).commit();
        }
>>>>>>> eff5abaed3633686b4576a08fe4654a305681740:VRFitness/mobile/src/main/java/com/hacktx/vrfitness/MainActivity.java

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
            View rootView = inflater.inflate(R.layout.main_fragment, container, false);
            return rootView;
        }
    }
}
