import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Dinheiro precoMouse = new Dinheiro(new BigDecimal("100.00"), Moeda.BRL);
        Dinheiro precoTeclado = new Dinheiro(new BigDecimal("150.00"), Moeda.BRL);

        Produto mouse = new Produto("Mouse Gamer", precoMouse);
        Produto teclado = new Produto("Teclado Mecânico", precoTeclado);

        Carrinho carrinho = Carrinho.vazio();

        carrinho = carrinho.adicionarItem(mouse, 2);
        carrinho = carrinho.adicionarItem(teclado, 1);

        System.out.println("Carrinho inicial:");
        System.out.println(carrinho);
        System.out.println("Total sem desconto: " + carrinho.getTotal());

        carrinho = carrinho.aplicarCupom(new BigDecimal("10"));
        System.out.println("\nCarrinho com 10% de desconto:");
        System.out.println(carrinho);
        System.out.println("Total com desconto: " + carrinho.getTotal());

        try {
            carrinho = carrinho.aplicarCupom(new BigDecimal("50"));
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro ao aplicar cupom: " + e.getMessage());
        }

        try {
            carrinho.adicionarItem(mouse, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }
}
