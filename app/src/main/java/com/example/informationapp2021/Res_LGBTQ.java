package com.example.informationapp2021;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Res_LGBTQ extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Res_LGBTQ = inflater.inflate(R.layout.res_lgbtq, container, false);

        TextView TTP;
        TextView SCO;
        TextView TPP;
        TextView more;

        TTP = Res_LGBTQ.findViewById(R.id.TTP);
        TTP.setMovementMethod(LinkMovementMethod.getInstance());

        SCO = Res_LGBTQ.findViewById(R.id.SCO);
        SCO.setMovementMethod(LinkMovementMethod.getInstance());

        TPP = Res_LGBTQ.findViewById(R.id.TPP);
        TPP.setMovementMethod(LinkMovementMethod.getInstance());

        more = Res_LGBTQ.findViewById(R.id.MoreforLGBTQ);
        more.setMovementMethod(LinkMovementMethod.getInstance());

        return Res_LGBTQ;

    }
}