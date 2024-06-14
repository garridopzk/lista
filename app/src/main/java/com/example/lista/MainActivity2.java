package com.example.lista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    EditText ingreso;
    TextView nombre;
    Button Añadir;
    Button Borrar;
    Button Buscar;
    List<String> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ingreso = findViewById(R.id.ingreso);
        nombre = findViewById(R.id.tareas);
        Añadir = findViewById(R.id.Añadir);
        Borrar = findViewById(R.id.Borrar);
        Buscar = findViewById(R.id.Buscar);

        Añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = ingreso.getText().toString();
                tasks.add(task);
                updateTasksDisplay();
            }
        });

        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tasks.isEmpty()) {
                    tasks.remove(tasks.size() - 1);
                    updateTasksDisplay();
                }
            }
        });

        Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tareaBuscada = ingreso.getText().toString();

                boolean tareaEncontrada = false;
                for (String tarea : tasks) {
                    if (tarea.equalsIgnoreCase(tareaBuscada)) {
                        tareaEncontrada = true;
                        break;
                    }
                }

                if (tareaEncontrada) {
                    nombre.setText("Tarea encontrada: " + tareaBuscada);
                } else {
                    nombre.setText("Tarea no encontrada");
                }
            }
        });

    }

    private void updateTasksDisplay() {
        nombre.setText(String.join("\n", tasks));
    }
}
