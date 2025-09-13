public class Teste {

    public static void main(String[] args) {
        System.out.println("=== TESTE DO SISTEMA BANCÁRIO ===\n");

        Cliente cliente1 = new Cliente("001", "Ana Silva");
        Cliente cliente2 = new Cliente("002", "Carlos Santos");
        Cliente cliente3 = new Cliente("003", "Maria Oliveira");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTE 1: Verificando se todos usam a mesma instância");
        System.out.println("=".repeat(50));

        cliente1.verificarInstanciaManager();
        cliente2.verificarInstanciaManager();
        cliente3.verificarInstanciaManager();

        // Tentativa de criar nova instancia diretamente
        AccountManager manager1 = AccountManager.getInstance();
        AccountManager manager2 = AccountManager.getInstance();

        try {
            manager1.cadastrarConta(cliente1.getId());
            manager1.cadastrarConta(cliente2.getId());
            manager1.cadastrarConta(cliente3.getId());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Tentativa de criar conta que ja existe
        try {
            manager1.cadastrarConta(cliente1.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Manager1 hashCode: " + manager1.hashCode());
        System.out.println("Manager2 hashCode: " + manager2.hashCode());
        System.out.println("São a mesma instância? " + (manager1 == manager2));

        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTE 2: Operações bancárias");
        System.out.println("=".repeat(50));

        cliente1.realizarDeposito(1000.0);
        cliente2.realizarDeposito(1500.0);
        cliente3.realizarDeposito(800.0);

        cliente1.consultarSaldo();
        cliente2.consultarSaldo();
        cliente3.consultarSaldo();

        AccountManager.getInstance().listarContasAtivas();

        cliente1.realizarSaque(200.0);
        cliente2.realizarSaque(2000.0); // Saque que deve falhar
        cliente3.realizarSaque(300.0);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTE 3: Estado final das contas");
        System.out.println("=".repeat(50));

        cliente1.consultarSaldo();
        cliente2.consultarSaldo();
        cliente3.consultarSaldo();

        AccountManager.getInstance().listarContasAtivas();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTE 4: Demonstrando persistência do Singleton");
        System.out.println("=".repeat(50));

        Cliente cliente4 = new Cliente("004", "Pedro Costa");
        AccountManager novoManager = AccountManager.getInstance();
        try {
            novoManager.cadastrarConta(cliente4.getId());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Novo cliente criado, obtendo AccountManager...");
        System.out.println("Nova instância hashCode: " + novoManager.hashCode());

        System.out.println("Contas existentes no 'novo' manager:");
        novoManager.listarContasAtivas();

        cliente4.realizarDeposito(500.0);
        cliente4.consultarSaldo();
    }

}
