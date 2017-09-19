package com.cosa.com.ejemplologinparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends AppCompatActivity implements IControlador{

    private Intent volver;
    private Persona datos = null;
    private TextView resNombre;
    private TextView resApellidos;
    private TextView resEdad;
    private TextView resCalle;
    private TextView resCp;
    private Button botonVolver;
    private Button botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        datos = getIntent().getExtras().getParcelable("datos");
        eventosFormulario();
        pintarResultado();
    }

    private void pintarResultado() {
        resNombre.setText(datos.getNombre());
        resApellidos.setText(datos.getApellidos());
        resEdad.setText(datos.getEdad().toString());
        resCalle.setText(datos.getCalle());
        resCp.setText(datos.getCP().toString());
    }

    private void eventosFormulario() {
        resNombre = (TextView)findViewById(R.id.resNombre);
        resApellidos = (TextView)findViewById(R.id.resApellidos);
        resEdad = (TextView)findViewById(R.id.resEdad);
        resCalle = (TextView)findViewById(R.id.resCalle);
        resCp = (TextView)findViewById(R.id.resCP);
        botonSalir = (Button)findViewById(R.id.botonSalir);
        botonSalir.setOnClickListener(this);
        botonVolver = (Button)findViewById(R.id.botonVolver);
        botonVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.botonSalir:
                setResult(-1); //Salir
                break;
            case R.id.botonVolver:
                setResult(1); //Volver
                break;
        }
        finish();
    }
}
