package com.example.informationapp2021;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.fragment.app.FragmentActivity;

public class SimranJeetSingh extends FragmentActivity {

    private int ButtonClicks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simranjeetsingh);

         final Button nextButton = (Button) findViewById(R.id.NextButton);
         final TextView SimranInfo = (TextView) findViewById(R.id.SimranInfo);

         ButtonClicks = 0;
        //Switching Info to the next block when clicking the next button

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonClicks == 0) {
                SimranInfo.setText(R.string.SimranInfo2);
                nextButton.setText(R.string.TakeQuiz);
                ButtonClicks = 1;


                }else if(ButtonClicks == 1) {
                    OpenQuizPage();

                }




            }
        });

    }

    //TODO: Create Quiz Page and replace the, AliceWong.Class with Quiz Page Class

    public void OpenQuizPage() {

        startActivity(new Intent(SimranJeetSingh.this, AliceWong.class));

    }
}
