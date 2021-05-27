package com.example.mydictionaryappusingfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WordsFragment.OnListItemClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(int pos) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        MeaningFragment meaningFragment=(MeaningFragment)fragmentManager.findFragmentById(R.id.fragment2);
        meaningFragment.setMeaning(pos);
    }
}