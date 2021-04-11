package com.example.informationapp2021;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME = "T_Register";
    Cursor results;
    String Username = "";
    String currCoins = "";
    Bundle bundle = this.getArguments();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // get the current user and the user's coins from the profile database
        openHelper = new DataBaseHelper(getActivity().getApplicationContext());
        db = openHelper.getWritableDatabase();

        results = DataBaseHelper.GetUserData(db);
        if (results.getCount() <= 0) {
            // there were no profiles stored in the database
            Toast.makeText(getActivity().getApplicationContext(), "No data found in the User db", Toast.LENGTH_LONG).show();
        }
        else if (results.moveToLast()) {
            // capture and keep track of username and the current coins with the user
            Username = results.getString(2);
            currCoins = results.getString(7);
        }

        getMyQuizInfo();

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

        Toast PointsReceived = Toast.makeText(getActivity(),"Congrats! You earned 10 coins!", Toast.LENGTH_LONG);


        if (myScoreReward == 0){
            GoodJob.setText("Try Harder Next Time");
            MyPointTotal.setText("You earned 0 coins!");
        }else if (myScoreReward == 10){
            GoodJob.setText("Try Harder Next Time");
            MyPointTotal.setText("You earned 10 coins!");
        }else if (myScoreReward == 20){
            GoodJob.setText("Good Try!");
            MyPointTotal.setText("You earned 20 coins!");
        }else if (myScoreReward == 30){
            GoodJob.setText("So Close!");
            MyPointTotal.setText("You earned 30 coins!");
        }else if (myScoreReward == 40){
            GoodJob.setText("Almost There!");
            MyPointTotal.setText("You earned 40 coins!");
        }else if (myScoreReward == 50){
            GoodJob.setText("Congratulations!");
            MyPointTotal.setText("You earned 50 coins!");
            PointsReceived.show();
        }

        if(myScoreReward > 0) {
            int coinsCount = Integer.parseInt(currCoins) + myScoreReward;

            long UpdateCoinsID = DataBaseHelper.updateCoins(db, results.getString(2), String.valueOf(coinsCount));

            if (UpdateCoinsID <= 0)
                Toast.makeText(getActivity().getApplicationContext(), "Update coins was unsuccessful", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getActivity().getApplicationContext(), "Update coins was successful", Toast.LENGTH_LONG).show();
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

    public String getMyQuizInfo() {
        String myPageName = getArguments().getString("Name");
        String[] myQuestions = getArguments().getStringArray("Questions");
        int myScore = getArguments().getInt("Score");
        int[] myAccuracy = getArguments().getIntArray("Accuracy");
        myScoreReward = myScore;
        pageNameReward = myPageName;
        myQuestionsReward = myQuestions;
        myAccuracyReward = myAccuracy;
        return myPageName;
    }

}
