package systemDesign.splitWise;

import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense(User paidBy, Double amountPaid, List<SplitKeeper> splits) {
        super(paidBy, amountPaid, splits);
    }

    @Override
    public boolean validate() {
        for (SplitKeeper split : getSplits()) {
            if (split.getAmount() == null || split.getPercent() != null) {
                return false;
            }
        }
        return true;
    }
}
