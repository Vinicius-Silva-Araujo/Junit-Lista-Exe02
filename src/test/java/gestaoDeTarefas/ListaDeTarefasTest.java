package gestaoDeTarefas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDeTarefasTest {
    private ListaDeTarefas tarefas;

    @BeforeEach
    public void iniciar() {
        tarefas = new ListaDeTarefas();
        // Realiza a adição do novo item inicalmete para todas os teste
        tarefas.adicionarTarefa("Fazer exercicio");

    }

    @Test
    @DisplayName("Adicionar Tarefa na lista")
    void adicionarTarefa() {
// Adicionar itens a lista de tarefa
        boolean add01 = tarefas.adicionarTarefa("Ir a academia");
        boolean add02 = tarefas.adicionarTarefa("GoDev");
        // Verifica se foi adicionado
        assertTrue(add01);
        assertTrue(add02);
        // mais uma verificação se foi adicionado e somado o ID
        assertEquals(3, tarefas.obterQuantidaDeTarefas());
    }

    @Test
    @DisplayName("Adicionar Tarefa ja existente")
    void adicionarTarefaExistente() {
        // Adicionar itens a lista de tarefa
        boolean add01 = tarefas.adicionarTarefa("Fazer exercicio ");
        // Verifica se foi adicionado
        assertTrue(add01);
        // Verifica a quantodade de itens na lista.
        // não funcionou =(
        assertEquals(1, tarefas.obterQuantidaDeTarefas());
    }

    @Test
    @DisplayName("Busca tarefa por ID na lista")
    void buscarTarefaporId() {
        // Busca pelo id da tarefea
        Tarefa tarefa = tarefas.buscarTarefaporId(0);
        // verifica se existe e devolve a tarefa
        assertEquals("Fazer exercicio", tarefa.getDescricao());

    }
    @Test
    @DisplayName("Busca tarefa por ID inexistente")
    void buscarTarefaporIdInexistente() {
        // busca pelo ID que nao existe
        Tarefa tarefa = tarefas.buscarTarefaporId(8);
        // valida se o id existe
        assertNull(tarefa);
    }

    @Test
    @DisplayName("Marca a tarefa com concluida")
    void marcarTarefaComoConcluida() {
        Tarefa tarefaconcluida = tarefas.buscarTarefaporId(0);
        assertNotNull(tarefaconcluida);
        tarefas.marcarTarefaComoConcluida(0);
        assertTrue(tarefaconcluida.estaConcluida());
    }

    @Test
    @DisplayName("Remove a tarefa da lista")
    void removerTarefa() {
        Tarefa tarefa = tarefas.buscarTarefaporId(0);
        assertEquals("Fazer exercicio", tarefa.getDescricao());
        tarefas.removerTarefa(0);
        tarefas.buscarTarefaporId(0);
        assertEquals("Fazer exercicio", tarefa.getDescricao());

    }

    @Test
    @DisplayName("Obtem quantidade de tarefas na lista")
    void obterQuantidaDeTarefas() {
        int qtdtarefas = tarefas.obterQuantidaDeTarefas();
        assertEquals(1, qtdtarefas);


    }
}