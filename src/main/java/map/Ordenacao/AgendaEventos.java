package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    //adicionar
    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, new Evento(nome, atracao));
    }

    //exibir
    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);

    }

    //obter
    public void obterProximoEvento() {
        /*Set<LocalDate> dateSet = eventosMap.keySet();
        Collection<Evento> values = eventosMap.values();*/
        //eventosMap.get();

        LocalDate dataAtual = LocalDate.now();
        LocalDate proximoData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximoData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximoData);
                break;
            }
        }
    }

    //main===============
    static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 01", "Atração 01");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 02", "Atração 02");
        agendaEventos.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 10), "Evento 03", "Atração 03");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 10, 10), "Evento 04", "Atração 04");
        agendaEventos.adicionarEvento(LocalDate.of(2026, 10, 11), "Evento 05", "Atração 05");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();

    }
}
