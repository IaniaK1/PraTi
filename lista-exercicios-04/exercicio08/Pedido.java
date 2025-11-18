import java.math.BigDecimal;

public class Pedido {

    private String cepDestino;
    private BigDecimal valorProdutos;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String cepDestino, BigDecimal valorProdutos, CalculadoraFrete estrategiaFrete) {
        if (cepDestino == null || cepDestino.trim().isEmpty()) {
            throw new IllegalArgumentException("CEP não pode ser nulo ou vazio.");
        }
        if (valorProdutos == null || valorProdutos.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor dos produtos não pode ser negativo.");
        }
        this.cepDestino = cepDestino;
        this.valorProdutos = valorProdutos;
        this.estrategiaFrete = estrategiaFrete;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public BigDecimal getValorProdutos() {
        return valorProdutos;
    }

    public CalculadoraFrete getEstrategiaFrete() {
        return estrategiaFrete;
    }

    public void setEstrategiaFrete(CalculadoraFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() {
        if (estrategiaFrete == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete definida.");
        }
        return estrategiaFrete.calcular(this);
    }
}
