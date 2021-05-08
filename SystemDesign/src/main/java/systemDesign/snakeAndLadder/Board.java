package systemDesign.snakeAndLadder;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Board {
    private List<Square> squareList;
    private final List<Snake> snakeList;
    private final List<Ladder> ladderList;

    public Board(Integer numberOfSquares, List<Snake> snakeList, List<Ladder> ladderList) {
        this.snakeList = snakeList;
        this.ladderList = ladderList;
        this.squareList = new ArrayList<>();
        makeSquares(numberOfSquares);
    }

    private void makeSquares(Integer numberOfSquares) {
        Map<Integer, Integer> snakeMap = getSnakeMap();
        Map<Integer, Integer> ladderMap = getLadderMap();
        for (int position=0; position<=numberOfSquares; position++) {
            Square square;
            if (snakeMap.keySet().contains(position)) {
                square = new Square(position, true, false, snakeMap.get(position));
            } else if (ladderMap.keySet().contains(position)) {
                square = new Square(position, false, true, ladderMap.get(position));
            } else {
                square = new Square(position, false, false, position + 1);
            }

            squareList.add(square);
        }
    }

    private Map<Integer, Integer> getSnakeMap() {
        Map<Integer, Integer> snakeMap = new HashMap<>();
        for (Snake snake : snakeList) {
            snakeMap.put(snake.getHead(), snake.getTail());
        }

        return snakeMap;
    }

    private Map<Integer, Integer> getLadderMap() {
        Map<Integer, Integer> ladderMap = new HashMap<>();
        for (Ladder ladder : ladderList) {
            ladderMap.put(ladder.getBottom(), ladder.getTop());
        }

        return ladderMap;
    }

    public Square firstSquare() {
        return squareList.get(0);
    }

    public Square lastSquare() {
        return squareList.get(squareList.size() - 1);
    }

    public Square findSquare(Integer position) {
        return squareList.get(position);
    }


}
