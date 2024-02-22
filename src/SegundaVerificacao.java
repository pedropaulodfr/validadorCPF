import java.util.Arrays;

public class SegundaVerificacao extends Verificacoes {
    @Override
    public boolean validar(String cpf){
        Integer soma;
        Integer restoDivisao;
        Integer ultimoDigitoVerificador =  Character.getNumericValue(cpf.charAt(cpf.length() - 1));
        int[] multiplicacoes = new int[10];
        int[] operadores = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        // Multiplicar cada dígito do CPF pelos valores decrescentes de 11 até 2
        for (int i = 0; i < cpf.length() - 1; i++) {
            multiplicacoes[i] = (operadores[i] * Character.getNumericValue(cpf.charAt(i)));
        }

        // Somar o resultado de todas as multiplicações
        soma = Arrays.stream(multiplicacoes).sum();

        // Dividir o resultado da soma por 11 e pegar o resto da divisão
        restoDivisao = soma % 11;

        if (restoDivisao <= 1 && ultimoDigitoVerificador == 0)
        {return true;}
        else if (restoDivisao >= 2)
        {
            Integer diferenca = 11 - restoDivisao;
            return diferenca.equals(ultimoDigitoVerificador);
        }
        else
        {return false;}
    }
}
