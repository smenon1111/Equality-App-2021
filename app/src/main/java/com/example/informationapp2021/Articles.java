package com.example.informationapp2021;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class Articles extends Fragment {

    Button articleButton1, articleButton2, articleButton3, articleButton4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View articlesView = inflater.inflate(R.layout.articles, container, false);


        articleButton1 = articlesView.findViewById(R.id.articleButton1);
        articleButton2 = articlesView.findViewById(R.id.articleButton2);
        articleButton3 = articlesView.findViewById(R.id.articleButton3);
        articleButton4 = articlesView.findViewById(R.id.articleButton4);
        Button openRequestFormButton = articlesView.findViewById(R.id.openRequestFormButton);


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

        openRequestFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Change this to link to REQUEST FORM PAGE
                RequestForm nextFrag= new RequestForm();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return articlesView;

    }
}