import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<IMeioTransporte> meios = new ArrayList<>();

        meios.add(new Carro());
        meios.add(new Bicicleta());
        meios.add(new Trem());

        for (IMeioTransporte m : meios) {

            try {
                m.acelerar();
                m.acelerar();
                m.frear();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.println("----------------------------");
        }
    }
}
