package exercitii.exercisesS17.transactionmanagementEx6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(7000, "RO123456"));
        accountList.add(new Account(10000, "RO145678"));
        accountList.add(new Account(9000, "RO456123"));

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction("1", 300, accountList.get(2)));
        transactionList.add(new Transaction("2", 700, accountList.get(0)));
        transactionList.add(new Transaction("3", 200, accountList.get(2)));
        transactionList.add(new Transaction("4", 450, accountList.get(1)));
        transactionList.add(new Transaction("5", 800, accountList.get(0)));
        transactionList.add(new Transaction("6", 500, accountList.get(1)));

        System.out.println("java8: " + getSumOfAmountsByAccountNumber(transactionList));
        System.out.println(returnSumOfAmountsByAccountNumber(transactionList));

    }

    public static Map<String, Integer> getSumOfAmountsByAccountNumber(List<Transaction> transactionList) {
        return transactionList.stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getAccount().getAccountNumber(), Collectors.summingInt(transaction -> transaction.getAmount())));
    }

    public static Map<String, Integer> returnSumOfAmountsByAccountNumber(List<Transaction> transactionList) {
        Map<String, Integer> sumOfAmountsByAccountNumber = new HashMap<>();
        for (Transaction transaction : transactionList) {
            if (sumOfAmountsByAccountNumber.containsKey(transaction.getAccount().getAccountNumber())) {
                sumOfAmountsByAccountNumber.put(transaction.getAccount().getAccountNumber(), sumOfAmountsByAccountNumber.get(transaction.getAccount().getAccountNumber()) + transaction.getAmount());
            } else {
                sumOfAmountsByAccountNumber.put(transaction.getAccount().getAccountNumber(), transaction.getAmount());
            }
        }
        return sumOfAmountsByAccountNumber;
    }
}
