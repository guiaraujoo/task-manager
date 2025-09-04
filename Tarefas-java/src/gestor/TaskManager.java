package gestor;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tarefas;
    private int proximoId;

    public TaskManager() {
        this.tarefas = new ArrayList<>();
        this.proximoId = 1;
    }

    public void adicionarTarefa(String descricao, String prioridade) {
        Task t = new Task(proximoId, descricao, prioridade);
        tarefas.add(t);
        proximoId++;
    }

    public List<Task> listarTarefas() {
        return tarefas;
    }

    public boolean concluirTarefa(int id) {
        for (Task t : tarefas) {
            if (t.getId() == id) {
                t.concluir();
                return true;
            }
        }
        return false;
    }

    public boolean removerTarefa(int id) {
        return tarefas.removeIf(t -> t.getId() == id);
    }
}
