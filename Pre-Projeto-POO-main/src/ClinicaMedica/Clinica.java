import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Clinica {

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;
    private int proximoIdPaciente;

    public Clinica() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        consultas = new ArrayList<>();
        proximoIdPaciente = 1;
    }

    public void cadastrarPaciente(Paciente paciente) {
        if (buscarPacientePorCPF(paciente.getCpf()) == null) {  // Verifica se o paciente já existe
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

    public Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public Medico buscarMedicoPorNome(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equals(nome)) {
                return medico;
            }
        }
        return null;
    }

    public int getProximoIdPaciente() {
        return proximoIdPaciente++;
    }
}
