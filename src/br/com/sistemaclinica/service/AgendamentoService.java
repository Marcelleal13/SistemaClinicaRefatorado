
package br.com.sistemaclinica.service;

import br.com.sistemaclinica.model.Agendamento;
import br.com.sistemaclinica.repository.AgendamentoRepository;
import java.util.List;

public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Agendamento agendamento) {

        if (agendamento == null) {
            throw new IllegalArgumentException(
                    "O agendamento não pode ser nulo.");
        }

        if (agendamento.getPaciente() == null) {
            throw new IllegalArgumentException(
                    "Informe o paciente.");
        }

        if (agendamento.getData() == null) {
            throw new IllegalArgumentException(
                    "Informe a data do agendamento.");
        }

        if (agendamento.getHorario() == null) {
            throw new IllegalArgumentException(
                    "Informe o horário do agendamento.");
        }

        if (agendamento.getMotivo() == null
                || agendamento.getMotivo().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Informe o motivo da consulta.");
        }

        repository.salvar(agendamento);
    }

    public List<Agendamento> listar() {
        return repository.listarTodos();
    }
}
