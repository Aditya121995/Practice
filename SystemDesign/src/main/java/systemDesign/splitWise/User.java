package systemDesign.splitWise;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String name;
    private String emailId;
    private String number;
    private Double balance;

    public User(String userId, String name, String emailId, String number) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.number = number;
        this.balance = 0.0;
    }

}
