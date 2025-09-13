import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static AccountManager instance;

    private Map<String, Double> contas;

    private AccountManager() {
        this.contas = new HashMap<>();
        System.out.println("AccountManager instanciado!");
    }
    
    public static synchronized AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public void cadastrarConta(String contaId) throws Exception {
        if (contas.containsKey(contaId)) {
            throw new Exception(" Não é possivel criar uma conta que já existe");
        }

        contas.put(contaId, 0.0);
        System.out.printf(" Conta cadastrada! Conta: %s\n", contaId);
    }

    public void depositar(String contaId, double valor) throws Exception {
        if (!contas.containsKey(contaId)) {
            throw new Exception("Não é possivel depositar em uma conta inexistente");
        } else if (valor <= 0) {
            throw new Exception("Valor inválido para depósito: R$ " + valor);
        }

        double saldoAtual = contas.get(contaId);
        double novoSaldo = saldoAtual + valor;
        contas.put(contaId, novoSaldo);

        System.out.printf("Depósito realizado! Conta: %s | Valor: R$ %.2f | Saldo atual: R$ %.2f%n",
                contaId, valor, novoSaldo);
    }
    
    public synchronized boolean sacar(String contaId, double valor) throws Exception{
        if (valor <= 0) {
            throw new Exception("Valor inválido para saque: R$ " + valor);

        }
        
        if (!contas.containsKey(contaId)) {
            throw new Exception("Conta não encontrada: " + contaId);
        }
        
        double saldoAtual = contas.get(contaId);
        
        if (saldoAtual < valor) {
           throw new Exception("Saldo insuficiente!");
            
        }
        
        double novoSaldo = saldoAtual - valor;
        contas.put(contaId, novoSaldo);
        
        System.out.printf("Saque realizado! Conta: %s | Valor: R$ %.2f | Saldo atual: R$ %.2f%n", 
                         contaId, valor, novoSaldo);
        return true;
    }
    
    public double verSaldo(String contaId) {
        if (!contas.containsKey(contaId)) {
            System.out.println("Conta não encontrada: " + contaId);
            return -1;
        }
        
        double saldo = contas.get(contaId);
        System.out.printf("Saldo da conta %s: R$ %.2f%n", contaId, saldo);
        return saldo;
    }
    
    public void listarContasAtivas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta ativa encontrada.");
            return;
        }
        
        System.out.println("\n=== CONTAS ATIVAS ===");
        for (Map.Entry<String, Double> entry : contas.entrySet()) {
            System.out.printf("Conta: %s | Saldo: R$ %.2f%n", 
                             entry.getKey(), entry.getValue());
        }
        System.out.println("========================\n");
    }
    
    public void mostrarInstancia() {
        System.out.println("Instância do AccountManager: " + this.hashCode());
    }

}
