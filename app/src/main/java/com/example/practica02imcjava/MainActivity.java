package com.example.practica02imcjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Creando las variables
    private TextView lblAltura;
    private EditText txtAltura;
    private TextView lblPeso;
    private EditText txtPeso;
    private TextView lblResultado;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Relacionando componentes
        lblAltura = (TextView) findViewById(R.id.lblAltura);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        lblPeso = (TextView) findViewById(R.id.lblPeso);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        // Evento Click del botón Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtAltura.getText().toString().matches("") || txtPeso.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Falta Capturar Información", Toast.LENGTH_SHORT).show();
                } else {
                    Double altura = Double.parseDouble(txtAltura.getText().toString());
                    Double peso = Double.parseDouble(txtPeso.getText().toString());
                    altura = altura / 100;
                    Double resultado = peso / (altura * altura);
                    String str = String.format("Su IMC es: %.2f", resultado);
                    lblResultado.setText(str.toString());
                }
            }
        });

        //click del Botón Limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAltura.setText("");
                txtPeso.setText("");
                lblResultado.setText("");
            }
        });

        // Evento Click del Botón Cerrar
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}