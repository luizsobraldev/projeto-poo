import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Testar a parte da Clínica Médica
        Clinica clinica = new Clinica();

        Medico medico1 = new Medico("Dr. José", "Cardiologia");
        Paciente paciente1 = new Paciente(1, "Maria Silva", "1993-05-15", "11122233344", "Rua A, 123", "123456789");
        clinica.cadastrarMedico(medico1);
        clinica.cadastrarPaciente(paciente1);

        System.out.println("Agendando consulta...");
        clinica.agendarConsulta(paciente1, medico1, "2024-10-20", "15:00");

        // Testar a parte de Evento
        Local local = new Local(100, 150.0, "Auditório Principal", "Rua 123");
        Evento evento = new Evento("Congresso de Medicina", new Date(), local, 100);
        Participante participante = new Participante("Inscrição123", "98765432100");
        evento.adicionarParticipante(participante);
        evento.cadastrarEvento(evento);

        // Testar a parte de Restaurante
        Restaurante restaurante = new Restaurante(10000.0, 20);
        ItemDoPedido item1 = new ItemDoPedido("Pizza", 30.0, 0.5, "Sem cebola");
        Pedido pedido = new Pedido("João", 1, new ArrayList<>());
        pedido.adicionarItem(item1);
        restaurante.adicionarVenda(pedido.calcularTotal());
        restaurante.registrarVenda();

        System.out.println("Venda registrada no restaurante.");
    }
}
