package unip.prototipo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import unip.prototipo.model.Chamado;
import unip.prototipo.repository.ChamadoRepository;

public class DetalhesChamadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_chamado);

        TextView tvTitulo = findViewById(R.id.tvTituloDetalhes);
        TextView tvDescricao = findViewById(R.id.tvDescricaoDetalhes);
        TextView tvPrioridade = findViewById(R.id.tvPrioridadeDetalhes);
        Button btnDeletar = findViewById(R.id.btnDeletarChamado);

        Chamado chamado = (Chamado) getIntent().getSerializableExtra("chamado");

        if (chamado != null) {
            tvTitulo.setText(chamado.getTitulo());
            tvDescricao.setText(chamado.getDescricao());
            tvPrioridade.setText("Prioridade: " + chamado.getPrioridade());

            btnDeletar.setOnClickListener(v -> {
                ChamadoRepository.removerChamado(chamado.getId());
                finish(); // Fecha a activity e volta para a lista
            });
        }
    }
}
