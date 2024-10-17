import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Clinica clinica = new Clinica();
    private static Evento evento;
    private static Restaurante restaurante = new Restaurante(10000.0, 20);

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Clínica Médica");
            System.out.println("2. Evento");
            System.out.println("3. Restaurante");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    menuClinica();
                    break;
                case 2:
                    menuEvento();
                    break;
                case 3:
                    menuRestaurante();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Programa encerrado.");
    }

    private static void menuClinica() {
        System.out.println("\n--- Menu Clínica Médica ---");
        System.out.println("1. Cadastrar Médico");
        System.out.println("2. Cadastrar Paciente");
        System.out.println("3. Agendar Consulta");
        System.out.println("0. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                cadastrarMedico();
                break;
            case 2:
                cadastrarPaciente();
                break;
            case 3:
                agendarConsulta();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarMedico() {
        System.out.println("Nome do médico:");
        String nome = scanner.nextLine();
        System.out.println("Especialidade:");
        String especialidade = scanner.nextLine();
        Medico medico = new Medico(nome, especialidade);
        clinica.cadastrarMedico(medico);
        System.out.println("Médico cadastrado com sucesso.");
    }

    private static void cadastrarPaciente() {
        System.out.println("Nome do paciente:");
        String nome = scanner.nextLine();
        System.out.println("Data de nascimento (AAAA-MM-DD):");
        String dataNascimento = scanner.nextLine();
        System.out.println("CPF:");
        String cpf = scanner.nextLine();
        System.out.println("Endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Telefone:");
        String telefone = scanner.nextLine();

        Paciente paciente = new Paciente(clinica.getProximoIdPaciente(), nome, dataNascimento, cpf, endereco, telefone);
        clinica.cadastrarPaciente(paciente);
    }

    private static void agendarConsulta() {
        System.out.println("CPF do paciente:");
        String cpfPaciente = scanner.nextLine();
        System.out.println("Nome do médico:");
        String nomeMedico = scanner.nextLine();
        System.out.println("Data da consulta (AAAA-MM-DD):");
        String dataConsulta = scanner.nextLine();
        System.out.println("Hora da consulta (HH:MM):");
        String horaConsulta = scanner.nextLine();

        Paciente paciente = clinica.buscarPacientePorCPF(cpfPaciente);
        Medico medico = clinica.buscarMedicoPorNome(nomeMedico);

        if (paciente != null && medico != null) {
            clinica.agendarConsulta(paciente, medico, dataConsulta, horaConsulta);
        } else {
            System.out.println("Paciente ou médico não encontrado.");
        }
    }

    private static void menuEvento() {
        if (evento == null) {
            criarEvento();
        }

        System.out.println("\n--- Menu Evento ---");
        System.out.println("1. Adicionar Participante");
        System.out.println("2. Mostrar Detalhes do Evento");
        System.out.println("0. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                adicionarParticipante();
                break;
            case 2:
                mostrarDetalhesEvento();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void criarEvento() {
        System.out.println("Nome do evento:");
        String nomeEvento = scanner.nextLine();
        System.out.println("Capacidade do local:");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.println("Preço do ingresso:");
        double precoIngresso = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha
        System.out.println("Nome do local:");
        String nomeLocal = scanner.nextLine();
        System.out.println("Endereço do local:");
        String enderecoLocal = scanner.nextLine();

        Local local = new Local(capacidade, precoIngresso, nomeLocal, enderecoLocal);
        evento = new Evento(nomeEvento, new Date(), local, capacidade);
        evento.cadastrarEvento(evento);
        System.out.println("Evento criado com sucesso.");
    }

    private static void adicionarParticipante() {
        System.out.println("Número de inscrição:");
        String numeroInscricao = scanner.nextLine();
        System.out.println("CPF do participante:");
        String cpfParticipante = scanner.nextLine();

        Participante participante = new Participante(numeroInscricao, cpfParticipante);
        evento.adicionarParticipante(participante);
        System.out.println("Participante adicionado com sucesso.");
    }

    private static void mostrarDetalhesEvento() {
        System.out.println("Detalhes do Evento:");
        System.out.println("Nome: " + evento.getNome());
        System.out.println("Data: " + evento.getData());
        System.out.println("Local: " + evento.getLocal().getNome());
        System.out.println("Capacidade: " + evento.getCapacidade());
        System.out.println("Participantes inscritos: " + evento.getParticipantes().size());
    }

    private static void menuRestaurante() {
        System.out.println("\n--- Menu Restaurante ---");
        System.out.println("1. Fazer Pedido");
        System.out.println("2. Mostrar Total de Vendas");
        System.out.println("0. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                fazerPedido();
                break;
            case 2:
                mostrarTotalVendas();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void fazerPedido() {
        System.out.println("Nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Número da mesa:");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = new Pedido(nomeCliente, numeroMesa, new ArrayList<>());

        boolean adicionandoItens = true;
        while (adicionandoItens) {
            System.out.println("Nome do item (ou 'fim' para finalizar o pedido):");
            String nomeItem = scanner.nextLine();
            if (nomeItem.equalsIgnoreCase("fim")) {
                adicionandoItens = false;
            } else {
                System.out.println("Preço do item:");
                double precoItem = scanner.nextDouble();
                System.out.println("Quantidade:");
                double quantidade = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha
                System.out.println("Observações (ou pressione Enter se não houver):");
                String observacoes = scanner.nextLine();

                ItemDoPedido item = new ItemDoPedido(nomeItem, precoItem, quantidade, observacoes);
                pedido.adicionarItem(item);
            }
        }

        double totalPedido = pedido.calcularTotal();
        restaurante.adicionarVenda(totalPedido);
        restaurante.registrarVenda();
        System.out.println("Pedido registrado. Total: R$" + totalPedido);
    }

    private static void mostrarTotalVendas() {
        System.out.println("Total de vendas: R$" + restaurante.getTotalVendas());
    }
}