import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        CalculadoraFrete sedex = new Sedex();
        CalculadoraFrete pac = new Pac();
        CalculadoraFrete retirada = new RetiradaNaLoja();

        Pedido pedido = new Pedido("90000000", new BigDecimal("250.00"), sedex);

        try {
            System.out.println("Frete com SEDEX: R$ " + pedido.calcularFrete());
        } catch (CepInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        pedido.setEstrategiaFrete(pac);
        try {
            System.out.println("Frete com PAC: R$ " + pedido.calcularFrete());
        } catch (CepInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        pedido.setEstrategiaFrete(retirada);
        System.out.println("Frete com Retirada na Loja: R$ " + pedido.calcularFrete());


        BigDecimal valorMinimoFreteGratis = new BigDecimal("200.00");

        CalculadoraFrete fretePromocional = (p) -> {
            String cep = p.getCepDestino();

            if (cep == null || !cep.matches("\\d{8}")) {
                throw new CepInvalidoException("CEP inválido na promoção: " + cep);
            }

            if (p.getValorProdutos().compareTo(valorMinimoFreteGratis) >= 0) {
                return BigDecimal.ZERO;
            } else {
                return new BigDecimal("15.00");
            }
        };

        pedido.setEstrategiaFrete(fretePromocional);
        System.out.println("Frete PROMOCIONAL: R$ " + pedido.calcularFrete());

        Pedido pedidoCepInvalido = new Pedido("ABC123", new BigDecimal("300.00"), fretePromocional);
        try {
            System.out.println("Frete com CEP inválido: R$ " + pedidoCepInvalido.calcularFrete());
        } catch (CepInvalidoException e) {
            System.out.println("Erro ao calcular frete com CEP inválido: " + e.getMessage());
        }
    }
}
