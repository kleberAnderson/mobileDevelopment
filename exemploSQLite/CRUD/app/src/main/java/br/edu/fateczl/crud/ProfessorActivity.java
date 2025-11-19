package br.edu.fateczl.crud;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfessorActivity extends AppCompatActivity {
    private EditText etCodigoProf;
    private EditText etNomeProf;
    private EditText etTitulacaoProf;
    private Button btnBuscarProf;
    private Button btnInserirProf;
    private Button btnModificarProf;
    private Button btnExcluirProf;
    private Button btnListarProf;
    private TextView tvListaProf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_professor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCodigoProf = findViewById(R.id.etCodigoProf);
        etNomeProf = findViewById(R.id.etNomeProf);
        etTitulacaoProf = findViewById(R.id.etTitulacaoProf);
        btnBuscarProf = findViewById(R.id.btnBuscarProf);
        btnInserirProf = findViewById(R.id.btnInserirProf);
        btnModificarProf = findViewById(R.id.btnModificarProf);
        btnExcluirProf = findViewById(R.id.btnExcluirProf);
        btnListarProf = findViewById(R.id.btnListarProf);
        tvListaProf = findViewById(R.id.tvListaProf);
        tvListaProf.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_inicial) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            this.finish();
            return true;
        }
        if(id == R.id.menu_professor) {
            Intent intent = new Intent(this, ProfessorActivity.class);
            this.startActivity(intent);
            this.finish();
            return true;
        }
        if(id == R.id.menu_disciplina) {
            Intent intent = new Intent(this, DisciplinaActivity.class);
            this.startActivity(intent);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}