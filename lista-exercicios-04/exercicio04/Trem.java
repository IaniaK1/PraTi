public class Trem implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private final int velocidadeMaxima = 300;

    @Override
    public void acelerar() throws Exception {
        if (velocidadeAtual + 20 > velocidadeMaxima) {
            throw new Exception("Trem: velocidade máxima atingida!");
        }
        velocidadeAtual += 20;
        System.out.println("Trem acelerou. Velocidade: " + velocidadeAtual);
    }

    @Override
    public void frear() throws Exception {
        if (velocidadeAtual - 5 < 0) {
            throw new Exception("Trem: velocidade não pode ser negativa!");
        }
        velocidadeAtual -= 5;
        System.out.println("Trem freou. Velocidade: " + velocidadeAtual);
    }
}
