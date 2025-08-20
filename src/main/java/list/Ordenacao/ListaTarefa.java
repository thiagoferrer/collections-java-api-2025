package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    //Atributo
    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    //Adicionar...
    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    //Remover...
    public void removerTarefa(String descricao) {
        List<Tarefa> tarefaParaRemover = new ArrayList<>();
        for (Tarefa t : tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover.add(t);
            }
        }
        tarefaList.removeAll(tarefaParaRemover);
    }

    //Obter nº total de tarefa.
    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    //Obter descrição de tarefa.
    public void obterDescricoesTarefas() {
        System.out.println(tarefaList);
    }

    //Main....
    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 3");
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();

    }
}
