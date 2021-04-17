package com.example.informationapp2021;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class Donate extends Fragment {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME="T_Register";
    Cursor results;

    EditText numofcoins;
    TextView dollarvalue;
    double dollarconvert;
    String currUser, currCoins;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState)
        {
        final View profileView = inflater.inflate(R.layout.donate, container, false);;

        TextView textView = profileView.findViewById(R.id.displaycoins);

        results = GetUserCoins();

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
                stringBuilder.append("Your Coins: " + currCoins);

                textView.setText(stringBuilder);
            }
        }

            Button calculate = (Button) profileView.findViewById(R.id.calculate);
            calculate.setOnClickListener (new View.OnClickListener() {
                @SuppressLint("DefaultLocale")
                public void onClick(View view) {
                    numofcoins = profileView.findViewById(R.id.numofcoins);
                    dollarconvert = Double.parseDouble(numofcoins.getText().toString())/1000;
                    dollarvalue = profileView.findViewById(R.id.dollarvalue);
                    dollarvalue.setText(String.format("%.2f", dollarconvert));
                }
            });

            Button donate1 = (Button) profileView.findViewById(R.id.donate1);
            donate1.setOnClickListener (new View.OnClickListener() {
                public void onClick(View view) {
                    openHelper = new DataBaseHelper(getActivity().getApplicationContext());
                    db = openHelper.getWritableDatabase();
                    int coinsCount = Integer.parseInt(currCoins) - Integer.parseInt(numofcoins.getText().toString());

                    if (coinsCount < 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "You cannot donate more than the coins you have", Toast.LENGTH_LONG).show();
                    }
                    else {
                        long UpdateCoinsID = updateNewCoins(currUser, String.valueOf(coinsCount));

                        if (UpdateCoinsID <= 0)
                            Toast.makeText(getActivity().getApplicationContext(), "Update coins count was unsuccessful", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity().getApplicationContext(), "Update coins count was successful", Toast.LENGTH_LONG).show();
                    }
                }
            });

            Button donate2 = (Button) profileView.findViewById(R.id.donate2);
            donate2.setOnClickListener (new View.OnClickListener() {
                public void onClick(View view) {
                    openHelper = new DataBaseHelper(getActivity().getApplicationContext());
                    db = openHelper.getWritableDatabase();
                    int coinsCount = Integer.parseInt(currCoins) - Integer.parseInt(numofcoins.getText().toString());

                    if (coinsCount < 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "You cannot donate more than the coins you have", Toast.LENGTH_LONG).show();
                    }
                    else {
                        long UpdateCoinsID = updateNewCoins(currUser, String.valueOf(coinsCount));

                        if (UpdateCoinsID <= 0)
                            Toast.makeText(getActivity().getApplicationContext(), "Update coins count was unsuccessful", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity().getApplicationContext(), "Update coins count was successful", Toast.LENGTH_LONG).show();
                    }
                }
            });

            Button donate3 = (Button) profileView.findViewById(R.id.donate3);
            donate3.setOnClickListener (new View.OnClickListener() {
                public void onClick(View view) {
                    openHelper = new DataBaseHelper(getActivity().getApplicationContext());
                    db = openHelper.getWritableDatabase();
                    int coinsCount = Integer.parseInt(currCoins) - Integer.parseInt(numofcoins.getText().toString());

                    if (coinsCount < 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "You cannot donate more than the coins you have", Toast.LENGTH_LONG).show();
                    }
                    else {
                        long UpdateCoinsID = updateNewCoins(currUser, String.valueOf(coinsCount));

                        if (UpdateCoinsID <= 0)
                            Toast.makeText(getActivity().getApplicationContext(), "Update coins count was unsuccessful", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity().getApplicationContext(), "Update coins count was successful", Toast.LENGTH_LONG).show();
                    }
                }
            });
        return profileView;
    }

    public Cursor GetUserCoins() {
        openHelper = new DataBaseHelper(getActivity().getApplicationContext());
        db = openHelper.getReadableDatabase();
        String query = "Select username, coins from " + TABLE_NAME;

        Cursor results = db.rawQuery(query, null);

        return results;
    }

    public long updateNewCoins(String username, String coins) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_3, username);
        contentValues.put(DataBaseHelper.COL_8, coins);
        String[] selectionArgs = { String.valueOf(username) };
        long id = db.update(DataBaseHelper.TABLE_NAME,contentValues,DataBaseHelper.COL_3 +" = ? ",selectionArgs);
        return id;

    }
}
