package com.example.informationapp2021;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



public class JoseAntonioVargas extends Fragment {

    private int ButtonClicks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View joseView = inflater.inflate(R.layout.joseantoniovargas, container, false);

        final Button nextButton = (Button) joseView.findViewById(R.id.NextButton);
        final TextView JoseInfo = (TextView) joseView.findViewById(R.id.JoseInfo);

        ButtonClicks = 0;
        //Switching Info to the next block when clicking the next button

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonClicks == 0) {
                    JoseInfo.setText(R.string.JoseInfo2);
                    nextButton.setText(R.string.TakeQuiz);
                    ButtonClicks = 1;


                }else if(ButtonClicks == 1) {
                    openQuizPage();

                }




            }
        });

        return joseView;
    }



    public void openQuizPage() {

        JoseAntonioVargas nextFrag= new JoseAntonioVargas();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                .addToBackStack(null)
                .commit();
    }

}
