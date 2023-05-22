package com.example.m213_tp_11_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp ;
    EditText quantite;
    Button cal;
    TextView res;

    String phones[] = {"Sk","So","Tk"};

    int selected_phone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp=findViewById(R.id.spinner);
        quantite = findViewById(R.id.ed_quantite);
        cal = findViewById(R.id.button);
        res = findViewById(R.id.resultat);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, phones);
        sp.setAdapter(spinnerArrayAdapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_phone = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int qt = Integer.parseInt(quantite.getText().toString());

                int total = 0;
                if(selected_phone == 0) {
                    total = qt*3200;

                }
                else {
                    if (selected_phone == 1) total = qt*4300;
                    else total = qt * 5000;
                }

                res.setText("Le prix total est "+total);

            }
        });
    }
}