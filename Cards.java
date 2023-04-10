public class Cards {

    private final int card;
    private final String description;

    //constructor gives proper description
    public Cards(int num) {
        card = num;
        if (num <= 4) {
            description = "\"Move forward " + num + (num == 1 ? " square" : " squares") + "\"";
        } else if (num == 5) {
            description = "\"Lose a turn\"";
        } else {
            description = "\"Switch places with another player\"";
        }
    }

    public int getCard() {
        return card;
    }

    public String getDescription() {
        return description;
    }

}