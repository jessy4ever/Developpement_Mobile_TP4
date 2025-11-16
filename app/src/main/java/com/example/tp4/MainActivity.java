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
    Button buttonSomme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatrice);

        editTextNombre1 = findViewById(R.id.editTextNombre1);
        editTextNombre2 = findViewById(R.id.editTextNombre2);
        textViewResultat = findViewById(R.id.textViewResultat);
        buttonSomme = findViewById(R.id.buttonSomme);

        buttonSomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double n1 = Double.parseDouble(editTextNombre1.getText().toString());
                    double n2 = Double.parseDouble(editTextNombre2.getText().toString());
                    double somme = n1 + n2;
                    textViewResultat.setText("Résultat : " + somme);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Veuillez entrer des nombres valides", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
