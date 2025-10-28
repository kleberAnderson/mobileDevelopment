/*
 *@author: Anderson Velasco
 */

package br.edu.fateczl.jogadordados;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbOne;
    private RadioButton rbTwo;
    private RadioButton rbThree;
    private Spinner spFacesDados;
    private Button btnGerador;
    private TextView tvSaida;

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

        rbOne = findViewById(R.id.rbOne);
        rbOne.setChecked(true);
        rbTwo = findViewById(R.id.rbTwo);
        rbThree =findViewById(R.id.rbThree);
        spFacesDados = findViewById(R.id.spFacesDados);
        btnGerador = findViewById(R.id.btnGerador);
        tvSaida = findViewById(R.id.tvSaida);

        preencherSpineer();
        btnGerador.setOnClickListener(op -> gerar());
    }

    private void gerar() {
        Integer numFaces = (Integer) spFacesDados.getSelectedItem();
        Random resultado = new Random();
        StringBuffer mensagemFinal = new StringBuffer();

        if (rbOne.isChecked()){
            simularRolagemDados(1, numFaces, mensagemFinal);
        } else if (rbTwo.isChecked()) {
            simularRolagemDados(2, numFaces, mensagemFinal);
        } else if (rbThree.isChecked()) {
            simularRolagemDados(3, numFaces, mensagemFinal);
        }
        tvSaida.setText(mensagemFinal.toString());
    }
    private void simularRolagemDados(int rolagem, Integer numFaces, StringBuffer mensagemFinal){
        Random resultadoDado = new Random();
        for(int i = 0; i < rolagem; i++){
            mensagemFinal.append(" [");
            mensagemFinal.append(resultadoDado.nextInt(numFaces) + 1);
            mensagemFinal.append("] ");
        }
    }

    private void preencherSpineer() {
        List<Integer> listaSpinner = new ArrayList<>();
        listaSpinner.add(4);
        listaSpinner.add(6);
        listaSpinner.add(8);
        listaSpinner.add(10);
        listaSpinner.add(12);
        listaSpinner.add(20);
        listaSpinner.add(100);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFacesDados.setAdapter(adapter);
    }
}