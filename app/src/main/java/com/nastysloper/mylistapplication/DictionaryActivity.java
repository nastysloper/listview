package com.nastysloper.mylistapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;

public class DictionaryActivity extends AppCompatActivity {

    ImmutableMap<String, String> dictionary = ImmutableMap.<String, String>builder()
            .put("welcome", "bonjour")
            .put("dog", "chien")
            .put("cat", "chat")
            .put("pig", "cochon")
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        ListView listView = (ListView) findViewById(R.id.word_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new ArrayList<String>(dictionary.keySet()));
        listView.setAdapter(adapter);

         listView.setOnItemClickListener((adapterView, view, position, id) -> {
                     String word = (String) adapterView.getItemAtPosition(position);
                     String def = dictionary.get(word);
                     Toast toast = Toast.makeText(DictionaryActivity.this, def, Toast.LENGTH_SHORT);
                     toast.show();
         });

        Spinner spinner = (Spinner) findViewById(R.id.spinner_list);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new ArrayList<String>(dictionary.keySet()));
        spinner.setAdapter(adapter1);
    }
}
