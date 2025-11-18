import java.util.*;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {

    private final Map<ID, T> armazenamento = new HashMap<>();

    @Override
    public T salvar(T entidade) {
        if (entidade == null) {
            throw new IllegalArgumentException("Entidade não pode ser nula.");
        }
        ID id = entidade.getId();
        if (id == null) {
            throw new IllegalArgumentException("ID da entidade não pode ser nulo.");
        }
        armazenamento.put(id, entidade);
        return entidade;
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(armazenamento.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(armazenamento.values()));
    }

    @Override
    public void remover(ID id) throws EntidadeNaoEncontradaException {
        if (!armazenamento.containsKey(id)) {
            throw new EntidadeNaoEncontradaException("Entidade com ID " + id + " não encontrada.");
        }
        armazenamento.remove(id);
    }
}
