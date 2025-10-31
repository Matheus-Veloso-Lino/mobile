package unip.prototipo.model;

public class Chamado {
    private String titulo;
    private String descricao;
    private String prioridade;

    public Chamado(String titulo, String descricao, String prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }
}
