package com.carbontech.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView times_table;
    ArrayList<String> times_table_content;
    ArrayAdapter<String> arrayAdapter;

    public void generateTimesTable(int times_table_postition) {

        times_table_content = new ArrayList<String>();

        for (int i = 1; i <= 10; i++){
            times_table_content.add(Integer.toString(i * times_table_postition));
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, times_table_content);

        times_table.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        times_table = (ListView) findViewById(R.id.times_table);

        final SeekBar times_table_changer = (SeekBar) findViewById(R.id.times_table_changer);

        times_table_changer.setMax(20);
        times_table_changer.setProgress(10);

        times_table_changer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int times_table_postition;

                if (progress < min){
                    times_table_postition = min;
                    times_table_changer.setProgress(min);
                }
                else {
                    times_table_postition = progress;
                }

                generateTimesTable(times_table_postition);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);
    }
}


