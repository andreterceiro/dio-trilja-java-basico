import java.text.DecimalFormat;
import java.util.Scanner;

public class ContaTerminal {
    private static int numeroConta;
    private static String agencia;
    private static String nomeCliente;
    private static Double saldo;
    /**
     * Construtor. Permite configurar as informações iniciais, que são solicitadas
     * na tela (não é necessário passar ao invocar o programa)
     * 
     * @param args Argumentos que forem passados na CLI. Não são usados.     * 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        // Obtendo o número da conta e salvando em uma variável estátitca
        while (true) {
            try {
                System.out.print( "Insira por favor o número da conta: ");
                setNumeroConta(scanner.nextInt());
                break;
            } catch (Exception e) {
                scanner.next();
            }
        }

        // Obtendo o número da agência e salvando em uma variável estátitca
        System.out.print("Insira por favor o número da agência: ");
        setAgencia(scanner.next());

        // Obtendo o nome do cliente e salvando em uma variável estátitca
        System.out.print("Insira por favor o nome do cliente: ");
        setNomeCliente(scanner.next());
        
        // Obtendo o saldo do cliente e salvando em uma variável estátitca
        while (true) {
            try {
                System.out.print("Insira por favor o saldo do cliente, separando os decimais com uma vírgula: ");
                setSaldo(scanner.nextDouble());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        
        imprimirDadosConta();
    }

    /**
     * Mostra na tela os dados da conta inseridos
     */
    public static void imprimirDadosConta() {
        System.out.println(
            "Olá " + getNomeCliente() +
            ", obrigado por criar uma conta em nosso banco, sua agência é " + getAgencia() + 
            ", conta " + getNumeroConta() + 
            " e seu saldo R$" + getSaldo() + " já está disponível para saque"
        );
    }

    /**
     * Getter de numero
     * 
     * @return numero
     */ 
    public static int getNumeroConta() {
        return numeroConta;
    }

    /**
     * Setter de numeroConta
     * 
     * @param _numeroconta Valor a ser configurado
     */ 
    public static void setNumeroConta(int _numeroConta) {
        numeroConta = _numeroConta;
    }

    /**
     * Getter de agencia
     * 
     * @return agencia
     */ 
    public static String getAgencia() {
        return agencia;
    }

    /**
     * Setter de agencia
     * 
     * @param _agencia Valor a ser configurado
     */ 
    public static void setAgencia(String _agencia) {
        agencia = _agencia;
    }

    /**
     * Getter de nomeCliente
     * 
     * @return nomeCliente
     */ 
    public static String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Setter de nomeCliente
     * 
     * @param _nomeCliente Valor a ser configurado
     */ 
    public static void setNomeCliente(String _nomeCliente) {
        nomeCliente = _nomeCliente;
    }

    /**
     * Getter de saldo
     * 
     * @return saldo
     */ 
    public static String getSaldo() {
        DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
        return (dFormat.format(saldo));
    }

    /**
     * Setter de this.saldo. Somente são consideradas 2 casas decimais, o valor é truncado
     * e não arredondado
     * 
     * @param _saldo Valor a ser configurado
     */ 
    public static void setSaldo(Double _saldo) throws Exception {
        // O saldo deve estar entre 1 e 10.000.000
        if (_saldo < 1 || _saldo > 10000000) {
            throw new Exception("O saldo deve ficar entre 1 e 10.000.000");
        } 
        // Deixando apenas 2 casas decimais
        _saldo = ((int) (_saldo * 100.0))/100.0;
        saldo = _saldo;
    }   
}