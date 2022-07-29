package com.passwordmanager.openpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText editPassword1, editPassword2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        editPassword1 = (EditText) findViewById(R.id.editPassword1);
        editPassword2 = (EditText) findViewById(R.id.editPassword2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editPassword1.getText().toString();
                String text2 = editPassword2.getText().toString();

                if (text1.isEmpty() || text2.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "No password entered", Toast.LENGTH_SHORT).show();
                } else {
                    if (text1.equals(text2)){
                        SharedPreferences settings = getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", text1);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this,"Password doesn't Match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}