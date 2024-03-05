package gestaoDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {
    private List<Tarefa> tarefas;
    private int proximoId = 0;

    public ListaDeTarefas() {
        tarefas = new ArrayList<>();
    }

    public boolean adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(proximoId, descricao);
        if (!tarefas.contains(tarefa)) {
            tarefas.add(tarefa);
            proximoId++;

            return true;
        }
        return false;

    }

    public Tarefa buscarTarefaporId(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }

        }
        return null;

    }

    public void marcarTarefaComoConcluida(int id) {
        Tarefa tarefa = buscarTarefaporId(id);
        if (tarefa != null) {
            tarefa.marcarComoConcluido();
        }
    }

    public boolean removerTarefa(int id) {
        Tarefa tarefa = buscarTarefaporId(id);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            return true;
        }
        return false;
    }

    public int obterQuantidaDeTarefas() {

        return tarefas.size();
    }


}
