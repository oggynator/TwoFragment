package com.example.twofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.twofragment.fragments.DetailFragment;

//This activity is only used on phones
public class DetailActivity extends AppCompatActivity {

    public static final String KEY = "intendKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras(); //Receive the item that was clicked
        DetailFragment detailFragment = DetailFragment.newInstance(bundle.getString(KEY)); //create a detailfragment with the item that was recieved
        presentFragment(R.id.detailActivityLayout, detailFragment); // implement the detailfragment to the detailactitylayout frame
    }

    //Used to present the fragment
    private void presentFragment(int resourceID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(resourceID, fragment)
                .commit();
    }

}
