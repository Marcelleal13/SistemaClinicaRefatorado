
package br.com.sistemaclinica.repository;

import br.com.sistemaclinica.model.Agendamento;
import java.util.List;

public interface AgendamentoRepository {

    void salvar(Agendamento agendamento);

    List<Agendamento> listarTodos();
}
