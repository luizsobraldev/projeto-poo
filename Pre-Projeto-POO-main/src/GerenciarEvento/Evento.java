import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Evento {
    private String nome;
    private Date data;
    private Local local;
    private int limiteInscrições;
    private List<Participante> participantes;
    private List<Evento> eventos = new ArrayList<>();  // Lista de eventos com ArrayList

    public Evento(String nome, Date data, Local local, int limiteInscrições) {
        // Validação de dados no construtor
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (local == null) {
            throw new IllegalArgumentException("Local não pode ser nulo");
        }
        if (limiteInscrições <= 0) {
            throw new IllegalArgumentException("Limite de inscrições deve ser maior que 0");
        }

        this.nome = nome;
        this.data = data;
        this.local = local;
        this.limiteInscrições = limiteInscrições;
        participantes = new ArrayList<>();  // Aqui é a inicialização correta
    }

    // Getters e Setters com validação
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        if(local == null) throw new IllegalArgumentException("Local não pode ser nulo");
        this.local = local;
    }

    public int getLimiteInscrições() {
        return limiteInscrições;
    }

    public void setLimiteInscrições(int limiteInscrições) {
        if(limiteInscrições <= 0) throw new IllegalArgumentException("Limite deve ser maior que 0");
        this.limiteInscrições = limiteInscrições;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    // Adicionar um participante com validação de limite
    public void adicionarParticipante(Participante novoParticipante) {
        if(participantes.size() >= limiteInscrições){
            System.out.println("O evento atingiu a capacidade máxima");
        } else {
            participantes.add(novoParticipante);
        }
    }

    // Verificar se o evento está lotado
    public boolean lotaçãoEvento() {
        return participantes.size() >= limiteInscrições;
    }

    // Relatório dos participantes
    public void relatórioEvento() {
        if(!participantes.isEmpty()) {
            for (Participante p : participantes) {
                System.out.println(p.getInscricao() + " - " + p.getCpf());
            }
        } else {
            System.out.println("Nenhum participante inscrito.");
        }
    }

    public void cadastrarEvento(Evento evento) {
        // Verificar se o evento já está cadastrado pelo nome
        for (Evento e : eventos) {
            if (e.getNome().equals(evento.getNome())) {
                System.out.println("Evento já cadastrado.");
                return;
            }
        }
        eventos.add(evento);
        System.out.println("Evento " + evento.getNome() + " cadastrado com sucesso.");
    }
}
