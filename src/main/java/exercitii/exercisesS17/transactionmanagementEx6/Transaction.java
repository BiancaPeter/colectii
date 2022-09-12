package exercitii.exercisesS17.transactionmanagementEx6;

public class Transaction {
    private String id;
    private Integer amount;
    private Account account;

    public Transaction(String id, int amount, Account account) {
        this.id = id;
        this.amount = amount;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int sum) {
        this.amount = sum;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", sum=" + amount +
                ", account=" + account +
                '}';
    }
}
