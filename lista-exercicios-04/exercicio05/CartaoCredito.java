import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {

    private String numeroCartao;
    private String nomeTitular;

    public CartaoCredito(String numeroCartao, String nomeTitular) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Nome do titular do cartão é inválido.");
        }

        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            throw new PagamentoInvalidoException("Número do cartão de crédito deve ter 16 dígitos numéricos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PagamentoInvalidoException("Valor do pagamento com cartão deve ser positivo.");
        }

        System.out.println("Pagamento de R$ " + valor + " processado no cartão de crédito (" + nomeTitular + ").");
    }
}
