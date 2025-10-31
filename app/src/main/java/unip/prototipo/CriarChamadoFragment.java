package unip.prototipo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import unip.prototipo.model.Chamado;
import unip.prototipo.repository.ChamadoRepository;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CriarChamadoFragment extends Fragment {

    private EditText edtTitulo, edtDescricao;
    private Spinner spnPrioridade;
    private Button btnCriarChamado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_criar_chamado, container, false);

        edtTitulo = view.findViewById(R.id.edtTitulo);
        edtDescricao = view.findViewById(R.id.edtDescricao);
        spnPrioridade = view.findViewById(R.id.spnPrioridade);
        btnCriarChamado = view.findViewById(R.id.btnCriarChamado);

        btnCriarChamado.setOnClickListener(v -> {
            String titulo = edtTitulo.getText().toString().trim();
            String descricao = edtDescricao.getText().toString().trim();
            String prioridade = spnPrioridade.getSelectedItem().toString();

            if (titulo.isEmpty() || descricao.isEmpty()) {
                Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            Chamado chamado = new Chamado(titulo, descricao, prioridade);
            ChamadoRepository.adicionarChamado(chamado);

            Toast.makeText(getContext(), "Chamado criado com sucesso!", Toast.LENGTH_SHORT).show();

            edtTitulo.setText("");
            edtDescricao.setText("");
            spnPrioridade.setSelection(0);
        });

        return view;
    }
}

