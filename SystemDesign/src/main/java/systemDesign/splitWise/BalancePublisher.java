package systemDesign.splitWise;

import java.util.Map;

public class BalancePublisher {

    public void showBalancesOfUser(String userId, Map<String, User> userIdToUserMap) {
        User user = userIdToUserMap.get(userId);
        Map<User, Double> balances =user.getUserBalanceBook();
        boolean haveBalances = false;
        for (User usr : balances.keySet()) {
            haveBalances = isHaveBalances(userId, balances, haveBalances, usr.getUserId(), userIdToUserMap);
        }

        if (!haveBalances) {
            System.out.println("No Balances");
        }
    }

    public void showBalances(Map<String, User> userIdToUserMap) {
        boolean haveBalances = false;

        for (String userId : userIdToUserMap.keySet()) {
            User user = userIdToUserMap.get(userId);
            Map<User, Double> balances = user.getUserBalanceBook();
            for (User usr : balances.keySet()) {
                if (balances.get(usr) > 0) {
                    haveBalances = isHaveBalances(userId, balances, haveBalances, usr.getUserId(), userIdToUserMap);
                }
            }
        }

        if (!haveBalances) {
            System.out.println("No Balances");
        }
    }

    private boolean isHaveBalances(String userId, Map<User, Double> balances, boolean haveBalances, String id, Map<String, User> userIdToUserMap) {
        if (balances.get(userIdToUserMap.get(id)) > 0) {
            System.out.println(userIdToUserMap.get(id).getName() + " owes " + userIdToUserMap.get(userId).getName() + ": " + balances.get(userIdToUserMap.get(id)));
            haveBalances = true;
        } else if (balances.get(userIdToUserMap.get(id)) < 0) {
            System.out.println(userIdToUserMap.get(userId).getName() + " owes " + userIdToUserMap.get(id).getName() + ": " + Math.abs(balances.get(userIdToUserMap.get(id))));
            haveBalances = true;
        }
        return haveBalances;
    }

    public void showTotalBalanceOfUser(String userId,  Map<String, User> userIdToUserMap) {
        System.out.println("Total balance of " + userIdToUserMap.get(userId).getName() + ": " + userIdToUserMap.get(userId).getBalance());
    }
}
