package com.cosa.com.ejemplologinparcelable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntentDatos extends AppCompatActivity implements IControlador{

    private Persona datos = null;
    private TextView nombre;
    private TextView apellidos;
    private TextView edad;
    private Button irAResultados;
    private Button salir;
    private Intent direccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_datos);
        eventosFormulario();

    }

    private void eventosFormulario() {
        nombre = (EditText)findViewById(R.id.editNombre);
        apellidos = (EditText)findViewById(R.id.editApellidos);
        edad = (EditText)findViewById(R.id.editEdad);
        irAResultados = (Button)findViewById(R.id.botonResultados);
        irAResultados.setOnClickListener(this);
        salir = (Button)findViewById(R.id.botonSalirDatos);
        salir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.botonResultados:
                if (nombre.getText().length()>0 && apellidos.getText().length()>0 && edad.getText().length()>0){
                    datos = new Persona(nombre.getText().toString(),
                            apellidos.getText().toString(),
                            Integer.parseInt(edad.getText().toString()));
                    direccion = new Intent(this, IntentDireccion.class);
                    direccion.putExtra("datos",datos);
                    startActivityForResult(direccion,0);

                }
                break;
            case R.id.botonSalirDatos:
                setResult(-1);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1: //he vuelto, sacar toast
                tostada("He vuelto");
                break;
            case -1: //Salir
                setResult(-1);
                finish();
                break;
        }
    }

    private void tostada(String texto) {
        Context context = getApplicationContext();
        CharSequence text = texto;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
