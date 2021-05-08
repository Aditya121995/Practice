package systemDesign.snakeAndLadder;

import lombok.Data;

@Data
public class Player {
    private String name;
    private Square square;
    private Board board;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        this.square = board.firstSquare();
    }

    public Integer position () {
        return square.getPosition();
    }

    public void moveForward(Integer moves) {
        if (square.getPosition() + moves <= board.lastSquare().getPosition()) {
            Square newSquare = board.findSquare(square.getPosition() + moves); // find square of next position
            while (newSquare.getIsLadderBottom() || newSquare.getIsSnakeHead()) { // keep moving the dice if next square contains a snake or ladder
                if (newSquare.getNextMovement() < 100) {
                    newSquare = board.findSquare(newSquare.getNextMovement());
                } else {
                    break;
                }
            }
            square = newSquare;
        }
    }
}
