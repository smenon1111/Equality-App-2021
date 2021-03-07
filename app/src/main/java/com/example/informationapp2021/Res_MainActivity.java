package com.example.informationapp2021;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

    public class Res_MainActivity extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View Res_MainActivity = inflater.inflate(R.layout.resources_activity, container, false);

            Button SC = Res_MainActivity.findViewById(R.id.SuicideCrisis);
            Button LGBTQ = Res_MainActivity.findViewById(R.id.LGBTQ);
            Button Alliances = Res_MainActivity.findViewById(R.id.Alliances);



            Alliances.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Res_Alliances nextFrag= new Res_Alliances();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                            .addToBackStack(null)
                            .commit();
                }
            });

            LGBTQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Res_LGBTQ nextFrag= new Res_LGBTQ();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                            .addToBackStack(null)
                            .commit();
                }
            });

            SC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Res_SC nextFrag= new Res_SC();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                            .addToBackStack(null)
                            .commit();
                }


            } );

            return Res_MainActivity;
        }
    }
