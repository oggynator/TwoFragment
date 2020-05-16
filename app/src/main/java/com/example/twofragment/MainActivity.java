package com.example.twofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.twofragment.fragments.DetailFragment;
import com.example.twofragment.fragments.ListFragment;

public class MainActivity extends AppCompatActivity {


    private ListFragment listFragment;
    private DetailFragment detailFragment;
    private boolean isTablet = false; //This boolean will be used to determine whether the user is a tablet or phone device

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Depending on screen size of the device, that version of the activity_main.xml will be loaded

        FrameLayout frameLayout = findViewById(R.id.phoneLayout); //Will only be loaded if the device is a phone
        listFragment = ListFragment.newInstance(this); // Both layouts use this fragment, so we load it now

        if (frameLayout != null) { //If there is a phonelayout, this is loaded
            isTablet = false;
            presentFragment(R.id.phoneLayout, listFragment); //We present the list fragment
        }

        else { // the else condition is run if the device doesnt load the phonelayout
            isTablet = true;
            detailFragment = DetailFragment.newInstance("This is the detail fragment, when you click something this text will change"); //Create detail fragment with default text
            presentFragment(R.id.tabletListLayout, listFragment); // implement listfragment to tabletlistlayout
            presentFragment(R.id.tabletDetailLayout, detailFragment); // the same as above, but with the detailfragment and tabletdetaillayout
        }
    }

    //handles user clicks on the items in the listfragment
    public void handleItemClick(String item) { //Item comes from the listfragment class
        if (isTablet) {
            detailFragment = DetailFragment.newInstance(item); //If the device is a tablet, we change the detailfragment everytime an item is clicked
            presentFragment(R.id.tabletDetailLayout, detailFragment); //The changed detailfragment is implemented into the framelayout
        }

        else {
            Intent intent = new Intent(this, DetailActivity.class); //If the device is a phone we just create an intent and send the user to the detailactivity
            intent.putExtra(DetailActivity.KEY, item); // we provide the detailactivity with the item that was clicked
            startActivity(intent);
        }
    }

    //The method that is used to present fragments (meaning send the fragment to the framelayout)
    private void presentFragment(int resourceID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(resourceID, fragment)
                .commit();
    }

}
