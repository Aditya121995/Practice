package systemDesign.splitWise;

import lombok.Data;

import java.util.List;

@Data
public abstract class Expense {
    private User paidBy;
    private Double amountPaid;
    private List<SplitKeeper> splits;

    public Expense(User paidBy, Double amountPaid, List<SplitKeeper> splits) {
        this.paidBy = paidBy;
        this.amountPaid = amountPaid;
        this.splits = splits;
        if (!this.validate()) {
            throw new IllegalArgumentException("Invalid Expense. Please check your input again.");
        }
    }

    public abstract boolean validate();
}
