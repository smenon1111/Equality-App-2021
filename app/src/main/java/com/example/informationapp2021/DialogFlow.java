package com.example.informationapp2021;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class DialogFlow extends Fragment {
    private Button DFBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View dialogFlowView = inflater.inflate(R.layout.dialogflow, container, false);


        DFBtn= dialogFlowView.findViewById(R.id.button);

        DFBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bot.dialogflow.com/cf5690aa-1e88-4fc8-a285-3747b968397f"));
                startActivity(intent);
            }
        });
    return dialogFlowView;
    }}
