import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {

    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo.");
        }
        if (moeda == null) {
            throw new IllegalArgumentException("Moeda não pode ser nula.");
        }
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor monetário não pode ser negativo.");
        }

        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public Dinheiro somar(Dinheiro outro) {
        validarMesmaMoeda(outro);
        return new Dinheiro(this.valor.add(outro.valor), this.moeda);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        validarMesmaMoeda(outro);
        BigDecimal resultado = this.valor.subtract(outro.valor);
        if (resultado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Resultado monetário não pode ser negativo.");
        }
        return new Dinheiro(resultado, this.moeda);
    }

    public Dinheiro multiplicarPorQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        BigDecimal resultado = this.valor.multiply(BigDecimal.valueOf(quantidade));
        return new Dinheiro(resultado, this.moeda);
    }

    public Dinheiro percentual(BigDecimal percentual) {
        if (percentual == null) {
            throw new IllegalArgumentException("Percentual não pode ser nulo.");
        }
        BigDecimal resultado = this.valor
                .multiply(percentual)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);
        return new Dinheiro(resultado, this.moeda);
    }

    private void validarMesmaMoeda(Dinheiro outro) {
        if (!this.moeda.equals(outro.moeda)) {
            throw new IllegalArgumentException("Moedas diferentes não podem ser somadas/subtraídas.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinheiro)) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return this.moeda == dinheiro.moeda &&
                this.valor.stripTrailingZeros().equals(dinheiro.valor.stripTrailingZeros());
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor.stripTrailingZeros(), moeda);
    }

    @Override
    public String toString() {
        return moeda + " " + valor;
    }
}
