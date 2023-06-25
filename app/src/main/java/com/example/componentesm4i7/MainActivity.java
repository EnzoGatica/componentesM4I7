package com.example.componentesm4i7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private long tomarFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textUp = findViewById(R.id.textUp);
        CalendarView calendario = findViewById(R.id.calendario);
        EditText editText = findViewById(R.id.editText);
        Button btnFecha = findViewById(R.id.btnFecha);

        Toast.makeText(MainActivity.this, "Bienvenido a la aplicacion", Toast.LENGTH_SHORT).show();

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);

                tomarFecha = calendar.getTimeInMillis();
            }
        });

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String viewUp = editText.getText().toString();
                String selecionFecha = formatoFecha(tomarFecha);
                Toast.makeText(MainActivity.this,"Fecha selecionada: " + selecionFecha, Toast.LENGTH_SHORT).show();

                textUp.setText(viewUp);

            }
        });

    }
    private String formatoFecha(long fecha){
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(fecha));
    }
}