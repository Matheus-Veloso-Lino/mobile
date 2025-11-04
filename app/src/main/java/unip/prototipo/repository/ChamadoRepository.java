package unip.prototipo.repository;

import java.util.ArrayList;
import java.util.List;
import unip.prototipo.model.Chamado;

public class ChamadoRepository {
    private static final List<Chamado> chamados = new ArrayList<>();
    private static long nextId = 1;

    // Bloco estático para adicionar dados de exemplo uma vez
    static {
        adicionarChamadosDeExemplo();
    }

    public static void adicionarChamado(Chamado chamado) {
        chamados.add(chamado);
    }

    public static List<Chamado> listarChamados() {
        return new ArrayList<>(chamados);
    }

    public static void limparChamados() {
        chamados.clear();
        nextId = 1; // Reseta o ID
        adicionarChamadosDeExemplo(); // Readiciona os exemplos para consistência
    }

    public static long getNextId() {
        return nextId++;
    }

    public static void removerChamado(long id) {
        chamados.removeIf(chamado -> chamado.getId() == id);
    }

    private static void adicionarChamadosDeExemplo() {
        if (chamados.isEmpty()) { // Adiciona somente se a lista estiver vazia
            chamados.add(new Chamado(getNextId(), "Impressora não funciona", "A impressora da sala 3 não está imprimindo.", "Alta", "Aberto"));
            chamados.add(new Chamado(getNextId(), "Mouse quebrado", "O mouse do meu computador parou de funcionar.", "Média", "Em Andamento"));
            chamados.add(new Chamado(getNextId(), "Instalar software", "Preciso do Photoshop instalado no meu notebook.", "Baixa", "Fechado"));
        }
    }
}
