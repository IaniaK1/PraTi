import java.math.BigDecimal;

public class Pix extends FormaPagamento {

    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (chave == null || chave.trim().length() < 5) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PagamentoInvalidoException("Valor do pagamento Pix deve ser positivo.");
        }

        System.out.println("Pagamento de R$ " + valor + " processado via Pix (chave: " + chave + ").");
    }
}
