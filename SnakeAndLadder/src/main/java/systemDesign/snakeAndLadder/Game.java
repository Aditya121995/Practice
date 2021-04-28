package systemDesign.snakeAndLadder;

import java.util.*;

public class Game {
    private LinkedList <Player> players = new LinkedList<>();
    private Board board = null;
    private Player winner = null;
    private final Dice dice;

    public Game(Integer numberOfDice, String[] playerNames, int[][] snakes, int[][] ladders) {
        makeBoard(snakes, ladders); // load board and fix positions of snakes and ladders
        makePlayers(playerNames); // form players and make their initial position at 0th square
        this.dice = new Dice(numberOfDice);
    }

    public void play() throws InterruptedException {
        winner = null;
        while (winner == null) {
            int roll = dice.rollDice();
            movePlayer(roll);
            Thread.sleep(100);
        }
        System.out.println(winner.getName() + " wins the game");
    }

    private void movePlayer(int roll) {
        // remove the player from the queue whose chance is done and add it to the end of the queue
        Player currentPlayer = players.remove();
        Integer currentPosition = currentPlayer.position();
        currentPlayer.moveForward(roll);
        System.out.println(currentPlayer.getName() + " rolled a " + roll + " and moved from " + currentPosition + " to " + currentPlayer.position());
        players.add(currentPlayer);
        if (board.lastSquare().getPosition().equals(currentPlayer.position())) {
            this.winner = currentPlayer;
        }
    }

    private void makePlayers(String[] playerNames) {
        for (String name : playerNames) {
            Player player = new Player(name, board);
            players.add(player);
        }
    }

    private void makeBoard(int[][] snakes, int[][] ladders) {
        List<Snake> snakeList = makeSnakeList(snakes);
        List<Ladder> ladderList = makeLadderList(ladders);

        this.board = new Board(100, snakeList, ladderList);
    }

    private List<Snake> makeSnakeList(int[][] snakes) {
        List<Snake> snakeList = new ArrayList<>();
        for (int i=0; i<snakes.length; i++) {
            Snake snake = new Snake(snakes[i][0], snakes[i][1]);
            snakeList.add(snake);
        }
        return snakeList;
    }

    private List<Ladder> makeLadderList(int[][] ladders) {
        List<Ladder> ladderList = new ArrayList<>();
        for (int i=0; i<ladders.length; i++) {
            Ladder ladder = new Ladder(ladders[i][0], ladders[i][1]);
            ladderList.add(ladder);
        }
        return ladderList;
    }
}
