package com.example.informationapp2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;

public class RequestForm extends Fragment {

    EditText c1name, c1no, c2name, c3name;
    Button c4Button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RequestView = inflater.inflate(R.layout.requestform, container, false);


        c1name = (EditText) RequestView.findViewById(R.id.req_NameText);
        c1no = (EditText) RequestView.findViewById(R.id.req_PhoneText);
        c2name = (EditText) RequestView.findViewById(R.id.req_AddressText);
        c3name = (EditText) RequestView.findViewById(R.id.req_contentText);
        c4Button = (Button) RequestView.findViewById(R.id.req_sendbutton);


        c4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL,new String[]{"technovation987@gmail.com"});
                it.putExtra(Intent.EXTRA_SUBJECT,c1name.getText() + " " + "-" + " " + "My Article Idea");
                it.putExtra(Intent.EXTRA_TEXT,
                        "My name: " + c1name.getText() + "  " +
                                "My phone number: " + c1no.getText() +  "  " +
                                "My address: " + c2name.getText() + "  " +
                                "My article idea" + c3name.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });

        return RequestView;
    }}