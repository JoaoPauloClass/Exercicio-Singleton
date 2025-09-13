public class Cliente {
    private String id;
    private String nome;
    private AccountManager accountManager;

    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.accountManager = AccountManager.getInstance();

        System.out.println("Cliente criado: " + nome + " (ID: " + id + ")");
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void realizarDeposito(double valor) {
        System.out.println("\n" + nome + " está realizando um depósito...");
        try {
            accountManager.depositar(id, valor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void realizarSaque(double valor) {
        System.out.println("\n" + nome + " está realizando um saque...");
        try {
            accountManager.sacar(id, valor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void consultarSaldo() {
        System.out.println("\n" + nome + " está consultando o saldo...");
        accountManager.verSaldo(id);
    }

    public void verificarInstanciaManager() {
        System.out.println(nome + " - Instância do AccountManager: " +
                accountManager.hashCode());
    }

}
