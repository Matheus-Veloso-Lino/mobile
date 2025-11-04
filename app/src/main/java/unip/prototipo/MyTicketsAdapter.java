package unip.prototipo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import unip.prototipo.model.Chamado;

public class MyTicketsAdapter extends RecyclerView.Adapter<MyTicketsAdapter.ViewHolder> {

    private final List<Chamado> chamados;

    public MyTicketsAdapter(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meu_chamado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chamado chamado = chamados.get(position);
        holder.titulo.setText(chamado.getTitulo());
        holder.descricao.setText(chamado.getDescricao());

        String statusText = "Status: " + chamado.getStatus();
        holder.status.setText(statusText);

        // Define a cor com base no status
        switch (chamado.getStatus()) {
            case "Aberto":
                holder.status.setTextColor(Color.GREEN);
                break;
            case "Fechado":
                holder.status.setTextColor(Color.RED);
                break;
            case "Em Andamento":
                holder.status.setTextColor(Color.BLUE);
                break;
            default:
                holder.status.setTextColor(Color.BLACK); // Cor padrão
                break;
        }
    }

    @Override
    public int getItemCount() {
        return chamados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, descricao, status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvMeuChamadoTitulo);
            descricao = itemView.findViewById(R.id.tvMeuChamadoDescricao);
            status = itemView.findViewById(R.id.tvMeuChamadoStatus);
        }
    }
}
