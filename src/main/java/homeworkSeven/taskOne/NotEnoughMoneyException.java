package homeworkSeven.taskOne;

public class NotEnoughMoneyException extends Exception {
    @Override
    public String toString() {
        return "Not enough money to withdraw";
    }
}
