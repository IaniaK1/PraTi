public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto("Mouse Gamer", 150.0, 10);
        System.out.println(p1);

        p1.setPreco(199.90);
        p1.setQuantidadeEmEstoque(15);
        System.out.println("Após atualizações: " + p1);

        try {
            p1.setPreco(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao alterar preço: " + e.getMessage());
        }

        try {
            p1.setNome("");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao alterar nome: " + e.getMessage());
        }

        try {
            Produto p2 = new Produto(null, 50, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }
    }
}
