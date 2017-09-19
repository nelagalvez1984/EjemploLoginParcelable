package com.cosa.com.ejemplologinparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntentDireccion extends AppCompatActivity implements IControlador {

    Persona persona = null;
    Button botonSiguiente;
    Button botonVolver;
    Button botonSalir;
    TextView calle;
    TextView cp;
    Intent resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_direccion);
        persona = getIntent().getExtras().getParcelable("datos");
        eventosFormulario();

    }

    private void eventosFormulario() {
        //Botones
        botonSalir = (Button)findViewById(R.id.botonSalirDireccion);
        botonSalir.setOnClickListener(this);
        botonSiguiente = (Button)findViewById(R.id.botonSiguiente);
        botonSiguiente.setOnClickListener(this);
        botonVolver = (Button)findViewById(R.id.botonVolverDireccion);
        botonVolver.setOnClickListener(this);

        //Campos de texto
        calle = (EditText)findViewById(R.id.editCalle);
        cp = (EditText)findViewById(R.id.editCP);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonSalirDireccion:
                setResult(-1); //Salir
                finish();
                break;
            case R.id.botonSiguiente:
                resultados = new Intent(this,Resultados.class);
                persona.setDireccion(new Direccion(
                        calle.getText().toString(), //Calle
                        Integer.parseInt(cp.getText().toString()) //CP
                ));
                resultados.putExtra("datos",persona);
                startActivityForResult(resultados,2);
                break;
            case R.id.botonVolverDireccion:
                setResult(1); //Volver
                finish();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case -1:
                setResult(-1);
                finish();
        }
    }
}
