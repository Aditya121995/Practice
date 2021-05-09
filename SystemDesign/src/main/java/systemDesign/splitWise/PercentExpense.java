package systemDesign.splitWise;

import java.util.List;

public class PercentExpense extends Expense {

    public PercentExpense(User paidBy, Double amountPaid, List<SplitKeeper> splits) {
        super(paidBy, amountPaid, splits);
    }

    @Override
    public boolean validate() {
        double sumSplitPercent = 0D;
        for (SplitKeeper split : getSplits()) {
            if (split.getPercent() == null || split.getAmount() == null) {
                return false;
            }
            sumSplitPercent += split.getPercent();
        }

        return sumSplitPercent == 100D;
    }
}
