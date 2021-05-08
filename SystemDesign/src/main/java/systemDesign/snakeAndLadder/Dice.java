package systemDesign.snakeAndLadder;

import org.springframework.stereotype.Component;

@Component
public class Dice {
    private Integer numberOfDice;

    public Dice(Integer numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public Integer rollDice() {
        return (int) Math.round(Math.random()*(5*numberOfDice)) + numberOfDice;
    }
}
