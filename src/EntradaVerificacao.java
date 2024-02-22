import java.math.BigInteger;

public class EntradaVerificacao extends Verificacoes {
    @Override
    public boolean validar(String cpf){
        // Verificar se o CPF contém apenas números
        try
        {
            new BigInteger(cpf);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Entrada inválida!\n" + e);
            return false;
        };

        // Verificar se o CPF contém 11 dígitos
        if (cpf.length() != 11)
        {
            System.out.println("O número não parece ser um CPF");
            return false;
        }

        return true;
    }
}
