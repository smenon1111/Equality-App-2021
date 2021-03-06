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
import androidx.fragment.app.Fragment;





public class View_Profile extends Fragment {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME="T_Register";
    EditText name, username, password, email, prns, age, about;
    Cursor results;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View profileView = inflater.inflate(R.layout.profile, container, false);

        openHelper = new DataBaseHelper(getContext());
        viewProfile();

        name = (EditText) profileView.findViewById(R.id.name);
        username = (EditText) profileView.findViewById(R.id.username);
        password = (EditText) profileView.findViewById(R.id.password);
        email = (EditText) profileView.findViewById(R.id.email);
        prns = (EditText) profileView.findViewById(R.id.prns);
        age = (EditText) profileView.findViewById(R.id.age);
        about = (EditText) profileView.findViewById(R.id.about);

        Button saveButton = profileView.findViewById(R.id.register);

        saveButton.setOnClickListener (new View.OnClickListener() {
            public void onClick(View view) {
                openHelper = new DataBaseHelper(getActivity());
                db = openHelper.getWritableDatabase();
                long UpdateID = updateData(name.getText().toString(), username.getText().toString(), password.getText().toString(), email.getText().toString(),prns.getText().toString(), age.getText().toString(), about.getText().toString());
                if (UpdateID <= 0)
                    Toast.makeText(getActivity(), "Save was ...Unsuccessful", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Emergency Plan Saved", Toast.LENGTH_LONG).show();
            }
        });

//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // viewEmail();
//                Intent it = new Intent(Intent.ACTION_SEND);
//                it.putExtra(Intent.EXTRA_SUBJECT,"My Profile");
//                it.putExtra(Intent.EXTRA_TEXT,
//                           "Name:: " + name.getText() + ", "+
//                                "Username: " + username.getText() + ", " +
//                                "Email: " + email.getText() + "  " +
//                                "Pronouns: " + prns.getText() + "  " +
//                                "Age: "  + age.getText() + "  " +
//                                "About: " + about.getText());
//                it.setType("message/rfc822");
//                startActivity(Intent.createChooser(it,"Choose Mail App"));
//            }
//        });
    return profileView;

    }
    public long updateData(String name, String username, String password, String email, String prns, String age, String about) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_2, name);
        contentValues.put(DataBaseHelper.COL_3, username);
        contentValues.put(DataBaseHelper.COL_4, password);
        contentValues.put(DataBaseHelper.COL_5, email);
        contentValues.put(DataBaseHelper.COL_6, prns);
        contentValues.put(DataBaseHelper.COL_7, age);
        contentValues.put(DataBaseHelper.COL_8, about);
        String[] selectionArgs = { String.valueOf(username) };
        long id = db.update(DataBaseHelper.TABLE_NAME,contentValues,DataBaseHelper.COL_3 +" = ? ",selectionArgs);
        return id;

    }




    public void viewProfile(){


        name = (EditText) getActivity().findViewById(R.id.name);
        username = (EditText) getActivity().findViewById(R.id.username);
        password = (EditText) getActivity().findViewById(R.id.password);
        email = (EditText) getActivity().findViewById(R.id.email);
        prns = (EditText) getActivity().findViewById(R.id.prns);
        age = (EditText) getActivity().findViewById(R.id.age);
        about = (EditText) getActivity().findViewById(R.id.about);
        results = GetProfiles();

        if (results.moveToLast()){
            name.setText(results.getString(2));
            username.setText(results.getString(3));
            password.setText(results.getString(4));
            email.setText(results.getString(5));
            prns.setText(results.getString(6));
            age.setText(results.getString(7));
            about.setText(results.getString(8));
        }
    }

//    public void viewEmail(){
//        final TextView eTo = profileView.findViewById(R.id.nameID);
//        results = GetProfiles();
//        if (results.moveToLast()){
//            eTo.setText(results.getString(5));
//        }
//    }
    public Cursor GetProfiles() {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;

        Cursor results = db.rawQuery(query, null);

        return results;
    }
}
