package com.nastysloper.mylistapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.ImmutableMap;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String word = (String) adapterView.getItemAtPosition(i);
                String def = dictionary.get(word);
                Toast toast = Toast.makeText(DictionaryActivity.this, def, Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });

        Map nextDictionary = new HashMap<String, String>();
        ListView listView1 = (ListView) findViewById(R.id.file_word_list);
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.words));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split(" ");
            nextDictionary.put(parts[0], parts[1]);

        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new ArrayList<String>(nextDictionary.keySet()));
        listView1.setAdapter(adapter2);

        listView1.setOnItemClickListener(((adapterView, view, i, l) -> {
            String word1 = (String) adapterView.getItemAtPosition(i);
            String def1 = (String) nextDictionary.get(word1);
            Toast toast = Toast.makeText(DictionaryActivity.this, def1, Toast.LENGTH_SHORT);
            toast.show();
        }));

        try {
            PrintStream output = new PrintStream(
                    openFileOutput("out.txt", MODE_PRIVATE));
                    output.println("this is a short file");
                    output.println("that you will love reading!");
        } catch (FileNotFoundException e) {
            // log exception
        }
        try {
            Scanner scan2 = new Scanner(
                    openFileInput("out.txt"));
            StringBuilder allText = new StringBuilder();
            while (scan2.hasNextLine()) {
                allText.append(scan2.nextLine());
            }
            TextView readTextView = (TextView) findViewById(R.id.readTextView);
            readTextView.setText(allText);
            scan2.close();

        } catch (FileNotFoundException e) {
            // log exception
        }
    }
}
