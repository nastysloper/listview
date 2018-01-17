package com.nastysloper.mylistapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}
