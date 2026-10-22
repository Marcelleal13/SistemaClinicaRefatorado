
package br.com.sistemaclinica.repository;

import br.com.sistemaclinica.model.Agendamento;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepositoryMemoria
        implements AgendamentoRepository {

    private final List<Agendamento> agendamentos =
            new ArrayList<>();

    @Override
    public void salvar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    @Override
    public List<Agendamento> listarTodos() {
        return new ArrayList<>(agendamentos);
    }
}
