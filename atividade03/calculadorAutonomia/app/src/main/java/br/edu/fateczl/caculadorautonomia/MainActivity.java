/*
 *@author: Anderson Velasco
 */

package br.edu.fateczl.caculadorautonomia;

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
    private EditText etConsumoMedio;
    private  EditText etQtdeLitros;
    private TextView tvRes;
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
        Button btnCalcular = findViewById(R.id.btnCalcular);

        etConsumoMedio = findViewById(R.id.etConsumoMedio);
        etConsumoMedio.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etQtdeLitros = findViewById(R.id.etQtdeLitros);
        etQtdeLitros.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calcularAutonomiaAutomovel());
    }

    private void calcularAutonomiaAutomovel(){
        Float consumoMedio = Float.parseFloat(etConsumoMedio.getText().toString());
        Float quantidadeLitros = Float.parseFloat(etQtdeLitros.getText().toString());

        String telaFinal = "Autonomia de " + calcularAutonomiaMetros(consumoMedio, quantidadeLitros) + " metros.";
        tvRes.setText(telaFinal);

        etConsumoMedio.setText("");
        etQtdeLitros.setText("");
    }

    private Float calcularAutonomiaMetros(Float consumoMedio, Float quantidadeLitros){
        return ((consumoMedio * quantidadeLitros) * 1000);
    }
}