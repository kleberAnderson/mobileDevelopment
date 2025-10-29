/*
 *@author: Anderson Velasco
 */
package br.edu.fateczl.conversorarmazenamentodigital;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnConverter;
    private EditText etCampoBit;
    private Spinner spTabelaValores;
    private TextView tvTelaSaida;

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

        btnConverter = findViewById(R.id.btnConverter);
        etCampoBit = findViewById(R.id.etCampoBit);
        spTabelaValores = findViewById(R.id.spTabelaValores);
        tvTelaSaida = findViewById(R.id.tvTelaSaida);

        preencherSpinnerUnidArmazenamentoDigital();
        btnConverter.setOnClickListener(op -> gerar());
    }

    private void gerar() {
        final double BYTE_FACTOR = 8.0;
        final double KB_FACTOR = 8192.0;
        final double MB_FACTOR = 8388608.0;
        final double GB_FACTOR = 8589934592.0;
        final double TB_FACTOR = 8796093022208.0;
        double resultadoConvertido = 0.0;

        String unidadeDigital = (String) spTabelaValores.getSelectedItem().toString();
        String inputBitString = etCampoBit.getText().toString();
        if (inputBitString.isEmpty()) {
            return;
        }
        try {
            Double valorBit = Double.parseDouble(inputBitString);

            if(unidadeDigital.contains("Bytes")){
                resultadoConvertido = valorBit / BYTE_FACTOR;

            } else if (unidadeDigital.contains("Kilobyte")) {
                resultadoConvertido = valorBit / KB_FACTOR;

            } else if (unidadeDigital.contains("Megabyte")) {
                resultadoConvertido = valorBit / MB_FACTOR;

            } else if (unidadeDigital.contains("Gigabyte")) {
                resultadoConvertido = valorBit / GB_FACTOR;

            } else if (unidadeDigital.contains("Terabyte")) {
                resultadoConvertido = valorBit / TB_FACTOR;
            }

            String mensagemFinal = String.format("%.4f %s", resultadoConvertido, unidadeDigital);

            tvTelaSaida.setText(mensagemFinal);

        } catch (NumberFormatException e) {
        }
    }
    private void preencherSpinnerUnidArmazenamentoDigital() {
        List<String> listaSpinner = new ArrayList<>();
        listaSpinner.add("Bytes");
        listaSpinner.add("Kilobyte (KB)");
        listaSpinner.add("Megabyte (MB)");
        listaSpinner.add("Gigabyte (GB)");
        listaSpinner.add("Terabyte (TB)");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTabelaValores.setAdapter(adapter);
    }
}