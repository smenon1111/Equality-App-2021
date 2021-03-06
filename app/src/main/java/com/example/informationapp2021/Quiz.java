package com.example.informationapp2021;


import android.content.Context;
import android.content.Intent;
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

        if(pageName == "SimranJeetSingh"){

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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFirstButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
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
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
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
                    } else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
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
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
                        //Wrong Answer
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;
                    }

                }
            });
        }else if(pageName == "AliceWong"){

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
                    } else if (mQuizIndex == 2) {
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
                    } else if (mQuizIndex == 3) {
                        mQuizIndex = 6;
                        questions[2] = "3." + mFirstButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFirstButton.getText().toString();
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
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

                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
                        //Wrong Answer
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();

                    } else if (mQuizIndex == 4) {
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
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
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
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFourthButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[4] = "5." + mFourthButton.getText().toString();
                        correct_incorrect[4] = R.drawable.red_mark;


                    }

                }
            });

        } else if(pageName == "ThandiweAbdullah") {

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
                    } else if (mQuizIndex == 2) {
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
                    } else if (mQuizIndex == 3) {
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
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mFirstButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mSecondButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mSecondButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mSecondButton.getText().toString();
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mThirdButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[2] = "3." + mThirdButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[3] = "4." + mThirdButton.getText().toString();
                        correct_incorrect[3] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 5) {
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
                    } else if (mQuizIndex == 2) {
                        //Wrong Answer
                        mQuizIndex = 6;
                        questions[1] = "2." + mFourthButton.getText().toString();
                        correct_incorrect[1] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 3) {
                        //Wrong Answer
                        questions[2] = "3." + mFourthButton.getText().toString();
                        correct_incorrect[2] = R.drawable.red_mark;
                        openRewardPage();
                    } else if (mQuizIndex == 4) {
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
                    } else if (mQuizIndex == 5) {
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


   /* public void openRewardPage(String[] myQuestion, int myScore, int[] myAccuracy) {

        Intent intent = Reward.makeIntent(getActivity(), myQuestion, myScore,mMyPageNameQuiz, myAccuracy );
        startActivity(intent);
    }*/

   public void openRewardPage(){
       Reward nextFrag = new Reward();
       Bundle bundleQuizInfo = new Bundle();
       
       bundleQuizInfo.putString("Name", pageName);
       bundleQuizInfo.putStringArray("Questions", questions);
       bundleQuizInfo.putInt("Score",myScore);
       bundleQuizInfo.putIntArray("Accuracy",correct_incorrect);

       nextFrag.setArguments(bundleQuizInfo);

       getActivity().getSupportFragmentManager().beginTransaction()
               .replace(((ViewGroup) getView().getParent()).getId(), nextFrag)
               .addToBackStack(null)
               .commit();
   }


    public String getMyPageName() {
        Bundle bundle = this.getArguments();
        String myPageName = bundle.getString("Name", pageName );
        pageName = myPageName;
        return myPageName;
    }
/* public static Intent makeIntent(Context context,String myPageName) {
        mMyPageNameQuiz = myPageName;
        return new Intent(context, Quiz.class);
    }
*/

}