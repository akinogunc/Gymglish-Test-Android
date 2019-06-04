package com.example.gymglish_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setTitle("Websites");

        List<String> websiteNames = Arrays.asList("Gymglish",
                "Frantastique",
                "Vatefaireconjuguer",
                "Rich Morning",
                "The Word of the Month",
                "Anglais cpf",
                "Comment Utiliser Son cpf",
                "Gymglish Studio",
                "Anglais Conjugaison",
                "The Delavigne Corporation");

        final List<String> websiteLinks = Arrays.asList("https://www.gymglish.com/",
                "https://www.frantastique.com",
                "https://www.vatefaireconjuguer.com/",
                "https://www.richmorning.com/",
                "https://www.thewordofthemonth.com/",
                "https://www.anglais-cpf.fr/",
                "https://www.comment-utiliser-son-cpf.fr/",
                "https://www.gymglish.com/fr/studio",
                "http://www.anglais-conjugaison.com/",
                "https://www.delavignecorp.com/");

        final ListView lv = (ListView) findViewById(R.id.webiste_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                websiteNames );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent myIntent = new Intent(ListActivity.this, WebViewActivity.class);
                myIntent.putExtra("url",websiteLinks.get(i));
                ListActivity.this.startActivity(myIntent);
            }
        });
    }

}
