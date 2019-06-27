package com.example.mf0493_3_magali_lescano;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_email, et_password;
    TextView tv_url;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        tv_url = findViewById(R.id.tv_films_url);
    }

    public void goToUrl(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.abc.es/play/cine/peliculas/"));
        startActivity(intent);
    }


    public void btnEnterPressed(View view) {
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        if (checkFields(email,password)) {
            setLogged();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void setLogged() {
        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isLogged", true);
        editor.commit();
    }

    private boolean checkFields(String email, String password) {
        boolean valid = true;
        if ((!"".equals(email)) && ((!"".equals(password)))) {
            valid = true;
        } else {
            Toast.makeText(this, R.string.empty, Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;
    }

   /* private void toMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }*/
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