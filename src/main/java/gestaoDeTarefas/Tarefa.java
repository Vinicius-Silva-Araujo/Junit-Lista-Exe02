package gestaoDeTarefas;

public class Tarefa {
    private int id;
    private String descricao;
    private boolean concluida;
    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = false;
    }
    public void marcarComoConcluido(){
        this.concluida = true;
    }
    public boolean estaConcluida(){
        return concluida ;
    }

    public int getId() {
        return id;
    }
    public String getDescricao(){
        return descricao;
    }





    public String toString(){
        return "Tarefa "+ id + ":"+ descricao + "(Concluida: "+concluida+")";
    }


}
