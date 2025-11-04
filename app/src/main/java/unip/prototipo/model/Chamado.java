package unip.prototipo.model;

import java.io.Serializable;

public class Chamado implements Serializable {
    private long id;
    private String titulo;
    private String descricao;
    private String prioridade;
    private String status; // Novo campo

    public Chamado(long id, String titulo, String descricao, String prioridade, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
    }

    public long getId() {
        return id;
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

    public String getStatus() {
        return status;
    }
}
