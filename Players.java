public class Players {

    private final String name;
    private int position = 0;
    //instead of having turn variable I just sorted my array of Players the way it should be

    public Players(String name) {
        this.name = name;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Cards draw(Deck deck) {
        return deck.draw();
    }

    //setters
    public void setPosition(int pos) {
        //does let player's position pass 0
        position = Math.max(0, pos);
    }

    //returns true once passes the home square
    public boolean isHome(Board board) {
        return position >= board.getHome();
    }
}