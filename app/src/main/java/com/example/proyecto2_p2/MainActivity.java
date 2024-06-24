package com.example.proyecto2_p2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    private RadioGroup radioGroup;

    private RadioButton rb1, rb2, rb3;

    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                float num1, num2, res=0;
                String operacion = "";
                num1 = Float.parseFloat(et1.getText().toString());
                num2 = Float.parseFloat(et2.getText().toString());
                if(checkedId == R.id.rb1){
                    tv1.setText("Corriente");
                    tv2.setText("Resistencia");
                    operacion = "Voltaje";
                    res = num1 * num2;
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
                    intent.putExtra("res", res);
                    intent.putExtra("op", operacion);
                    startActivity(intent);
                } else if (checkedId == R.id.rb2) {
                    tv1.setText("Voltaje");
                    tv2.setText("Resistencia");
                    operacion = "Corriente";
                    res = num1 / num2;
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
                    intent.putExtra("res", res);
                    intent.putExtra("op", operacion);
                    startActivity(intent);
                }else if (checkedId == R.id.rb3) {
                    tv1.setText("Voltaje");
                    tv2.setText("Corriente");
                    operacion = "Resistencia";
                    res = num1 / num2;
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
                    intent.putExtra("res", res);
                    intent.putExtra("op", operacion);
                    startActivity(intent);
                }

            }
        });

    }
}