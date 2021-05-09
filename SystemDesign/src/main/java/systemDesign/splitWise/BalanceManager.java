package systemDesign.splitWise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BalanceManager {
    private List<Expense> expenseList;
    private Map<String, User> userIdToUserMap;
    private BalancePublisher balancePublisher;
    private ExpenseCreator expenseCreator;
    private Map<String, Map<String, Double>> balanceBook;

    public BalanceManager() {
        this.expenseList = new ArrayList<>();
        this.userIdToUserMap = new HashMap<>();
        this.expenseCreator = new ExpenseCreator();
        this.balancePublisher = new BalancePublisher();
        this.balanceBook = new HashMap<>();
    }

    public void addUser(User user) {
        userIdToUserMap.put(user.getUserId(), user);
        balanceBook.put(user.getUserId(), new HashMap<>());
    }

    public void updateBalance(ExpenseType expenseType, String paidBy, double paidAmount, List<String> paidToList, List<Double> splitInfo) {
        List<SplitKeeper> splitKeeperList = getSplitKeeperList(paidToList, splitInfo, expenseType);
        User paidByUser = userIdToUserMap.get(paidBy);
        Expense expense = expenseCreator.createExpense(expenseType, paidByUser, paidAmount, splitKeeperList);
        expenseList.add(expense);
        paidByUser.setBalance(paidByUser.getBalance() + paidAmount);

        for (SplitKeeper split : splitKeeperList) {
            User paidTo = split.getUser();
            paidTo.setBalance(paidTo.getBalance() - split.getAmount());

            // populate balanceBook map for paidBy
            Map<String, Double> balancesForPayingUser = balanceBook.get(paidBy);
            if (!balancesForPayingUser.containsKey(paidTo.getUserId())) {
                balancesForPayingUser.put(paidTo.getUserId(), 0.0);
            }
            balancesForPayingUser.put(paidTo.getUserId(), balancesForPayingUser.get(paidTo.getUserId()) + split.getAmount());

            // populate balanceBook map for paidTo
            Map<String, Double> balancesForReceivingUser = balanceBook.get(paidTo.getUserId());
            if (!balancesForReceivingUser.containsKey(paidBy)) {
                balancesForReceivingUser.put(paidBy, 0.0);
            }
            balancesForReceivingUser.put(paidBy, balancesForReceivingUser.get(paidBy) - split.getAmount());
        }

    }

    private List<SplitKeeper> getSplitKeeperList(List<String> paidToList, List<Double> splitInfo, ExpenseType expenseType) {

        List<SplitKeeper> splitKeeperList = new ArrayList<>();
        switch (expenseType) {
            case EQUAL:
                for (int i = 0; i<paidToList.size(); i++) {
                    splitKeeperList.add(new SplitKeeper(userIdToUserMap.get(paidToList.get(i))));
                }
                return splitKeeperList;
            case EXACT:
            case PERCENT:
                if (splitInfo.size() != paidToList.size()) {
                    throw new IllegalArgumentException("Invalid Expense distribution.");
                }
                for (int i = 0; i<paidToList.size(); i++) {
                    splitKeeperList.add(new SplitKeeper(userIdToUserMap.get(paidToList.get(i)), expenseType, splitInfo.get(i)));
                }
                return splitKeeperList;
            default:
                throw new IllegalArgumentException("Invalid ExpenseType.");
        }

    }

    public void showBalance() {
        balancePublisher.showBalances(balanceBook, userIdToUserMap);
    }

    public void showBalanceOfUser(String userId) {
        balancePublisher.showBalancesOfUser(userId, balanceBook, userIdToUserMap);
    }

    public void showTotalBalanceOfUser(String userId) {
        balancePublisher.showTotalBalanceOfUser(userId, userIdToUserMap);
    }
}
