package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNombre1, editTextNombre2;
    TextView textViewResultat;
    Button buttonSomme, buttonSoustraction, buttonMultiplication, buttonDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatrice);

        editTextNombre1 = findViewById(R.id.editTextNombre1);
        editTextNombre2 = findViewById(R.id.editTextNombre2);
        textViewResultat = findViewById(R.id.textViewResultat);
        buttonSomme = findViewById(R.id.buttonSomme);
        buttonSoustraction = findViewById(R.id.buttonSoustraction);
        buttonMultiplication = findViewById(R.id.buttonMultiplication);
        buttonDivision = findViewById(R.id.buttonDivision);

        // Somme
        buttonSomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] nombres = getNombres();
                if(nombres != null)
                    textViewResultat.setText("Résultat : " + (nombres[0] + nombres[1]));
            }
        });

        // Soustraction
        buttonSoustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] nombres = getNombres();
                if(nombres != null)
                    textViewResultat.setText("Résultat : " + (nombres[0] - nombres[1]));
            }
        });

        // Multiplication
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] nombres = getNombres();
                if(nombres != null)
                    textViewResultat.setText("Résultat : " + (nombres[0] * nombres[1]));
            }
        });

        // Division
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] nombres = getNombres();
                if(nombres != null){
                    if(nombres[1] != 0)
                        textViewResultat.setText("Résultat : " + (nombres[0] / nombres[1]));
                    else
                        Toast.makeText(MainActivity.this, "Erreur : division par zéro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private double[] getNombres() {
        try {
            double n1 = Double.parseDouble(editTextNombre1.getText().toString());
            double n2 = Double.parseDouble(editTextNombre2.getText().toString());
            return new double[]{n1, n2};
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Veuillez entrer des nombres valides", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
