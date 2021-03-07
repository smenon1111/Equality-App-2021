package com.example.informationapp2021;


import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Res_Alliances extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View Res_Alliances = inflater.inflate(R.layout.res_alliances, container, false);

        final int[] ButtonClicks = {0};
        final TextView FirstT_1 = (TextView) Res_Alliances.findViewById(R.id.CHADD);
        final TextView SecondT_1 = (TextView) Res_Alliances.findViewById(R.id.CHADDd);
        final TextView FourthT_1 = (TextView) Res_Alliances.findViewById(R.id.CHADDc);
        final TextView FirstT_2 = (TextView) Res_Alliances.findViewById(R.id.DBSA);
        final TextView SecondT_2 = (TextView) Res_Alliances.findViewById(R.id.DBSAd);
        final TextView FourthT_2 = (TextView) Res_Alliances.findViewById(R.id.DBSAc);
        final TextView FirstT_3 = (TextView) Res_Alliances.findViewById(R.id.IOF);
        final TextView SecondT_3 = (TextView) Res_Alliances.findViewById(R.id.IOFd);
        final TextView FourthT_3 = (TextView) Res_Alliances.findViewById(R.id.IOFc);
        final TextView FirstT_4 = (TextView) Res_Alliances.findViewById(R.id.NCEED);
        final TextView SecondT_4 = (TextView) Res_Alliances.findViewById(R.id.NCEEDd);
        final TextView ThirdT_4 = (TextView) Res_Alliances.findViewById(R.id.NCEEDcall);
        final TextView FourthT_4 = (TextView) Res_Alliances.findViewById(R.id.NCEEDc);
        final Button nextButton = (Button) Res_Alliances.findViewById(R.id.resnextbutton);

        FirstT_1.setMovementMethod(LinkMovementMethod.getInstance());
        FirstT_2.setMovementMethod(LinkMovementMethod.getInstance());
        FirstT_3.setMovementMethod(LinkMovementMethod.getInstance());
        FirstT_4.setMovementMethod(LinkMovementMethod.getInstance());

        //Switching Info to the next block when clicking the next button

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonClicks[0] == 0) {
                    ButtonClicks[0] = 1;
                    FirstT_1.setText(R.string.SARDAA);
                    SecondT_1.setText(R.string.SARDAAd);
                    FourthT_1.setText(R.string.SARDAAc);
                    FirstT_2.setText(R.string.SI);
                    SecondT_2.setText(R.string.SId);
                    FourthT_2.setText(R.string.SIc);
                    FirstT_3.setText(R.string.TARA);
                    SecondT_3.setText(R.string.TARAd);
                    FourthT_3.setText(R.string.TARAc);
                    FirstT_4.setVisibility(View.GONE);
                    SecondT_4.setVisibility(View.GONE);
                    ThirdT_4.setVisibility(View.GONE);
                    FourthT_4.setVisibility(View.GONE);
                    nextButton.setText(R.string.back);
                    ButtonClicks[0] = 2;
                }else if(ButtonClicks[0] == 2) {
                    FirstT_1.setText(R.string.CHADD);
                    SecondT_1.setText(R.string.CHADDd);
                    FourthT_1.setText(R.string.CHADDc);
                    FirstT_2.setText(R.string.DBSA);
                    SecondT_2.setText(R.string.DBSAd);
                    FourthT_2.setText(R.string.DBSAc);
                    FirstT_3.setText(R.string.IOF);
                    SecondT_3.setText(R.string.IOFd);
                    FourthT_3.setText(R.string.IOFc);
                    FirstT_4.setVisibility(View.VISIBLE);
                    SecondT_4.setVisibility(View.VISIBLE);
                    ThirdT_4.setVisibility(View.VISIBLE);
                    FourthT_4.setVisibility(View.VISIBLE);
                    FirstT_4.setText(R.string.NCEED);
                    SecondT_4.setText(R.string.NCEEDd);
                    ThirdT_4.setText(R.string.call);
                    FourthT_4.setText(R.string.NCEEDc);
                    nextButton.setText(R.string.next);
                    ButtonClicks[0] = 0;
                }

            }

        });
        return Res_Alliances;
    } }

