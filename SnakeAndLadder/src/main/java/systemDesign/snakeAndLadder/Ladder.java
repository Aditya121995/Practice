package systemDesign.snakeAndLadder;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@Qualifier("Ladder")
public class Ladder {
    private Integer bottom;
    private Integer top;

    public Ladder(Integer bottom, Integer top) {
        this.bottom = bottom;
        this.top = top;
        if (!this.isValid()) {
            throw new IllegalArgumentException("Invalid input provided for ladder positions");
        }
    }

    public boolean isValid() {
        if (bottom <= 0) {
            return false;
        } else if (top > 100) {
            return false;
        } else if (bottom >= top) {
            return false;
        }

        return true;
    }
}
