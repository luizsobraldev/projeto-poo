import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Clinica {

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Clinica() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente paciente) {
        if (buscarPaciente(paciente.getCpf()) == null) {  // Verifica se o paciente já existe
            pacientes.add(paciente);
            System.out.println("Paciente cadastrado com sucesso.");
        } else {
            System.out.println("Paciente com CPF " + paciente.getCpf() + " já está cadastrado.");
        }
    }

    public void cadastrarMedico(Medico medico) {
        for (Medico m : medicos) {
            if (m.getNome().equals(medico.getNome())) {  // Verifica se já existe um médico com o mesmo nome
                System.out.println("Médico já cadastrado.");
                return;
            }
        }
        medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso.");
    }

    public void agendarConsulta(Paciente paciente, Medico medico, String data, String hora) {
        if (verificarDisponibilidade(medico, data, hora)) {
            Consulta novaConsulta = new Consulta(paciente, medico, data, hora);
            consultas.add(novaConsulta);
            System.out.println("Consulta agendada para " + data);
        } else {
            System.out.println("Não foi possível agendar a consulta.");
        }
    }

    public List<Consulta> gerarRelatorioConsultas(String dataInicio, String dataFim) {
        List<Consulta> consultasRelatorio = new ArrayList<>();

        for (Consulta consulta : consultas) {
            if (consultaDentroDoIntervalo(consulta, dataInicio, dataFim)) {
                consultasRelatorio.add(consulta);
            }
        }

        return consultasRelatorio;
    }

    private boolean verificarDisponibilidade(Medico medico, String data, String hora) {
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) && consulta.getData().equals(data) && consulta.getHora().equals(hora)) {
                return false;
            }
        }
        return true;
    }

    public Paciente buscarPaciente(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    // Método adicionado
    private boolean consultaDentroDoIntervalo(Consulta consulta, String dataInicio, String dataFim) {
        // Converte as strings de data em objetos Date para comparar
        Date dataConsulta = new Date(consulta.getData());  // Supondo que getData() retorne uma String que pode ser convertida para Date
        Date inicio = new Date(dataInicio);  // Converta a string dataInicio para Date
        Date fim = new Date(dataFim);  // Converta a string dataFim para Date

        // Verifica se a data da consulta está entre a data de início e a data final
        return !dataConsulta.before(inicio) && !dataConsulta.after(fim);
    }
}
