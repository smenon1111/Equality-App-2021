package com.example.informationapp2021;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class Reward extends Fragment {
    static int myScoreReward;
    static String pageNameReward;
    static String[] myQuestionsReward = new String[5];
    static int[] myAccuracyReward = new int[5];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getMyPageName();
        getMyScore();
        View rewardView = inflater.inflate(R.layout.reward, container, false);
        TextView Answer1 = rewardView.findViewById(R.id.Answer1);
        TextView Answer2 = rewardView.findViewById(R.id.Answer2);
        TextView Answer3 = rewardView.findViewById(R.id.Answer3);
        TextView Answer4 = rewardView.findViewById(R.id.Answer4);
        TextView Answer5 = rewardView.findViewById(R.id.Answer5);

        ImageView Correct_Incorrect1 =  rewardView.findViewById(R.id.Result2);
        ImageView Correct_Incorrect2 =  rewardView.findViewById(R.id.Result3);
        ImageView Correct_Incorrect3 =  rewardView.findViewById(R.id.Result4);
        ImageView Correct_Incorrect4 =  rewardView.findViewById(R.id.Result5);
        ImageView Correct_Incorrect5 =  rewardView.findViewById(R.id.Result6);

        TextView GoodJob = (TextView) rewardView.findViewById(R.id.titleGood);
        TextView MyPointTotal = (TextView) rewardView.findViewById(R.id.MyPointTotal);

        Button homeButton = (Button) rewardView.findViewById(R.id.homeButton);
        Button retakeQuizButton = (Button) rewardView.findViewById(R.id.QuizButton);

        Answer1.setText( myQuestionsReward[0]);
        Answer2.setText( myQuestionsReward[1]);
        Answer3.setText( myQuestionsReward[2]);
        Answer4.setText( myQuestionsReward[3]);
        Answer5.setText( myQuestionsReward[4]);


        Correct_Incorrect1.setImageResource(myAccuracyReward[0]);
        Correct_Incorrect2.setImageResource(myAccuracyReward[1]);
        Correct_Incorrect3.setImageResource(myAccuracyReward[2]);
        Correct_Incorrect4.setImageResource(myAccuracyReward[3]);
        Correct_Incorrect5.setImageResource(myAccuracyReward[4]);

        Toast PointsRecieved = Toast.makeText(getActivity(),"Congrats! You earned 10 coins!", Toast.LENGTH_LONG);


        if (myScoreReward == 0){
            GoodJob.setText("Try Harder Next Time");
            MyPointTotal.setText("Get full points to earn 10 coins!");
        }else if (myScoreReward == 10){
            GoodJob.setText("Try Harder Next Time");
            MyPointTotal.setText("Get full points to earn 10 coins!");
        }else if (myScoreReward == 20){
            GoodJob.setText("Good Try!");
            MyPointTotal.setText("Get full points to earn 10 coins!");
        }else if (myScoreReward == 30){
            GoodJob.setText("So Close!");
            MyPointTotal.setText("Get full points to earn 10 coins!");
        }else if (myScoreReward == 40){
            GoodJob.setText("Almost There!");
            MyPointTotal.setText("Get full points to earn 10 coins!");
        }else if (myScoreReward == 50){
            GoodJob.setText("Congratulations!");
            MyPointTotal.setText("+10 coins!");
            PointsRecieved.show();
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        retakeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reopenQuiz();
            }
        });

        return rewardView;
    }


    public void openMap(){
        MapOfCharacters nextFrag = new MapOfCharacters();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                .addToBackStack(null)
                .commit();
    }

    public void reopenQuiz() {
        Quiz nextFrag = new Quiz();
        Bundle bundle = new Bundle();
        bundle.putString("Name", pageNameReward);
        nextFrag.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), nextFrag)
                .addToBackStack(null)
                .commit();
    }

    public String getMyPageName() {
        Bundle bundle = this.getArguments();
        String myPageName = bundle.getString("Name", pageNameReward );
        pageNameReward = myPageName;
        return myPageName;
    }
/*
    public String[] getMyQuestions() {
        Bundle bundleMyQuestion = this.getArguments();
        String[] myQuestions = bundleMyQuestion.getStringArray( "Questions", myQuestionsReward);
        myQuestionsReward = myQuestions;
        return myQuestions;
    }*/
    public int getMyScore() {
        Bundle bundle = this.getArguments();
        int myScore = bundle.getInt("Score",myScoreReward);
        myScoreReward = myScore;
        return myScore;
    }

   /* public int[] getMyAccuracy() {
        Bundle bundle = this.getArguments();
        int[] myAccuracy = bundle.getIntArray("Accuracy",myAccuracyReward);
        myAccuracyReward = myAccuracy;
        return myAccuracy;
    }
*/
   /* public static Intent makeIntent(Context context, String[] myQuestion, int myScoreReward, String myPageName, int[] myAccuracy ) {
        mainActivityContext = context;
        myQuestionsReward = myQuestion;
        myScore = myScoreReward;
        myPageNameReward = myPageName;
        myAccuracyReward = myAccuracy;
        return new Intent(context, Reward.class);
    }*/
}
