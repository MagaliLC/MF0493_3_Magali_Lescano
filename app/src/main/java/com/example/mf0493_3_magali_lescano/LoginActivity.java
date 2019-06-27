package com.example.mf0493_3_magali_lescano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
EditText et_email, et_password;
TextView tv_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        tv_url = findViewById(R.id.tv_films_url);
    }

    public void goToUrl(View view) {
        
    }
}



/* PRUEBAS CON SHARED

    prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int counter = prefs.getInt("counter", 0);
        counter++;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("counter", counter);
        editor.commit();
        tvCounter.setText(String.valueOf(prefs.getInt("counter", 0)));
 */