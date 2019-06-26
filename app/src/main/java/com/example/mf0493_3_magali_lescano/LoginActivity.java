package com.example.mf0493_3_magali_lescano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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