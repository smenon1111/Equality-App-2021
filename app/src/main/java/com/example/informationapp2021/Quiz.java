package com.example.informationapp2021;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Quiz extends Fragment {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME = "T_Register";
    Cursor results;
    String Username = "";
    String currCoins = "";
    private TextView mQuestion;
    private Button mFirstButton;
    private Button mSecondButton;
    private Button mThirdButton;
    private Button mFourthButton;
    private TextView title;
    private int mQuizIndex = 1;
    public int myScore = 0;
    static String pageName;
    static String mMyPageNameQuiz;

    String[] questions = new String[5];
    int[] correct_incorrect = new int[5];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View quizView = inflater.inflate(R.layout.quiz, container, false);

        title = (TextView) quizView.findViewById(R.id.title);
        mQuestion = (TextView) quizView.findViewById(R.id.question);
        mFirstButton = (Button) quizView.findViewById(R.id.firstbutton);
        mSecondButton = (Button) quizView.findViewById(R.id.secondbutton);
        mThirdButton = (Button) quizView.findViewById(R.id.thirdbutton);
        mFourthButton = (Button) quizView.findViewById(R.id.fourthbutton);

        getMyPageName();

        // get the current user and the user's coins from the profile database
        openHelper = new DataBaseHelper(getActivity().getApplicationContext());
        db = openHelper.getReadableDatabase();

        results = DataBaseHelper.GetUserData(db);
        if (results.getCount() <= 0) {
            // there were no profiles stored in the database
            Toast.makeText(getActivity().getApplicationContext(), "No data found in the User db", Toast.LENGTH_LONG).show();
        }
        else if (results.moveToLast()) {
            // capture and keep track of username and the current coins with the user
            Username = results.getString(2);
            currCoins = results.getString(8);
        }

        if (pageName == "SimranJeetSingh") {

            mQuestion.setText(R.string.Q1Simran);
            mFirstButton.setText(R.string.Q1_A1Simran);
            mSecondButton.setText(R.string.Q1_A2Simran);
            mThirdButton.setText(R.string.Q1_A3Simran);
            mFourthButton.setText(R.string.Q1_A4Simran);
            title.setText(R.string.SimranTitle);

            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mFirstButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Simran);
                        mFirstButton.setText(R.string.Q5_A1Simran);
                        mSecondButton.setText(R.string.Q5_A2Simran);
                        mThirdButton.setText(R.string.Q5_A3Simran);
                        mFourthButton.setText(R.string.Q5_A4Simran);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();


                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Simran);
                        mFirstButton.setText(R.string.Q3_A1Simran);
                        mSecondButton.setText(R.string.Q3_A2Simran);
                        mThirdButton.setText(R.string.Q3_A3Simran);
                        mFourthButton.setText(R.string.Q3_A4Simran);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 3;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Simran);
                        mFirstButton.setText(R.string.Q4_A1Simran);
                        mSecondButton.setText(R.string.Q4_A2Simran);
                        mThirdButton.setText(R.string.Q4_A3Simran);
                        mFourthButton.setText(R.string.Q4_A4Simran);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mThirdButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Simran);
                        mFirstButton.setText(R.string.Q2_A1Simran);
                        mSecondButton.setText(R.string.Q2_A2Simran);
                        mThirdButton.setText(R.string.Q2_A3Simran);
                        mFourthButton.setText(R.string.Q2_A4Simran);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }
        else if (pageName == "AliceWong") {

            mQuestion.setText(R.string.Q1Alice);
            mFirstButton.setText(R.string.Q1_A1Alice);
            mSecondButton.setText(R.string.Q1_A2Alice);
            mThirdButton.setText(R.string.Q1_A3Alice);
            mFourthButton.setText(R.string.Q1_A4Alice);
            title.setText(R.string.AliceTitle);

            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[1] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[1] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Alice);
                        mFirstButton.setText(R.string.Q3_A1Alice);
                        mSecondButton.setText(R.string.Q3_A2Alice);
                        mThirdButton.setText(R.string.Q3_A3Alice);
                        mFourthButton.setText(R.string.Q3_A4Alice);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 3;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFirstButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        myScore = myScore + 10;
                        openRewardPage();

                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Alice);
                        mFirstButton.setText(R.string.Q2_A1Alice);
                        mSecondButton.setText(R.string.Q2_A2Alice);
                        mThirdButton.setText(R.string.Q2_A3Alice);
                        mFourthButton.setText(R.string.Q2_A4Alice);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;

                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();

                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Alice);
                        mFirstButton.setText(R.string.Q5_A1Alice);
                        mSecondButton.setText(R.string.Q5_A2Alice);
                        mThirdButton.setText(R.string.Q5_A3Alice);
                        mFourthButton.setText(R.string.Q5_A4Alice);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Alice);
                        mFirstButton.setText(R.string.Q4_A1Alice);
                        mSecondButton.setText(R.string.Q4_A2Alice);
                        mThirdButton.setText(R.string.Q4_A3Alice);
                        mFourthButton.setText(R.string.Q4_A4Alice);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }
        else if (pageName == "ThandiweAbdullah") {

            mQuestion.setText(R.string.Q1Thandiwe);
            mFirstButton.setText(R.string.Q1_A1Thandiwe);
            mSecondButton.setText(R.string.Q1_A2Thandiwe);
            mThirdButton.setText(R.string.Q1_A3Thandiwe);
            mFourthButton.setText(R.string.Q1_A4Thandiwe);
            title.setText(R.string.ThandiweTitle);
            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[1] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[1] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Thandiwe);
                        mFirstButton.setText(R.string.Q3_A1Thandiwe);
                        mSecondButton.setText(R.string.Q3_A2Thandiwe);
                        mThirdButton.setText(R.string.Q3_A3Thandiwe);
                        mFourthButton.setText(R.string.Q3_A4Thandiwe);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 3;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Thandiwe);
                        mFirstButton.setText(R.string.Q4_A1Thandiwe);
                        mSecondButton.setText(R.string.Q4_A2Thandiwe);
                        mThirdButton.setText(R.string.Q4_A3Thandiwe);
                        mFourthButton.setText(R.string.Q4_A4Thandiwe);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFirstButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();


                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mThirdButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        myScore = myScore + 10;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Thandiwe);
                        mFirstButton.setText(R.string.Q2_A1Thandiwe);
                        mSecondButton.setText(R.string.Q2_A2Thandiwe);
                        mThirdButton.setText(R.string.Q2_A3Thandiwe);
                        mFourthButton.setText(R.string.Q2_A4Thandiwe);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Thandiwe);
                        mFirstButton.setText(R.string.Q5_A1Thandiwe);
                        mSecondButton.setText(R.string.Q5_A2Thandiwe);
                        mThirdButton.setText(R.string.Q5_A3Thandiwe);
                        mFourthButton.setText(R.string.Q5_A4Thandiwe);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }
        else if (pageName.equals("BeverlyPalesaDitsie")) {

            mQuestion.setText(R.string.Q1Beverly);
            mFirstButton.setText(R.string.Q1_A1Beverly);
            mSecondButton.setText(R.string.Q1_A2Beverly);
            mThirdButton.setText(R.string.Q1_A3Beverly);
            mFourthButton.setText(R.string.Q1_A4Beverly);
            title.setText(R.string.BeverlyTitle);

            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mFirstButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Beverly);
                        mFirstButton.setText(R.string.Q5_A1Beverly);
                        mSecondButton.setText(R.string.Q5_A2Beverly);
                        mThirdButton.setText(R.string.Q5_A3Beverly);
                        mFourthButton.setText(R.string.Q5_A4Beverly);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Beverly);
                        mFirstButton.setText(R.string.Q3_A1Beverly);
                        mSecondButton.setText(R.string.Q3_A2Beverly);
                        mThirdButton.setText(R.string.Q3_A3Beverly);
                        mFourthButton.setText(R.string.Q3_A4Beverly);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 3;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Beverly);
                        mFirstButton.setText(R.string.Q4_A1Beverly);
                        mSecondButton.setText(R.string.Q4_A2Beverly);
                        mThirdButton.setText(R.string.Q4_A3Beverly);
                        mFourthButton.setText(R.string.Q4_A4Beverly);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Beverly);
                        mFirstButton.setText(R.string.Q2_A1Beverly);
                        mSecondButton.setText(R.string.Q2_A2Beverly);
                        mThirdButton.setText(R.string.Q2_A3Beverly);
                        mFourthButton.setText(R.string.Q2_A4Beverly);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mThirdButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();

                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();
                    }

                }
            });
        }
        else if (pageName.equals("MalalaYousafzai")) {

            mQuestion.setText(R.string.Q1Malala);
            mFirstButton.setText(R.string.Q1_A1Malala);
            mSecondButton.setText(R.string.Q1_A2Malala);
            mThirdButton.setText(R.string.Q1_A3Malala);
            mFourthButton.setText(R.string.Q1_A4Malala);
            title.setText(R.string.MalalaTitle);

            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Malala);
                        mFirstButton.setText(R.string.Q2_A1Malala);
                        mSecondButton.setText(R.string.Q2_A2Malala);
                        mThirdButton.setText(R.string.Q2_A3Malala);
                        mFourthButton.setText(R.string.Q2_A4Malala);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mFirstButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Malala);
                        mFirstButton.setText(R.string.Q5_A1Malala);
                        mSecondButton.setText(R.string.Q5_A2Malala);
                        mThirdButton.setText(R.string.Q5_A3Malala);
                        mFourthButton.setText(R.string.Q5_A4Malala);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();

                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Malala);
                        mFirstButton.setText(R.string.Q4_A1Malala);
                        mSecondButton.setText(R.string.Q4_A2Malala);
                        mThirdButton.setText(R.string.Q4_A3Malala);
                        mFourthButton.setText(R.string.Q4_A4Malala);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mThirdButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();

                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[0] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Malala);
                        mFirstButton.setText(R.string.Q3_A1Malala);
                        mSecondButton.setText(R.string.Q3_A2Malala);
                        mThirdButton.setText(R.string.Q3_A3Malala);
                        mFourthButton.setText(R.string.Q3_A4Malala);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }
        else if (pageName.equals("MelanieCampbell")) {

            mQuestion.setText(R.string.Q1Melanie);
            mFirstButton.setText(R.string.Q1_A1Melanie);
            mSecondButton.setText(R.string.Q1_A2Melanie);
            mThirdButton.setText(R.string.Q1_A3Melanie);
            mFourthButton.setText(R.string.Q1_A4Melanie);
            title.setText(R.string.MelanieTitle);

            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Melanie);
                        mFirstButton.setText(R.string.Q2_A1Melanie);
                        mSecondButton.setText(R.string.Q2_A2Melanie);
                        mThirdButton.setText(R.string.Q2_A3Melanie);
                        mFourthButton.setText(R.string.Q2_A4Melanie);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Melanie);
                        mFirstButton.setText(R.string.Q2_A1Melanie);
                        mSecondButton.setText(R.string.Q2_A2Melanie);
                        mThirdButton.setText(R.string.Q2_A3Melanie);
                        mFourthButton.setText(R.string.Q2_A4Melanie);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFirstButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();

                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Melanie);
                        mFirstButton.setText(R.string.Q3_A1Melanie);
                        mSecondButton.setText(R.string.Q3_A2Melanie);
                        mThirdButton.setText(R.string.Q3_A3Melanie);
                        mFourthButton.setText(R.string.Q3_A4Melanie);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 3;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Melanie);
                        mFirstButton.setText(R.string.Q5_A1Melanie);
                        mSecondButton.setText(R.string.Q5_A2Melanie);
                        mThirdButton.setText(R.string.Q5_A3Melanie);
                        mFourthButton.setText(R.string.Q5_A4Melanie);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mThirdButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();

                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Melanie);
                        mFirstButton.setText(R.string.Q4_A1Melanie);
                        mSecondButton.setText(R.string.Q4_A2Melanie);
                        mThirdButton.setText(R.string.Q4_A3Melanie);
                        mFourthButton.setText(R.string.Q4_A4Melanie);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }
        else if (pageName.equals("ChadGriffin")) {

            mQuestion.setText(R.string.Q1Chad);
            mFirstButton.setText(R.string.Q1_A1Chad);
            mSecondButton.setText(R.string.Q1_A2Chad);
            mThirdButton.setText(R.string.Q1_A3Chad);
            mFourthButton.setText(R.string.Q1_A4Chad);
            title.setText(R.string.ChadTitle);

            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Chad);
                        mFirstButton.setText(R.string.Q4_A1Chad);
                        mSecondButton.setText(R.string.Q4_A2Chad);
                        mThirdButton.setText(R.string.Q4_A3Chad);
                        mFourthButton.setText(R.string.Q4_A4Chad);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFirstButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();

                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Chad);
                        mFirstButton.setText(R.string.Q2_A1Chad);
                        mSecondButton.setText(R.string.Q2_A2Chad);
                        mThirdButton.setText(R.string.Q2_A3Chad);
                        mFourthButton.setText(R.string.Q2_A4Chad);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[0] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Chad);
                        mFirstButton.setText(R.string.Q3_A1Chad);
                        mSecondButton.setText(R.string.Q3_A2Chad);
                        mThirdButton.setText(R.string.Q3_A3Chad);
                        mFourthButton.setText(R.string.Q3_A4Chad);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mSecondButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Chad);
                        mFirstButton.setText(R.string.Q5_A1Chad);
                        mSecondButton.setText(R.string.Q5_A2Chad);
                        mThirdButton.setText(R.string.Q5_A3Chad);
                        mFourthButton.setText(R.string.Q5_A4Chad);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mThirdButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();

                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }
        else if (pageName.equals("JoseAntonioVargas")) {

            mQuestion.setText(R.string.Q1Jose);
            mFirstButton.setText(R.string.Q1_A1Jose);
            mSecondButton.setText(R.string.Q1_A2Jose);
            mThirdButton.setText(R.string.Q1_A3Jose);
            mFourthButton.setText(R.string.Q1_A4Jose);
            title.setText(R.string.JoseTitle);

            //FIRST BUTTON
            mFirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Correct Answer
                        questions[0] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q3Jose);
                        mFirstButton.setText(R.string.Q3_A1Jose);
                        mSecondButton.setText(R.string.Q3_A2Jose);
                        mThirdButton.setText(R.string.Q3_A3Jose);
                        mFourthButton.setText(R.string.Q3_A4Jose);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFirstButton.getText().toString();
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Correct Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFirstButton.getText().toString();
                        correct_incorrect[4] = R.drawable.check_mark;
                        myScore = myScore + 10;
                        openRewardPage();
                    }

                }
            });

            //SECOND BUTTON
            mSecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mSecondButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Correct Answer
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q4Jose);
                        mFirstButton.setText(R.string.Q4_A1Jose);
                        mSecondButton.setText(R.string.Q4_A2Jose);
                        mThirdButton.setText(R.string.Q4_A3Jose);
                        mFourthButton.setText(R.string.Q4_A4Jose);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 4;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 4) {
                        //Correct Answer
                        questions[3] = "4." + mSecondButton.getText().toString();
                        correct_incorrect[3] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q5Jose);
                        mFirstButton.setText(R.string.Q5_A1Jose);
                        mSecondButton.setText(R.string.Q5_A2Jose);
                        mThirdButton.setText(R.string.Q5_A3Jose);
                        mFourthButton.setText(R.string.Q5_A4Jose);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 5;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mSecondButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();

                    }
                }
            });

            //THIRD BUTTON
            mThirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Correct Answer
                        questions[0] = "1." + mThirdButton.getText().toString();
                        correct_incorrect[0] = R.drawable.check_mark;
                        mQuestion.setText(R.string.Q2Jose);
                        mFirstButton.setText(R.string.Q2_A1Jose);
                        mSecondButton.setText(R.string.Q2_A2Jose);
                        mThirdButton.setText(R.string.Q2_A3Jose);
                        mFourthButton.setText(R.string.Q2_A4Jose);
                        Toast CorrectAnswer = Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_LONG);
                        CorrectAnswer.show();
                        mQuizIndex = 2;
                        myScore = myScore + 10;
                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mThirdButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                        openRewardPage();
                    }


                }
            });

            //FOURTH BUTTON
            mFourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mQuizIndex == 1) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[0] = "1." + mFourthButton.getText().toString();
                        correct_incorrect[0] = R.drawable.red_mark;
                        openRewardPage();

                    }
                    else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    }
                    else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }


        return quizView;
    }


    public void openRewardPage() {
        Reward nextFrag = new Reward();
        Bundle bundleQuizInfo = new Bundle();

        bundleQuizInfo.putString("Name", pageName);
        bundleQuizInfo.putStringArray("Questions", questions);
        bundleQuizInfo.putInt("Score", myScore);
        bundleQuizInfo.putIntArray("Accuracy", correct_incorrect);

        int coinsCount = Integer.parseInt(currCoins) + myScore;

        long AddCoinsID = DataBaseHelper.updateCoins(db, results.getString(2), String.valueOf(coinsCount));

        if (AddCoinsID <= 0)
            Toast.makeText(getActivity().getApplicationContext(), "Add coins was unsuccessful", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getActivity().getApplicationContext(), "Add coins was successful", Toast.LENGTH_LONG).show();

        nextFrag.setArguments(bundleQuizInfo);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup) getView().getParent()).getId(), nextFrag)
                .addToBackStack(null)
                .commit();
    }


    public String getMyPageName() {
        Bundle bundle = this.getArguments();
        String myPageName = bundle.getString("Name", pageName);
        pageName = myPageName;
        return myPageName;
    }

}