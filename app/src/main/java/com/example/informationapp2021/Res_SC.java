package com.example.informationapp2021;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Res_SC extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View Res_SC = inflater.inflate(R.layout.res_suicidecrisis, container, false);

        TextView ASFP;
        TextView NDVH;
        TextView SPL;

        ASFP = Res_SC.findViewById(R.id.ASFP);
        ASFP.setMovementMethod(LinkMovementMethod.getInstance());

        NDVH = Res_SC.findViewById(R.id.NDVH);
        NDVH.setMovementMethod(LinkMovementMethod.getInstance());

        SPL = Res_SC.findViewById(R.id.SPL);
        SPL.setMovementMethod(LinkMovementMethod.getInstance());

        return Res_SC;

    }
}