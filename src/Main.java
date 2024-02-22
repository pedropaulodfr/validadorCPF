import java.util.Scanner;

/*
Regras da validação
https://www.dio.me/articles/como-fazer-uma-validacao-de-cpf-com-python
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF: ");

        // Remover pontos e barra do CPF
        String cpf = scanner.nextLine().replace(".", "").replace("-", "");

        EntradaVerificacao ev = new EntradaVerificacao();
        if (!ev.validar(cpf))
            return;

        PrimeiraVerificacao pv = new PrimeiraVerificacao();
        SegundaVerificacao sv = new SegundaVerificacao();

        if (pv.validar(cpf) && sv.validar(cpf))
        {
            System.out.println("CPF VÁLIDO!!!");
        }
        else
        {
            System.out.println("CPF INVÁLIDO!!!");
        }
    }
}