package systemDesign.snakeAndLadder;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@Qualifier("Snake")
public class Snake {
    private Integer head;
    private Integer tail;

    public Snake(Integer head, Integer tail) {
        this.head = head;
        this.tail = tail;
        if (!this.isValid()) {
            throw new IllegalArgumentException("Invalid input provided for snake positions");
        }
    }

    public boolean isValid() {
        if (tail < 0) {
            return false;
        } else if (head >= 100) {
            return false;
        } else if (head <= tail) {
            return false;
        }
        return true;
    }
}
