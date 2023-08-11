package com.example.myfragmentsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ListItemClick {
    TextView tvItemDetails;
    //ArrayList<String> contentsList;
    String[] contentsList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* contentsList = new ArrayList<>();
        contentsList.add("content about First item");
        contentsList.add("content about Second item");
        contentsList.add("content about Third item");
        contentsList.add("content about Fourth item");
        */

        contentsList = getResources().getStringArray(R.array.items_details);
        tvItemDetails = findViewById(R.id.tvItemDetails);

        FragmentManager manager = getSupportFragmentManager();
        if (findViewById(R.id.layout_portrait) != null) {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFragment))
                    .hide(manager.findFragmentById(R.id.contentFragment))
                    .commit();
        }

        if (findViewById(R.id.layout_landscape) != null) {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFragment))
                    .show(manager.findFragmentById(R.id.contentFragment))
                    .commit();

            onListItemClick(0);
        }
    }

    @Override
    public void onListItemClick(int position) {
        if (contentsList != null) {
            //tvItemDetails.setText(contentsList.get(position));
            tvItemDetails.setText(contentsList[position]);
        }

        if (findViewById(R.id.layout_portrait) != null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFragment))
                    .show(manager.findFragmentById(R.id.contentFragment))
                    .addToBackStack(null)
                    .commit();
        }
    }
}