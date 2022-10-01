package exercitii.exercisesS17.transactionmanagement2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction("1", State.CANCELED, 900);
        Transaction transaction2 = new Transaction("2", State.FINISHED, 500);
        Transaction transaction3 = new Transaction("3", State.PROCESSING, 400);
        Transaction transaction4 = new Transaction("4", State.PROCESSING, 800);
        Transaction transaction5 = new Transaction("5", State.FINISHED, 1000);
        Transaction transaction6 = new Transaction("6", State.CANCELED, 100);

        List<Transaction> transactionList1 = new ArrayList<>();
        transactionList1.add(transaction1);
        transactionList1.add(transaction2);
        transactionList1.add(transaction3);

        List<Transaction> transactionList2 = new ArrayList<>();
        transactionList2.add(transaction4);
        transactionList2.add(transaction5);
        transactionList2.add(transaction6);

        Account account1 = new Account(20000, "RO123456", transactionList1);
        Account account2 = new Account(15000, "RO456123", transactionList2);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);

        System.out.println("java8: " + getSumOfCanceledTransaction(accountList));
        System.out.println(returnSumOfCanceledTransaction(accountList));
    }

    public static Integer getSumOfCanceledTransaction(List<Account> accountList) {
        return accountList.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactionList().stream())
                .filter(transaction -> transaction.getState().equals(State.CANCELED))
                //.map(transaction -> transaction.getAmount())
                //.reduce((sum, amount) -> sum + amount);
                .collect(Collectors.summingInt(transaction -> transaction.getAmount()));
    }

    public static Integer returnSumOfCanceledTransaction(List<Account> accountList) {
        Integer sum = 0;
        for (Account account : accountList) {
            if (account.getBalance() > 0) {
                for (Transaction transaction : account.getTransactionList()) {
                    if (transaction.getState().equals(State.CANCELED)) {
                        sum += transaction.getAmount();
                    }
                }
            }
        }
        return sum;
    }
}
