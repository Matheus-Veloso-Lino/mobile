package unip.prototipo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import unip.prototipo.model.Chamado;
import unip.prototipo.repository.ChamadoRepository;

public class MyTicketsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tickets);

        RecyclerView rvMyTickets = findViewById(R.id.rvMyTickets);
        rvMyTickets.setLayoutManager(new LinearLayoutManager(this));

        List<Chamado> meusChamados = ChamadoRepository.listarChamados(); // Simulação, todos os chamados são "meus"
        MyTicketsAdapter adapter = new MyTicketsAdapter(meusChamados);
        rvMyTickets.setAdapter(adapter);
    }
}
