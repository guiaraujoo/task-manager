package gestor;

public class Task {
    private int id;
    private String descricao;
    private String prioridade;
    private boolean concluida;

    public Task(int id, String descricao, String prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return "[" + (concluida ? "✔️" : " ") + "] "
                + id + " - " + descricao + " | Prioridade: " + prioridade;
    }
}
