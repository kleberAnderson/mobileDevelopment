package br.edu.fateczl.crud;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisciplinaActivity extends AppCompatActivity {
    private EditText etCodigoDisc;
    private EditText etNomeDisc;
    private Button btnBuscarDisc;
    private Button btnInserirDisc;
    private Button btnModificarDisc;
    private Button btnExcluirDisc;
    private Button btnListarDisc;
    private TextView tvListaDisc;
    private Spinner spProfDisc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_disciplina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCodigoDisc = findViewById(R.id.etCodigoDisc);
        etNomeDisc = findViewById(R.id.etNomeDisc);
        btnBuscarDisc = findViewById(R.id.btnBuscarDisc);
        btnInserirDisc = findViewById(R.id.btnInserirDisc);
        btnModificarDisc = findViewById(R.id.btnModificarDisc);
        btnExcluirDisc = findViewById(R.id.btnExcluirDisc);
        btnListarDisc = findViewById(R.id.btnListarDisc);
        tvListaDisc = findViewById(R.id.tvListaDisc);
        tvListaDisc.setMovementMethod(new ScrollingMovementMethod());
        spProfDisc = findViewById(R.id.spProfDisc);

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