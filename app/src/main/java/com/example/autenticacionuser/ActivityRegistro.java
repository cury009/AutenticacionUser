package com.example.autenticacionuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import clases.Usuario;


public class ActivityRegistro extends AppCompatActivity {

    public static final String EXTRA_OBJETO_USUARIO = "com.example.autenticacionuser" ;
    EditText edt_nombrer= null;
    EditText edt_emailr = null;
    EditText edt_passwordr1 = null;
    EditText edt_passwordr2 = null;
    EditText edt_telefonor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edt_nombrer = (EditText)findViewById(R.id.edtNombreR);
        edt_emailr = (EditText) findViewById(R.id.edtEmailR);
        edt_passwordr1 =  (EditText) findViewById(R.id.edtPasswordR1);
        edt_passwordr2 = (EditText) findViewById(R.id.edtPasswordR2);
        edt_telefonor =  (EditText) findViewById(R.id.edtPhoneR);

    }

    public void registrarse(View view) {
        String contrasena1 = String.valueOf(edt_passwordr1.getText());
        String contrasena2 = String.valueOf(edt_passwordr2.getText());
        if (!contrasena1.equals(contrasena2)) {
            edt_passwordr1.setError("las contraseñas no coinciden");
            edt_passwordr2.setError("las contraseñas no coinciden");
            Toast.makeText(this,"las contraseñas no coinciden", Toast.LENGTH_SHORT);
            return;

        }
        String nombre = String.valueOf(edt_nombrer.getText());
        String email = String.valueOf(edt_emailr.getText());
        String telefono = String.valueOf(edt_telefonor);
        Usuario user1 = new Usuario(email, nombre,contrasena1, telefono);

        Intent intent = new Intent(this, ActiviityHome.class);
        intent.putExtra(EXTRA_OBJETO_USUARIO, user1);
        startActivity(intent);
        finish();

    }

    public void VolverLogin(View view) {
        finish();
    }
}