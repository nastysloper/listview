package com.nastysloper.mylistapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.common.collect.ImmutableMap;

public class DictionaryActivity extends AppCompatActivity {

    ImmutableMap<String, String> dictionary = ImmutableMap.of("welcome", "bonjour");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
    }
}
