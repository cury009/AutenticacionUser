package com.example.autenticacionuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static  final  String EXTRAMAIL = "email" ;
    EditText edt_mail = null;
    EditText edt_password = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_mail = findViewById(R.id.edt_mail);
        edt_password = findViewById(R.id.edt_password);
    }

    public void acceder(View view) {

        String email = String.valueOf(edt_mail.getText());
        String password = String.valueOf(edt_password.getText());
        if(validarcredenciales(email,password)) {

            Intent intent =  new Intent(this, ActiviityHome.class);
            intent.putExtra(EXTRAMAIL,email);
            startActivity(intent);
        }
        else {
            edt_mail.setError("usuario o clave erronea");
            edt_password.setError("usuario o clave erronea");
            Toast.makeText(this,"usuario o clave erronea",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarcredenciales(String email, String password) {
        if(email.equalsIgnoreCase("usuario1@gmail.com") &&
        password.equalsIgnoreCase("12345")) {

            return  true;

        }
        return false;
    }
}