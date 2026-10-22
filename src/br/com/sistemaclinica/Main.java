
package br.com.sistemaclinica;

import br.com.sistemaclinica.model.Agendamento;
import br.com.sistemaclinica.model.Paciente;
import br.com.sistemaclinica.repository.AgendamentoRepositoryMemoria;
import br.com.sistemaclinica.service.AgendamentoService;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        AgendamentoRepositoryMemoria repository =
                new AgendamentoRepositoryMemoria();

        AgendamentoService service =
                new AgendamentoService(repository);

        Paciente paciente = new Paciente(
                "Maria Silva",
                "12345678900",
                "71999999999",
                30
        );

        Agendamento agendamento = new Agendamento(
                paciente,
                LocalDate.now().plusDays(1),
                LocalTime.of(14, 0),
                "Consulta de rotina"
        );

        service.cadastrar(agendamento);

        System.out.println("Agendamento cadastrado com sucesso!");
        System.out.println("Paciente: "
                + agendamento.getPaciente().getNome());
        System.out.println("Data: " + agendamento.getData());
        System.out.println("Horário: " + agendamento.getHorario());
        System.out.println("Motivo: " + agendamento.getMotivo());

        System.out.println("\nTotal de agendamentos: "
                + service.listar().size());
        
        
        System.out.println("\nTeste de validação:");

        try {
            Agendamento invalido = new Agendamento(
                    null,
                    LocalDate.now().plusDays(1),
                    LocalTime.of(15, 0),
                    "Consulta de teste"
            );

            service.cadastrar(invalido);

            System.out.println("ERRO: o agendamento inválido foi aceito.");

        } catch (IllegalArgumentException e) {
            System.out.println("Teste aprovado: " + e.getMessage());
        }

        
        System.out.println("\nTeste de motivo vazio:");

        try {
            Paciente pacienteTeste = new Paciente(
                    "João Silva",
                    "98765432100",
                    "71988888888",
                    25
            );

            Agendamento invalido = new Agendamento(
                    pacienteTeste,
                    LocalDate.now().plusDays(1),
                    LocalTime.of(16, 0),
                    " "
            );

            service.cadastrar(invalido);

            System.out.println("ERRO: o motivo vazio foi aceito.");

        } catch (IllegalArgumentException e) {
            System.out.println("Teste aprovado: " + e.getMessage());
        }

    }
    
}
