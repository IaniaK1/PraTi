import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {

    private final List<ItemCarrinho> itens;
    private final BigDecimal percentualDesconto;

    public Carrinho(List<ItemCarrinho> itens, BigDecimal percentualDesconto) {
        if (itens == null) {
            throw new IllegalArgumentException("Lista de itens não pode ser nula.");
        }
        if (percentualDesconto == null) {
            percentualDesconto = BigDecimal.ZERO;
        }
        if (percentualDesconto.compareTo(BigDecimal.ZERO) < 0 ||
                percentualDesconto.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("Percentual de desconto deve estar entre 0% e 30%.");
        }

        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.percentualDesconto = percentualDesconto;
    }

    public static Carrinho vazio() {
        return new Carrinho(Collections.emptyList(), BigDecimal.ZERO);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        ItemCarrinho novoItem = new ItemCarrinho(produto, quantidade);
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.add(novoItem);
        return new Carrinho(novaLista, this.percentualDesconto);
    }

    public Carrinho removerProduto(Produto produto) {
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : this.itens) {
            if (!item.getProduto().equals(produto)) {
                novaLista.add(item);
            }
        }
        return new Carrinho(novaLista, this.percentualDesconto);
    }

    public Carrinho aplicarCupom(BigDecimal percentual) {
        if (percentual == null) {
            throw new IllegalArgumentException("Percentual de cupom não pode ser nulo.");
        }
        if (percentual.compareTo(BigDecimal.ZERO) < 0 ||
                percentual.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("Cupom deve ser entre 0% e 30%.");
        }
        return new Carrinho(this.itens, percentual);
    }

    public Dinheiro getTotal() {
        if (itens.isEmpty()) {
            return new Dinheiro(BigDecimal.ZERO, Moeda.BRL);
        }

        Dinheiro total = itens.get(0).getSubtotal();
        for (int i = 1; i < itens.size(); i++) {
            total = total.somar(itens.get(i).getSubtotal());
        }

        if (percentualDesconto.compareTo(BigDecimal.ZERO) > 0) {
            Dinheiro desconto = total.percentual(percentualDesconto);
            total = total.subtrair(desconto);
        }

        return total;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "itens=" + itens +
                ", percentualDesconto=" + percentualDesconto +
                ", total=" + getTotal() +
                '}';
    }
}
