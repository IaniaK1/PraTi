public class Carro implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private final int velocidadeMaxima = 180;

    @Override
    public void acelerar() throws Exception {
        if (velocidadeAtual + 10 > velocidadeMaxima) {
            throw new Exception("Carro: velocidade máxima atingida!");
        }
        velocidadeAtual += 10;
        System.out.println("Carro acelerou. Velocidade: " + velocidadeAtual);
    }

    @Override
    public void frear() throws Exception {
        if (velocidadeAtual - 10 < 0) {
            throw new Exception("Carro: velocidade não pode ser negativa!");
        }
        velocidadeAtual -= 10;
        System.out.println("Carro freou. Velocidade: " + velocidadeAtual);
    }
}
