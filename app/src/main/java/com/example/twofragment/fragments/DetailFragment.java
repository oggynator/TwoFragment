package com.example.twofragment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.twofragment.R;

//Used on tablets
public class DetailFragment extends Fragment {
    private String value = "";

    //Used when we create a new instance of the detailfragment, the string value is updated with the item we click on.
    public static DetailFragment newInstance(String value) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.value = value;
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detaillayout, container, false); // Creates a view with detaillayout in
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(value);//Sets textview in detaillayout to the item that was clicked
        return view;
    }
}