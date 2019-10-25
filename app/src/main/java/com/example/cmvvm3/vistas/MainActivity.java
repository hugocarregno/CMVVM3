package com.example.cmvvm3.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cmvvm3.R;
import com.example.cmvvm3.modelo.Cliente;

public class MainActivity extends AppCompatActivity {
private EditText dni;
private TextView apellido, nombre, domicilio,resultado;
private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getMLDCliente().observe(this, new Observer<Cliente>() {
            @Override
            public void onChanged(Cliente cliente) {
                if (cliente != null) {
                    apellido.setText(cliente.getApellido());
                    nombre.setText(cliente.getNombre());
                    domicilio.setText(cliente.getDomicilio());
                }
            }
        });
        mainViewModel.cargarDatos();
        mainViewModel.getMLDResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                resultado.setText(s);
            }
        });
    }

    private void inicializar(){
        dni = findViewById(R.id.etDni);
        nombre = findViewById(R.id.tvNombre);
        apellido = findViewById(R.id.tvApellido);
        domicilio = findViewById(R.id.tvDomicilio);
        resultado = findViewById(R.id.tvResultado);
    }

    public void buscar(View v){
        long doc = Long.parseLong(dni.getText().toString());
        mainViewModel.buscarCliente(doc);

    }
}
