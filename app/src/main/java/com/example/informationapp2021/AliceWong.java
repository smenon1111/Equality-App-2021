package com.example.informationapp2021;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class AliceWong extends FragmentActivity {

    private int ButtonClicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alicewong);

        final Button nextButton = (Button) findViewById(R.id.NextButton);
        final TextView AliceInfo = (TextView) findViewById(R.id.AliceInfo);

        ButtonClicks = 0;
        //Switching Info to the next block when clicking the next button

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonClicks == 0) {
                    AliceInfo.setText(R.string.AliceInfo2);
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

        startActivity(new Intent(AliceWong.this, AliceWong.class));

    }

}
