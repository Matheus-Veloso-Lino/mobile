package unip.prototipo.repository;

import java.util.ArrayList;
import java.util.List;
import unip.prototipo.model.Chamado;

public class ChamadoRepository {
    private static final List<Chamado> chamados = new ArrayList<>();

    public static void adicionarChamado(Chamado chamado) {
        chamados.add(chamado);
    }

    public static List<Chamado> listarChamados() {
        return new ArrayList<>(chamados);
    }

    public static void limparChamados() {
        chamados.clear();
    }
}
