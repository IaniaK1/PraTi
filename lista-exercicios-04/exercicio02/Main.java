public class Main {
    public static void main(String[] args) {

        Produto p = new Produto("Teclado", 200.0, 5);

        System.out.println("Preço antes do desconto: " + p.getPreco());

        p.aplicarDesconto(20);
        System.out.println("Preço após 20% de desconto: " + p.getPreco());

        try {
            p.aplicarDesconto(80);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }

        try {
            p.aplicarDesconto(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }
    }
}
