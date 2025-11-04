package unip.prototipo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import unip.prototipo.model.Chamado;

public class ChamadoAdapter extends RecyclerView.Adapter<ChamadoAdapter.ViewHolder> {

    private List<Chamado> listaChamados;

    public ChamadoAdapter(List<Chamado> listaChamados) {
        this.listaChamados = listaChamados;
    }

    public void atualizarLista(List<Chamado> novaLista) {
        this.listaChamados = novaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chamado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chamado chamado = listaChamados.get(position);
        holder.textTitulo.setText(chamado.getTitulo());
        holder.textDescricao.setText(chamado.getDescricao());

        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetalhesChamadoActivity.class);
            intent.putExtra("chamado", chamado);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaChamados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitulo, textDescricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitulo = itemView.findViewById(R.id.textTituloChamado);
            textDescricao = itemView.findViewById(R.id.textDescricaoChamado);
        }
    }
}
