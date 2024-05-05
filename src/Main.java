import java.util.HashMap;
import java.util.Scanner;

import com.olliverbank.Account;
import com.olliverbank.CreateAccount;
import com.olliverbank.Deposit;

public class Main {
    public static void main(String[] args) {

        Scanner prompt = new Scanner(System.in);
        Account account = new Account();
        Deposit deposit = new Deposit();

        int next = 0;

        System.out.println("Seja bem vindo(a) ao OlliverBank!");
        System.out.println("Vamos iniciar o seu cadastro conosco!");
        System.out.println("--------------------------------------");

        while (next == 0) {


            try {

                System.out.println("Por favor, digite o seu nome completo: ");
                String nameClient = prompt.nextLine();

                if (nameClient.isEmpty()) {
                    System.out.println("O campo nome não pode ser vazio!");
                    continue;
                }

                CreateAccount createAccount = new CreateAccount(nameClient);

                System.out.println("Por favor, selecione sua região: ");
                System.out.println("1 - Ipatinga \n" +
                        "2 - Coronel Fabriciano \n" +
                        "3 - Timóteo \n" +
                        "4 - Santana do paraíso \n");

                String inputRegion = prompt.nextLine();

                int region = Integer.parseInt(inputRegion);

                if (region < 1 || region > 4) {
                    throw new IllegalArgumentException("O número deve estar entre 1 e 4.");
                }

                HashMap<String, Object> accountClient = createAccount.createAccount(region);

                account.setAgency((String) accountClient.get("agency"));
                account.setNumber((int) accountClient.get("numberAccount"));
                account.setName((String) accountClient.get("nameClient"));
                account.setBalance(deposit.getDeposit());

                System.out.println("Olá " + account.getName() + ", Sua conta foi criada com sucesso\n" +
                        "Agencia: " + account.getAgency() + "\n" +
                        "Número conta: " + account.getNumber() + "\n" +
                        "Saldo atual: " + account.getBalance());

                System.out.println("Deseja realizar um deposito?\n" +
                        "s - sim\n" +
                        "n - não");
                String response = prompt.nextLine();

                if(response.equals("s")){

                    System.out.println("Digite o valor a ser depositado: ");
                    float depositValue = prompt.nextFloat();

                    deposit.setDeposit(depositValue);
                    account.setBalance(deposit.getDeposit());
                }

                System.out.println("Seu saldo é :" + account.getBalance());

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            next = 1;
        }
    }
}
