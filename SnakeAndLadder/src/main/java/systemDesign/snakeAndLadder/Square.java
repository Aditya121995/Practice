package systemDesign.snakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square {
    private Integer position;
    private Boolean isSnakeHead;
    private Boolean isLadderBottom;
    private Integer nextMovement;
}
