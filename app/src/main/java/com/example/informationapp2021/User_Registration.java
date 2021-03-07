package com.example.informationapp2021;

import android.content.ContentValues;
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


public class User_Registration extends Fragment {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText name;
    EditText username;
    EditText password;
    EditText email;
    EditText prns;
    EditText age;
    EditText about;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View profileView = inflater.inflate(R.layout.register, container, false);

        name = (EditText) profileView.findViewById(R.id.name);
        username = (EditText) profileView.findViewById(R.id.username);
        password = (EditText) profileView.findViewById(R.id.password);
        email = (EditText) profileView.findViewById(R.id.email);
        prns = (EditText) profileView.findViewById(R.id.prns);
        age = (EditText) profileView.findViewById(R.id.age);
        about = (EditText) profileView.findViewById(R.id.about);

        Button btnRegister = (Button) profileView.findViewById(R.id.register);
        btnRegister.setOnClickListener (new View.OnClickListener() {
            public void onClick(View view) {
                openHelper = new DataBaseHelper(getActivity().getApplicationContext());
                db = openHelper.getWritableDatabase();
                long InsertID = insertdata(name.getText().toString(), username.getText().toString(),
                                        password.getText().toString(), email.getText().toString(),
                                        prns.getText().toString(), age.getText().toString(),
                                        about.getText().toString());
                if (InsertID <= 0)
                    Toast.makeText(getActivity().getApplicationContext(), "Registration was unsuccessful", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Registration was successful", Toast.LENGTH_LONG).show();
            }
        });

        return profileView;
    }
    public long insertdata(String name, String username, String password, String email, String prns, String age, String about) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_2, name);
        contentValues.put(DataBaseHelper.COL_3, username);
        contentValues.put(DataBaseHelper.COL_4, password);
        contentValues.put(DataBaseHelper.COL_5, email);
        contentValues.put(DataBaseHelper.COL_6, prns);
        contentValues.put(DataBaseHelper.COL_7, age);
        contentValues.put(DataBaseHelper.COL_8, about);

        long id = db.insert(DataBaseHelper.TABLE_NAME, null, contentValues);

        return id;

    }
}
