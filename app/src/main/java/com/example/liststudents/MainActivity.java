package com.example.liststudents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private EditText editTextApellidoPaterno, editTextApellidoMaterno, editTextNombres, editTextFechaNacimiento, editTextColegio, editTextCarrera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextApellidoPaterno = findViewById(R.id.editTextApellidoPaterno);
        editTextApellidoMaterno = findViewById(R.id.editTextApellidoMaterno);
        editTextNombres = findViewById(R.id.editTextNombres);
        editTextFechaNacimiento = findViewById(R.id.editTextFechadeNacimiento);
        editTextColegio = findViewById(R.id.editTextColegio);
        editTextCarrera = findViewById(R.id.editTextCerrera);


        Button buttonEnviar = findViewById(R.id.buttonEnviar);
        Button buttonListar = findViewById(R.id.buttonListar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados por el usuario
                String apellidoPaterno = editTextApellidoPaterno.getText().toString();
                String apellidoMaterno = editTextApellidoMaterno.getText().toString();
                String nombres = editTextNombres.getText().toString();
                String fechaNacimiento = editTextFechaNacimiento.getText().toString();
                String colegio = editTextColegio.getText().toString();
                String carrera = editTextCarrera.getText().toString();

                // Crear un nuevo objeto Postulante
                Postulante postulante = new Postulante(apellidoPaterno, apellidoMaterno, nombres,
                        fechaNacimiento, colegio, carrera);

                // Registrar el postulante usando el DAO
                DAOPostulante.registrarPostulante(postulante);

                Log.d(TAG, "Postulante registrado:");
                Log.d(TAG, "Apellido Paterno: " + postulante.getApellidoPaterno());
                Log.d(TAG, "Apellido Materno: " + postulante.getApellidoMaterno());
                Log.d(TAG, "Nombres: " + postulante.getNombres());
                Log.d(TAG, "Fecha de Nacimiento: " + postulante.getFechaNacimiento());
                Log.d(TAG, "Colegio: " + postulante.getColegioProcedencia());
                Log.d(TAG, "Carrera: " + postulante.getCarrera());

                // Limpiar los campos del formulario
                limpiarCampos();


                Log.i(TAG, "Postulante Agregado");
            }
        });

        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la lista de postulantes registrados usando el DAO
                List<Postulante> postulantesRegistrados = DAOPostulante.listarPostulantes();

                // Mostrar los datos de los postulantes en LogCat
                for (Postulante postulante : postulantesRegistrados) {
                    Log.d(TAG, "Postulante registrado:");
                    Log.d(TAG, "Apellido Paterno: " + postulante.getApellidoPaterno());
                    Log.d(TAG, "Apellido Materno: " + postulante.getApellidoMaterno());
                    Log.d(TAG, "Nombres: " + postulante.getNombres());
                    Log.d(TAG, "Fecha de Nacimiento: " + postulante.getFechaNacimiento());
                    Log.d(TAG, "Colegio: " + postulante.getColegioProcedencia());
                    Log.d(TAG, "Carrera: " + postulante.getCarrera());

                }
            }
        });
    }

    private void limpiarCampos() {
        editTextApellidoPaterno.setText("");
        editTextApellidoMaterno.setText("");
        editTextNombres.setText("");
        editTextFechaNacimiento.setText("");
        editTextColegio.setText("");
        editTextCarrera.setText("");
    }

}
