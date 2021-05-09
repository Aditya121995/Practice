package systemDesign.splitWise;

import java.util.List;

public class ExactExpense extends Expense{

    public ExactExpense(User paidBy, Double amountPaid, List<SplitKeeper> splits) {
        super(paidBy, amountPaid, splits);
    }

    @Override
    public boolean validate() {
        double sumSplitAmount = 0D;
        for (SplitKeeper split : getSplits()) {
            if (split.getPercent() != null || split.getAmount() == null) {
                return false;
            }
            sumSplitAmount += split.getAmount();
        }

        return getAmountPaid().equals(sumSplitAmount);
    }
}
