package systemDesign.splitWise;

import java.util.Arrays;

public class testClass {
    public static void main(String[] args) {
        User user1 = new User("u1", "user1", "user1@gmail.com", "1235465675");
        User user2 = new User("u2", "user2", "user2@gmail.com", "2235465675");
        User user3 = new User("u3", "user3", "user3@gmail.com", "3235465675");
        User user4 = new User("u4", "user4", "user4@gmail.com", "4235465675");

        BalanceManager balanceManager = new BalanceManager();
        balanceManager.addUser(user1);
        balanceManager.addUser(user2);
        balanceManager.addUser(user3);
        balanceManager.addUser(user4);

        balanceManager.showBalance();
        balanceManager.showBalanceOfUser("u1");

        balanceManager.updateBalance(ExpenseType.EQUAL, "u1", 1000.0, Arrays.asList("u1", "u2", "u3", "u4"), null );
        balanceManager.showBalanceOfUser("u4");
        balanceManager.showBalanceOfUser("u1");

        balanceManager.updateBalance(ExpenseType.EXACT, "u1", 1250.0, Arrays.asList("u2", "u3"), Arrays.asList(370.0, 880.0));
        balanceManager.showBalance();

        balanceManager.updateBalance(ExpenseType.PERCENT, "u4", 1200.0, Arrays.asList("u1", "u2", "u3", "u4"), Arrays.asList(40.0, 20.0, 20.0, 20.0));
        balanceManager.showBalanceOfUser("u1");
        balanceManager.showBalance();

        balanceManager.showTotalBalanceOfUser("u1");
        balanceManager.showTotalBalanceOfUser("u2");
        balanceManager.showTotalBalanceOfUser("u3");
        balanceManager.showTotalBalanceOfUser("u4");

    }
}
