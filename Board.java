public class Board {

    private static int[] squares;//my board
    private static int cones = 0;
    private static int home;

    //constructor
    //creates a board of any size
    public Board(int amount) {
        squares = new int[amount + 1];//+1 so the array index is equal to amount
        home = amount;
        int amountOfCones = (amount / 4) + 1;//around 25%
        while (cones != amountOfCones) {//creates amountOfCones obstacles
            int obstacle = (int) (Math.random() * (amount - 1)) + 1;
            if (squares[obstacle] == 0) {//don't want to change if there is an obstacle already
                squares[obstacle] = (int) (Math.random() * 3) + 1;//1-3 range
                cones += 1;
            }
        }
    }

    //default board constructor
    public Board() {
        new Board(21);
    }

    //returns true if the player stepped on the obstacle
    public boolean isObstacle(Players player) {
        return squares[Math.min(player.getPosition(), home)] != 0;
    }

    //returns int value of an obstacle
    public int getObstacle(Players player) {
        return squares[player.getPosition()];
    }

    public int getHome() {
        return home;
    }
}
