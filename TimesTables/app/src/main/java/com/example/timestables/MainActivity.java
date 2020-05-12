package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        final TextView timesTableTextView = (TextView) findViewById(R.id.timesTabletextView);
        final ListView timesTableListView = (ListView) findViewById(R.id.timesTableListView);

        timesTableSeekBar.setMax(50);
        timesTableSeekBar.setProgress(25);

        timesTableTextView.setText("Slide the bar to learn the Times Table!");

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min); // dont let the seekbar fall below the minimum
                    timesTableTextView.setText("Number: " + Integer.toString(min));
                } else {
                    timesTableNumber = progress;
                    timesTableTextView.setText("Number: " + Integer.toString(progress));
                }
//                Log.i("Times Table Number", Integer.toString(timesTableNumber));
                ArrayList<String> timesTableContent = new ArrayList<>();

                for (int multiplier = 1; multiplier <= 15; multiplier++) {
                    String preamble = timesTableNumber + " X " + multiplier;
                    String resultingNumber = Integer.toString(multiplier * timesTableNumber);
                    timesTableContent.add(preamble + " =                       " + resultingNumber);
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        timesTableContent);

                timesTableListView.setAdapter(arrayAdapter);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
