package com.example.autenticacionuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import clases.Usuario;

public class ActiviityHome extends AppCompatActivity {

    TextView txt_saludo = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiity_home);
        Intent intent = getIntent();
        txt_saludo = (TextView) findViewById(R.id.txtSaludo);
        if (intent != null) {
            String messaje = intent.getStringExtra(MainActivity.EXTRAMAIL);
            if (messaje != null) {
                txt_saludo.setText("Bienvenido " + messaje);
            } else {
                Usuario user1 = (Usuario) intent.getSerializableExtra(ActivityRegistro.EXTRA_OBJETO_USUARIO);
                if (user1 != null) {
                    txt_saludo.setText("Bienvenido Nuevo Usuario" + user1.getNombre());
                }

            }
        }



    }
}