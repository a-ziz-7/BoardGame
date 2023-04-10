import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gameDescription();//prints the game description(can be commented out if there is no need for it)
        System.out.println("Enter the amount of the squares in the board (21 is recommended):");
        int numberOfSquares = sc.nextInt();
        //Board myBoard = new Board();//default 21 square board
        Board myBoard = new Board(numberOfSquares);//creates a Board object of numberOfSquares size
        System.out.println("Enter the amount of players:");
        int numberOfPlayers = sc.nextInt();
        Players[] allPlayers = new Players[numberOfPlayers];
        setPlayers(allPlayers, numberOfPlayers, sc);//creates numberOfPlayers unique Players objects
        Deck myDeck = new Deck();//creates a Deck object
        goHomeGame(allPlayers, myBoard, myDeck);//goHome game processes
    }

    //main game's method that basically does everything except creating objects
    //did not import Scanner to show that game only needs
    //a deck of cards, a board, and players to play the game
    public static void goHomeGame(Players[] allPlayers, Board myBoard, Deck myDeck) {
        Scanner scanner = new Scanner(System.in);
        boolean hasAWinner = false;
        Cards card;
        int action;

        setTurnAllPlayers(allPlayers);
        //runs until someone reaches or passes the home square
        while (!hasAWinner) {//one iteration represents when all players had their turn
            for (int i = 0; i < allPlayers.length; i += 1) {//one iteration-one player's turn
                sleep();
                System.out.println(allPlayers[i].getName() + "(" +
                        allPlayers[i].getPosition() + ") press ENTER to draw a card");
                scanner.nextLine();//waits until players presses enter
                card = allPlayers[i].draw(myDeck);
                //action is an int variable that represents what is going to happen with player's position
                action = card.getCard();
                System.out.println(allPlayers[i].getName() + " drew a " + card.getDescription() + " card.");
                //action method does something depending on what card was drawn
                action(i, action, allPlayers, myBoard, scanner);
                //winner check
                if ((allPlayers[i].isHome(myBoard))) {
                    System.out.println("Player " + allPlayers[i].getName() + " is the winner.");
                    hasAWinner = true;
                    System.out.println("The game is over.");
                    break;//breaks for but while will return false since hasAWinner is changed
                }
            }
        }

    }

    //sets turn for all players in my Players array
    //such way that the player with the shortest name gets the first turn
    public static void setTurnAllPlayers(Players[] array) {
        int length = array.length;
        Players swap;
        for (int i = 0; i < length; i++) {
            for (int j = 0; i < length; i++) {
                if (array[i].getName().length() < array[j].getName().length()) {
                    swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
        //prints the order of turns after sorting
        System.out.println("The order of turns is:");
        for (Players players : array) {
            System.out.print(players.getName() + " ");
        }
        System.out.println("\n");
    }

    public static void gameDescription() {
        System.out.println(
                "The GoHome game can be played with 2 to 4 players, all players start at position 0," +
                        " the object of the game is to get to or pass the home first. " +
                        "\nHome is located at the end of the board.\nThe board also has obstacles, " +
                        "an obstacles consist of a number of spaces that the user must move backwards.\n" +
                        "The game comes with 4 player pieces, a board, and a set of 10 cards. " +
                        "\nThere are two cards with each number from 1-4, one card with " +
                        "\"lose a turn,\" and one with \"switch places with another player.\"\n" +
                        "The player with the shortest name has a first turn.\n" +
                        "A turn consists of picking a card. If there is a number on the card, " +
                        "the player moves forward that number of spaces. \nIf the card says " +
                        "\"lose a turn,\" the player does nothing, and the turn moves to the next player. " +
                        "\nIf the player gets \"Switch places\" it must switch with a " +
                        "player of its choice. \nAfter the player moves, if the player lands on an obstacle, " +
                        "the player moves back that number of spaces. \nIf the " +
                        "player lands on an obstacle after moving backward, it does not have to move back again.");
    }

    public static void setPlayers(Players[] allPl, int num, Scanner sc) {
        //creates num Players objects
        for (int i = 0; i < num; i++) {
            System.out.println("Player " + (i + 1) + " enter your name:");
            allPl[i] = new Players(sc.next());//creates a new Players object
        }
    }

    public static void action(int i, int action, Players[] players, Board board, Scanner scanner) {
        if (action <= 4) {//card check
            players[i].setPosition(players[i].getPosition() + action);//adds action variable to player's position
            sleep();
            System.out.println("Your new position is " + players[i].getPosition());
            obstacleHandling(board, players[i]);//obstacle check
        } else if (action == 5) {//card check
            //does nothing to player's position
            sleep();
            System.out.println("Your position remains at " + players[i].getPosition());
        } else {//card check
            //shows what player's options are
            for (int p = 0; p < players.length; p++) {
                if (p != i) {//its own position is not an option
                    System.out.println(players[p].getName() + " is in position " +
                            players[p].getPosition());
                }
            }
            System.out.print("Enter who you want to switch places with:");
            String swap = scanner.nextLine();
            int swapPos;
            for (int p = 0; p < players.length; p++) {
                if (p != i && Objects.equals(swap, players[p].getName())) {//checks who to swap places with
                    swapPos = players[i].getPosition();
                    players[i].setPosition(players[p].getPosition());
                    players[p].setPosition(swapPos);
                    sleep();
                    System.out.println("Your new position is " + players[i].getPosition() +
                            "\nPlayer " + players[p].getName() + "'s new position is " +
                            players[p].getPosition());
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void obstacleHandling(Board board, Players play) {
        if (board.isObstacle(play)) {//obstacle check
            int obstacle = board.getObstacle(play);
            sleep();
            System.out.println("You stepped on \"Move backwards " + obstacle + " squares\" cone.");
            play.setPosition(play.getPosition() - obstacle);//changes the position based on the cone
            System.out.println("Your new position is " + play.getPosition());
        }

    }

    public static void sleep(){
        int x = 500;
        try{
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}