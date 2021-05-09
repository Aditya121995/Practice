package systemDesign.splitWise;

import lombok.Data;

@Data
public class SplitKeeper {
    private User user;
    private Double amount;
    private Double percent;

    public SplitKeeper(User user){
        this.user = user;
    }

    public SplitKeeper(User user, ExpenseType expenseType, Double split){
        this.user = user;
        if (ExpenseType.EXACT.equals(expenseType)) {
            this.amount = split;
        }
        if (ExpenseType.PERCENT.equals(expenseType)) {
            this.percent = split;
        }
    }
}
