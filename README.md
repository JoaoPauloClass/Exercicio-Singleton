# Atividade: Gerenciador de Conta Financeira com Singleton

## Cenário
Você está desenvolvendo um sistema bancário simples para gerenciar contas financeiras.  
Para evitar a criação de múltiplas instâncias do gerenciador de contas, você deve implementar o padrão **Singleton** para garantir que apenas uma instância seja utilizada para manipular as operações financeiras de cada cliente.

---

## Requisitos

### Classe Singleton: `AccountManager`
- A classe `AccountManager` deve ser implementada como um **Singleton**.  
- Responsável por manter as contas dos clientes.  
- Deve conter **uma conta e um saldo inicial** para cada cliente.  
- Deve ter métodos para:
  - `depositar(String contaId, double valor)`: Depositar uma quantia na conta do cliente.  
  - `sacar(String contaId, double valor)`: Sacar uma quantia da conta, verificando se o saldo é suficiente.  
  - `verSaldo(String contaId)`: Exibir o saldo atual da conta do cliente.  
  - `listarContasAtivas()`: Exibir todas as contas de clientes existentes.  

---

### Classe Cliente
- Deve representar um cliente com pelo menos os atributos **ID do cliente** e **nome**.  
- O cliente deve ser capaz de realizar operações como **depósito** e **saque** em sua conta usando o `AccountManager`.  

---

### Demonstração do Singleton
- Implemente uma classe de teste que crie múltiplas instâncias de clientes.  
- Os clientes devem realizar diferentes operações em suas contas.  
- Mostre que todos compartilham a **mesma instância** do `AccountManager` (se um novo objeto do tipo `AccountManager` for instanciado, os saldos das contas permanecerão os mesmos).  
