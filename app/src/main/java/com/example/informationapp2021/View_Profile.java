package com.example.informationapp2021;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;



import androidx.appcompat.app.AppCompatActivity;

public class View_Profile extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public static final String TABLE_NAME="T_Register";
    EditText name, username, password, email, prns, age, about;
    Cursor results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        openHelper = new DataBaseHelper(this);
        viewProfile();

        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        prns = (EditText) findViewById(R.id.prns);
        age = (EditText) findViewById(R.id.age);
        about = (EditText) findViewById(R.id.about);

        Button saveButton = findViewById(R.id.register);

        saveButton.setOnClickListener (new View.OnClickListener() {
            public void onClick(View view) {
                openHelper = new DataBaseHelper(getApplicationContext());
                db = openHelper.getWritableDatabase();
                long UpdateID = updateData(name.getText().toString(), username.getText().toString(), password.getText().toString(), email.getText().toString(),prns.getText().toString(), age.getText().toString(), about.getText().toString());
                if (UpdateID <= 0)
                    Toast.makeText(getApplicationContext(), "Save was ...Unsuccessful", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Emergency Plan Saved", Toast.LENGTH_LONG).show();
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


        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        prns = (EditText) findViewById(R.id.prns);
        age = (EditText) findViewById(R.id.age);
        about = (EditText) findViewById(R.id.about);
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
//        final TextView eTo = findViewById(R.id.nameID);
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
