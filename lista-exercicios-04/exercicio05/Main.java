import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<FormaPagamento> formas = new ArrayList<>();

        formas.add(new CartaoCredito("1234567812345678", "Bernardo"));
        formas.add(new Boleto("23793381286000000012345678901234567890123456"));
        formas.add(new Pix("bernardo@ianiak.com"));

        formas.add(new CartaoCredito("1234", "Titular inválido"));
        formas.add(new Boleto("123"));
        formas.add(new Pix("a"));

        BigDecimal valor = new BigDecimal("150.00");

        for (FormaPagamento forma : formas) {

            System.out.println("Processando: " + forma.getClass().getSimpleName());

            try {
                forma.validarPagamento();
                forma.processarPagamento(valor);
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro de validação: " + e.getMessage());
            }

            System.out.println("-----------------------------------");
        }
    }
}
