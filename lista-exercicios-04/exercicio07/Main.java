import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        IRepository<Produto, Long> repoProdutos = new InMemoryRepository<>();
        IRepository<Funcionario, Long> repoFuncionarios = new InMemoryRepository<>();

        repoProdutos.salvar(new Produto(1L, "Mouse"));
        repoProdutos.salvar(new Produto(2L, "Teclado"));

        repoFuncionarios.salvar(new Funcionario(1L, "Ana"));
        repoFuncionarios.salvar(new Funcionario(2L, "Carlos"));

        System.out.println("=== Produtos ===");
        List<Produto> produtos = repoProdutos.listarTodos();
        produtos.forEach(System.out::println);

        System.out.println("\n=== Funcionários ===");
        List<Funcionario> funcionarios = repoFuncionarios.listarTodos();
        funcionarios.forEach(System.out::println);

        System.out.println("\nBuscando produto ID 1:");
        Optional<Produto> produtoOpt = repoProdutos.buscarPorId(1L);
        produtoOpt.ifPresent(System.out::println);

        System.out.println("\nRemovendo funcionário ID 1:");
        repoFuncionarios.remover(1L);
        repoFuncionarios.listarTodos().forEach(System.out::println);

        System.out.println("\nTentando remover produto ID 999 (inexistente):");
        try {
            repoProdutos.remover(999L);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
