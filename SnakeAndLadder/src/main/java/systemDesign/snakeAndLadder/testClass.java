package systemDesign.snakeAndLadder;

public class testClass {
    public static void main(String[] args) throws InterruptedException {
        String[] players = {"Gaurav", "Sagar"};
        int[][] snakes = {{62,5}, {37,6}, {46,9}, {88,16}, {41,20}, {56,53}, {98,64}, {93, 73}, {95,75}};
        int[][] ladders = {{2,37}, {27,46}, {10,32}, {51, 68}, {61,79}, {65, 84}, {71,91}, {81,100}};

        Game game = new Game(1, players, snakes, ladders);

        game.play();
    }
}
