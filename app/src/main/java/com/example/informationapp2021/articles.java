package com.example.informationapp2021;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class articles extends AppCompatActivity {

    Button articleButton1, articleButton2, articleButton3, articleButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles);


        articleButton1 = findViewById(R.id.articleButton1);
        articleButton2 = findViewById(R.id.articleButton2);
        articleButton3 = findViewById(R.id.articleButton3);
        articleButton4 = findViewById(R.id.articleButton4);



        articleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.verywellmind.com/harmful-psychological-effects-of-racial-stereotyping-5069394"));
                startActivity(intent);
            }
        });

        articleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.usatoday.com/story/news/2017/06/15/lgbtq-glossary-slang-ally-learn-language/101200092/"));
                startActivity(intent);
            }
        });

        articleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uiaccess.com/accessucd/interact.html"));
                startActivity(intent);
            }
        });

        articleButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.theatlantic.com/entertainment/archive/2015/10/the-dos-and-donts-of-cultural-appropriation/411292/"));
                startActivity(intent);
            }
        });
    }
}