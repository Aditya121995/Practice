package systemDesign.splitWise;

import java.util.List;

public class ExpenseCreator {
    public Expense createExpense(ExpenseType expenseType, User paidBy, Double paidAmount, List<SplitKeeper> splits) {
        switch (expenseType) {
            case EQUAL:
                double splitAmount = Math.round(paidAmount/splits.size() * 100.0) / 100.0;
                splits.stream().skip(0).forEach(s-> {
                    s.setAmount(splitAmount);
                });
                double amountSoFar = (splits.size()-1)*splitAmount;
                splits.get(0).setAmount(paidAmount - amountSoFar);
                return new EqualExpense(paidBy, paidAmount, splits);
            case EXACT:
                return new ExactExpense(paidBy, paidAmount, splits);
            case PERCENT:
                for (SplitKeeper split : splits) {
                    double amount = (paidAmount * split.getPercent()) / 100.0;
                    split.setAmount(amount);
                }
                return new PercentExpense(paidBy, paidAmount, splits);
            default:
                throw new IllegalArgumentException("Invalid ExpenseType.");
        }
    }
}
