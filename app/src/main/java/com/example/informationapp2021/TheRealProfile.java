package com.example.informationapp2021;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class TheRealProfile extends Fragment {


    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME="T_Register";
    TextView name;
    TextView username;
    TextView password;
    TextView email;
    TextView prns;
    TextView about;
    TextView coins;
    Cursor results;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View profileView = inflater.inflate(R.layout.profile, container, false);

        TextView textView = profileView.findViewById(R.id.textView);

        openHelper = new DataBaseHelper(getActivity().getApplicationContext());
        db = openHelper.getReadableDatabase();
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
                        + "\nEmail: " + results.getString(4)
                        + "\nPronouns: " + results.getString(5)
                        + "\nBio: " + results.getString(7)
                        + "\nCoins: " + results.getString(8)
                );

                textView.setText(stringBuilder);
            }
        }

        return profileView;
    }


}
