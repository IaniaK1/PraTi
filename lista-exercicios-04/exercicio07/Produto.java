public class Produto implements Identificavel<Long> {

    private final Long id;
    private final String nome;

    public Produto(Long id, String nome) {
        if (id == null) {
            throw new IllegalArgumentException("ID do produto não pode ser nulo.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
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
        return "Produto{id=" + id + ", nome='" + nome + "'}";
    }
}
