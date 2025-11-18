import java.math.BigDecimal;

public class Boleto extends FormaPagamento {

    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (codigoBarras == null || !codigoBarras.matches("\\d{47}|\\d{48}")) {
            throw new PagamentoInvalidoException("Código de barras do boleto deve ter 47 ou 48 dígitos numéricos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PagamentoInvalidoException("Valor do boleto deve ser positivo.");
        }

        System.out.println("Pagamento de R$ " + valor + " processado via boleto (" + codigoBarras + ").");
    }
}
