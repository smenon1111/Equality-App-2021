package com.example.informationapp2021;

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
import android.content.Intent;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class AddCoins extends Fragment {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME="T_Register";
    TextView name;
    TextView username;
    Cursor results;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View profileView = inflater.inflate(R.layout.addcoins, container, false);

        TextView textView = profileView.findViewById(R.id.getusername);

        openHelper = new DataBaseHelper(getActivity().getApplicationContext());
        db = openHelper.getWritableDatabase();
        results = DataBaseHelper.GetUserData(db);

        if (results.getCount() <= 0)
        {
            Toast.makeText(getActivity().getApplicationContext(), "No data found in the User db", Toast.LENGTH_LONG).show();
        }
        else
        {
            StringBuilder stringBuilder = new StringBuilder();

            if (results.moveToLast()) {
                stringBuilder.append("Name: " + results.getString(1)
                        + "\nUsername: " + results.getString(2)
                        + "\nCoins: " + results.getString(7)
                );

                textView.setText(stringBuilder);
            }
        }

        Button addcoins = (Button) profileView.findViewById(R.id.addcoins);
        addcoins.setOnClickListener (new View.OnClickListener() {
            public void onClick(View view) {
                openHelper = new DataBaseHelper(getActivity().getApplicationContext());
                db = openHelper.getWritableDatabase();
                String currCoins = results.getString(7);

                int coinsCount = Integer.parseInt(currCoins) + 100000;

                long AddCoinsID = DataBaseHelper.updateCoins(db, results.getString(2), String.valueOf(coinsCount));

                if (AddCoinsID <= 0)
                    Toast.makeText(getActivity().getApplicationContext(), "Add coins was unsuccessful", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Add coins was successful", Toast.LENGTH_LONG).show();
            }
        });

        return profileView;
    }

}
