package com.example.informationapp2021;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Fragment {

    private int ButtonClicks;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME="T_Register";
    Cursor results;
    String currUser, currCoins, currPurchase;
    EditText numofcoins;
    int char1price = 100, char2price = 200, char3price = 300;
    String newPurch = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View shopView  = inflater.inflate(R.layout.shop, container, false);

        final TextView character1Cost = (TextView) shopView.findViewById(R.id.character1Coins);
        final TextView character2Cost = (TextView) shopView.findViewById(R.id.character2Coins);
        final TextView character3Cost = (TextView) shopView.findViewById(R.id.character3Coins);
//        final TextView character4Cost = (TextView) shopView.findViewById(R.id.character4Coins);
//        final TextView character5Cost = (TextView) shopView.findViewById(R.id.character5Coins);

        final ImageView Image1 = (ImageView) shopView.findViewById(R.id.character1);
        final ImageView Image2 = (ImageView) shopView.findViewById(R.id.character2);
        final ImageView Image3 = (ImageView) shopView.findViewById(R.id.character3);
//        final ImageView Image4 = (ImageView) shopView.findViewById(R.id.character4);
//        final ImageView Image5 = (ImageView) shopView.findViewById(R.id.character5);

        Button purchaseButton1 = (Button) shopView.findViewById(R.id.character1PurchaseButton);
        Button purchaseButton2 = (Button) shopView.findViewById(R.id.character2PurchaseButton);
        Button purchaseButton3 = (Button) shopView.findViewById(R.id.character3PurchaseButton);
//        Button purchaseButton4 = (Button) shopView.findViewById(R.id.character4PurchaseButton);
//        Button purchaseButton5 = (Button) shopView.findViewById(R.id.character5PurchaseButton);

        TextView userCoins= shopView.findViewById(R.id.usercoins);

        openHelper = new DataBaseHelper(getActivity().getApplicationContext());
        db = openHelper.getWritableDatabase();
        results = DataBaseHelper.GetUserCharsCoins(db);

        if (results.getCount() <= 0)
        {
            Toast.makeText(getActivity().getApplicationContext(), "No data found in the User db", Toast.LENGTH_LONG).show();
        }
        else
        {
            StringBuilder stringBuilder = new StringBuilder();

            if (results.moveToLast()) {
                currUser = results.getString(0);
                currCoins = results.getString(1);
                currPurchase = results.getString(2);

                stringBuilder.append("Your Coins: " + currCoins);

                userCoins.setText(stringBuilder);
            }
        }
        purchaseButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    int coinsCount = Integer.parseInt(currCoins) - char1price;
                    newPurch = null;
                    if (coinsCount > 0) {
                        if (currPurchase.contains("Character1")) {
                            Toast.makeText(getActivity().getApplicationContext(), "You have already purchased Character1", Toast.LENGTH_LONG).show();
                        }
                        else {
                            if(currPurchase.equals(null)){
                                newPurch = "Character1";
                            }
                            else {
                                newPurch = currPurchase + " Character1";
                            }

                            long UpdateCoinsID = DataBaseHelper.updatePurchase(db, currUser, String.valueOf(coinsCount), newPurch);
                            if (UpdateCoinsID <= 0)
                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was not successful. Please try again later.", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was successful", Toast.LENGTH_LONG).show();

                            character1Cost.setText(R.string.characterPurchased);
                            Image1.setImageResource(R.drawable.bear_character);
                        }
                        ButtonClicks = 1;
                    }
                }
                else if (ButtonClicks > 0){
                    makeToast();
                }
            }
        });

        purchaseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    int coinsCount = Integer.parseInt(currCoins) - char2price;
                    newPurch = null;
                    if (coinsCount > 0) {
                        if (currPurchase.contains("Character2")) {
                            Toast.makeText(getActivity().getApplicationContext(), "You have already purchased Character2", Toast.LENGTH_LONG).show();
                        } else {
                            if (currPurchase.equals(null)) {
                                newPurch = "Character2";
                            } else {
                                newPurch = currPurchase + " Character2";
                            }

                            long UpdateCoinsID = DataBaseHelper.updatePurchase(db, currUser, String.valueOf(coinsCount), newPurch);
                            if (UpdateCoinsID <= 0)
                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was not successful. Please try again later", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was not successful", Toast.LENGTH_LONG).show();

                            character2Cost.setText(R.string.characterPurchased);
                            Image2.setImageResource(R.drawable.antelope_character);
                        }
                        ButtonClicks = 1;
                    }
                }
                else if (ButtonClicks > 0) {
                    makeToast();
                }
            }
        });

        purchaseButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicks = 0;
                if (ButtonClicks == 0) {
                    int coinsCount = Integer.parseInt(currCoins) - char3price;
                    newPurch = null;
                    if (coinsCount > 0) {
                        if (currPurchase.contains("Character3")) {
                            Toast.makeText(getActivity().getApplicationContext(), "You have already purchased Character3", Toast.LENGTH_LONG).show();
                        }
                        else {
                            if(currPurchase.equals(null)){
                                newPurch = "Character3";
                            }
                            else {
                                newPurch = currPurchase + " Character3";
                            }

                            long UpdateCoinsID = DataBaseHelper.updatePurchase(db, currUser, String.valueOf(coinsCount), newPurch);
                            if (UpdateCoinsID <= 0)
                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was not successful. Please try again later.", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was successful", Toast.LENGTH_LONG).show();

                            character3Cost.setText(R.string.characterPurchased);
                            Image3.setImageResource(R.drawable.frog_character);
                        }
                        ButtonClicks = 1;
                    }
                }
                else if (ButtonClicks > 0){
                    makeToast();
                }
            }
        });

//        purchaseButton4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ButtonClicks = 0;
//                if (ButtonClicks == 0) {
//                    int coinsCount = Integer.parseInt(currCoins) - char4price;
//                    newPurch = null;
//                    if (coinsCount > 0) {
//                        if (currPurchase.contains("Character4")) {
//                            Toast.makeText(getActivity().getApplicationContext(), "You have already purchased Character1", Toast.LENGTH_LONG).show();
//                        }
//                        else {
//                            if(currPurchase.equals(null)){
//                                newPurch = "Character4";
//                            }
//                            else {
//                                newPurch = currPurchase + " Character4";
//                            }
//
//                            long UpdateCoinsID = DataBaseHelper.updatePurchase(db, currUser, String.valueOf(coinsCount), newPurch);
//                            if (UpdateCoinsID <= 0)
//                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was not successful. Please try again later.", Toast.LENGTH_LONG).show();
//                            else
//                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was successful", Toast.LENGTH_LONG).show();
//
//                            character4Cost.setText(R.string.characterPurchased);
//                            Image4.setImageResource(R.drawable.character4);
//                        }
//                        ButtonClicks = 1;
//                    }
//                }
//                else if (ButtonClicks > 0){
//                    makeToast();
//                }
//            }
//        });
//
//        purchaseButton5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ButtonClicks = 0;
//                if (ButtonClicks == 0) {
//                    int coinsCount = Integer.parseInt(currCoins) - char5price;
//                    newPurch = null;
//                    if (coinsCount > 0) {
//                        if (currPurchase.contains("Character5")) {
//                            Toast.makeText(getActivity().getApplicationContext(), "You have already purchased Character5", Toast.LENGTH_LONG).show();
//                        }
//                        else {
//                            if(currPurchase.equals(null)){
//                                newPurch = "Character5";
//                            }
//                            else {
//                                newPurch = currPurchase + " Character5";
//                            }
//
//                            long UpdateCoinsID = DataBaseHelper.updatePurchase(db, currUser, String.valueOf(coinsCount), newPurch);
//                            if (UpdateCoinsID <= 0)
//                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was not successful. Please try again later.", Toast.LENGTH_LONG).show();
//                            else
//                                Toast.makeText(getActivity().getApplicationContext(), "Purchase was successful", Toast.LENGTH_LONG).show();
//
//                            character5Cost.setText(R.string.characterPurchased);
//                            Image5.setImageResource(R.drawable.character5);
//                        }
//                        ButtonClicks = 1;
//                    }
//                }
//                else if (ButtonClicks > 0){
//                    makeToast();
//                }
//            }
//        });


        return shopView;
    }

    public void makeToast(){
        Toast CharacterPurchased = Toast.makeText(getContext(), "Character has already been purchased!", Toast.LENGTH_LONG);
        CharacterPurchased.show();
    }
}
