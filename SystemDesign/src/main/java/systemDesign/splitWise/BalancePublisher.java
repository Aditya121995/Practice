package systemDesign.splitWise;

import java.util.Map;

public class BalancePublisher {

    public void showBalancesOfUser(String userId, Map<String, Map<String, Double>> balanceBook, Map<String, User> userIdToUserMap) {
        Map<String, Double> balances = balanceBook.get(userId);
        boolean haveBalances = false;
        for (String id : balances.keySet()) {
            haveBalances = isHaveBalances(userId, balances, haveBalances, id, userIdToUserMap);
        }

        if (!haveBalances) {
            System.out.println("No Balances");
        }
    }

    public void showBalances(Map<String, Map<String, Double>> balanceBook, Map<String, User> userIdToUserMap) {
        boolean haveBalances = false;

        for (String userId : balanceBook.keySet()) {
            Map<String, Double> balances = balanceBook.get(userId);
            for (String id : balances.keySet()) {
                if (balances.get(id) > 0) {
                    haveBalances = isHaveBalances(userId, balances, haveBalances, id, userIdToUserMap);
                }
            }
        }

        if (!haveBalances) {
            System.out.println("No Balances");
        }
    }

    private boolean isHaveBalances(String userId, Map<String, Double> balances, boolean haveBalances, String id, Map<String, User> userIdToUserMap) {
        if (balances.get(id) > 0) {
            System.out.println(userIdToUserMap.get(id).getName() + " owes " + userIdToUserMap.get(userId).getName() + ": " + balances.get(id));
            haveBalances = true;
        } else if (balances.get(id) < 0) {
            System.out.println(userIdToUserMap.get(userId).getName() + " owes " + userIdToUserMap.get(id).getName() + ": " + Math.abs(balances.get(id)));
            haveBalances = true;
        }
        return haveBalances;
    }

    public void showTotalBalanceOfUser(String userId,  Map<String, User> userIdToUserMap) {
        System.out.println("Total balance of " + userIdToUserMap.get(userId).getName() + ": " + userIdToUserMap.get(userId).getBalance());
    }
}
