package homeworkSeven.taskOne;

public class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void withdraw (int amount) throws NotEnoughMoneyException {
        if (balance>amount){
            balance-=amount;
        }
        else{
            throw new NotEnoughMoneyException();
        }
    }
    // https://github.com/zstudent/Concurrency
    public void deposit (int amount){
        balance+=amount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}
