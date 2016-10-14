package homeworkSeven.taskOne;

import org.junit.Test;

public class AccountTest {

    @Test(expected = NotEnoughMoneyException.class)
    public void exceptionTest () throws Exception {
        Account account = new Account(1,100);
        account.withdraw(150);
    }

}