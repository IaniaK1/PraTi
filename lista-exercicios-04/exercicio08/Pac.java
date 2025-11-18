import java.math.BigDecimal;

public class Pac implements CalculadoraFrete {

    @Override
    public BigDecimal calcular(Pedido pedido) throws CepInvalidoException {
        String cep = pedido.getCepDestino();

        if (cep == null || !cep.matches("\\d{8}")) {
            throw new CepInvalidoException("CEP inválido para PAC: " + cep);
        }

        return new BigDecimal("20.00");
    }
}
