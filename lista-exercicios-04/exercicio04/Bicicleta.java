public class Bicicleta implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private final int velocidadeMaxima = 40;

    @Override
    public void acelerar() throws Exception {
        if (velocidadeAtual + 2 > velocidadeMaxima) {
            throw new Exception("Bicicleta: velocidade máxima atingida!");
        }
        velocidadeAtual += 2;
        System.out.println("Bicicleta acelerou. Velocidade: " + velocidadeAtual);
    }

    @Override
    public void frear() throws Exception {
        if (velocidadeAtual - 2 < 0) {
            throw new Exception("Bicicleta: velocidade não pode ser negativa!");
        }
        velocidadeAtual -= 2;
        System.out.println("Bicicleta freou. Velocidade: " + velocidadeAtual);
    }
}
