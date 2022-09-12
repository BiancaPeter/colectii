package exercitii.exercisesS17.transactionmanagement2;

import java.util.List;

public class Account {
    private Integer balance;
    private String accountNumber;
    private List<Transaction> transactionList;

    public Account(Integer balance, String accountNumber, List<Transaction> transactionList) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.transactionList = transactionList;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactionList=" + transactionList +
                '}';
    }
}