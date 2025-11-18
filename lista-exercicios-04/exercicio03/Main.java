import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Carlos", new BigDecimal("8000")));
        funcionarios.add(new Desenvolvedor("Ana", new BigDecimal("5000")));
        funcionarios.add(new Desenvolvedor("Marcos", new BigDecimal("6500")));

        for (Funcionario f : funcionarios) {
            System.out.println("Funcionário: " + f.getNome());
            System.out.println("Salário: R$ " + f.getSalario());
            System.out.println("Bônus: R$ " + f.calcularBonus());
            System.out.println("---------------------------");
        }
    }
}
