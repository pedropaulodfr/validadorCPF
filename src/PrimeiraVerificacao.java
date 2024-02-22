import java.util.Arrays;

public class PrimeiraVerificacao extends Verificacoes {
    @Override
    public boolean validar (String cpf) {
        Integer soma;
        Integer restoDivisao;
        Integer digitoVerificador =  Character.getNumericValue(cpf.charAt(cpf.length() - 2));
        int[] multiplicacoes = new int[9];
        int[] operadores = {10, 9, 8, 7, 6, 5, 4, 3, 2};

        // Multiplicar cada dígito do CPF pelos valores decrescentes de 10 até 2
        for (int i = 0; i < cpf.length() - 2; i++) {
            multiplicacoes[i] = (operadores[i] * Character.getNumericValue(cpf.charAt(i)));
        }

        // Somar o resultado de todas as multiplicações
        soma = Arrays.stream(multiplicacoes).sum();

        // Dividir o resultado da soma por 11 e pegar o resto da divisão
        restoDivisao = soma % 11;

        if (restoDivisao <= 1 && digitoVerificador == 0)
            return true;
        else return restoDivisao > 2 && digitoVerificador == (11 - restoDivisao);
    }
}
