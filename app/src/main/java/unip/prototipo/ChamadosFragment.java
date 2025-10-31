package unip.prototipo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import unip.prototipo.model.Chamado;
import unip.prototipo.repository.ChamadoRepository;

public class ChamadosFragment extends Fragment {

    private ChamadoAdapter chamadoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chamados, container, false);

        RecyclerView recyclerViewChamados = view.findViewById(R.id.recyclerViewChamados);
        recyclerViewChamados.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Chamado> listaChamados = ChamadoRepository.listarChamados();
        chamadoAdapter = new ChamadoAdapter(listaChamados);
        recyclerViewChamados.setAdapter(chamadoAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        chamadoAdapter.atualizarLista(ChamadoRepository.listarChamados());
    }
}
