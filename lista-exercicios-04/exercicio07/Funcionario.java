public class Funcionario implements Identificavel<Long> {

    private final Long id;
    private final String nome;

    public Funcionario(Long id, String nome) {
        if (id == null) {
            throw new IllegalArgumentException("ID do funcionário não pode ser nulo.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário não pode ser nulo ou vazio.");
        }
        this.id = id;
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Funcionario{id=" + id + ", nome='" + nome + "'}";
    }
}
