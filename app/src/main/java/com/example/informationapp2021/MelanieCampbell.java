package com.example.informationapp2021;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



public class MelanieCampbell extends Fragment {

    private int ButtonClicks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View melanieView = inflater.inflate(R.layout.melaniecampbell, container, false);

        final Button nextButton = (Button) melanieView.findViewById(R.id.NextButton);
        final TextView melanieInfo = (TextView) melanieView.findViewById(R.id.MelanieInfo);

        ButtonClicks = 0;
        //Switching Info to the next block when clicking the next button

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonClicks == 0) {
                    melanieInfo.setText(R.string.MelanieInfo2);
                    nextButton.setText(R.string.TakeQuiz);
                    ButtonClicks = 1;


                }
                else if(ButtonClicks == 1) {
                    openQuizPage();

                }




            }
        });

        return melanieView;
    }



    public void openQuizPage() {
        Quiz nextFrag = new Quiz();
        Bundle bundle = new Bundle();
        bundle.putString("Name", "MelanieCampbell");
        nextFrag.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup) getView().getParent()).getId(), nextFrag)
                .addToBackStack(null)
                .commit();
    }

}
