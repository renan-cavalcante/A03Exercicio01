package com.example.a03exercicio01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputAcool;
    private EditText inputGasolina;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputAcool = findViewById(R.id.inputAcool);
        inputGasolina = findViewById(R.id.inputGasolina);
        tvResultado = findViewById(R.id.tvResultado);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calculaCombustivel());
    }

    private void calculaCombustivel(){
        tvResultado.setText("");
        float alcool = Float.parseFloat(inputAcool.getText().toString());
        float gasolina = Float.parseFloat(inputGasolina.getText().toString());
        float diferenca = (alcool * 100)/gasolina;

        if(diferenca > 70){
            tvResultado.setText(R.string.gasolina_melhor);
        }else{
            tvResultado.setText(R.string.alcool_melhor);
        }
        inputGasolina.setText("");
        inputAcool.setText("");
    }
}