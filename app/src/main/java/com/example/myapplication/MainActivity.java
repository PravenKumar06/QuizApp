package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText celsiusInput;
    private EditText fahrenheitInput;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusInput = findViewById(R.id.celsiusInput);
        fahrenheitInput = findViewById(R.id.fahrenheitInput);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        if (!celsiusInput.getText().toString().isEmpty()) {
            double celsius = Double.parseDouble(celsiusInput.getText().toString());
            double fahrenheit = (celsius * 9/5) + 32;
            fahrenheitInput.setText(String.format("%.2f", fahrenheit));
            resultTextView.setText("");
        } else if (!fahrenheitInput.getText().toString().isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitInput.getText().toString());
            double celsius = (fahrenheit - 32) * 5/9;
            celsiusInput.setText(String.format("%.2f", celsius));
            resultTextView.setText("");
        } else {
            resultTextView.setText("Please enter a temperature value.");
        }
    }
}
