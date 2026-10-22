
package br.com.sistemaclinica.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {

    private Paciente paciente;
    private LocalDate data;
    private LocalTime horario;
    private String motivo;

    public Agendamento(Paciente paciente, LocalDate data,
                       LocalTime horario, String motivo) {
        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getMotivo() {
        return motivo;
    }
}
