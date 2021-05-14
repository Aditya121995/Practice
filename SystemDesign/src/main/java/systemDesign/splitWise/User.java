package systemDesign.splitWise;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class User {
    private String userId;
    private String name;
    private String emailId;
    private String number;
    private Double balance;
    private Map<User, Double> userBalanceBook;

    public User(String userId, String name, String emailId, String number) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.number = number;
        this.balance = 0.0;
        this.userBalanceBook = new HashMap<>();
    }

}
