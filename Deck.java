public class Deck {

    private int topOfTheDeck = 10;
    //set of cards
    private final Cards[] cards = {new Cards(1), new Cards(1),
            new Cards(2), new Cards(2),
            new Cards(3), new Cards(3),
            new Cards(4), new Cards(4),
            new Cards(5), new Cards(6)};

    //constructor shuffles once deck is created
    //no parameters because it is always the same
    public Deck() {
        shuffle();
    }

    private void shuffle() {
        int randint1;
        int randint2;
        Cards swap;
        //swaps 2 random cards 50 times
        for (int i = 0; i < 50; i++) {
            randint1 = (int) (Math.random() * 10);//range from 0-9
            randint2 = (int) (Math.random() * 10);//range from 0-9
            //swap part
            if (randint1 != randint2) {
                swap = cards[randint1];
                cards[randint1] = cards[randint2];
                cards[randint2] = swap;
            }
        }
        
    }

    private boolean isOutOfCards() {
        return topOfTheDeck == 0;
    }

    public Cards draw() {
        //once deck is empty shuffles it
        if (isOutOfCards()) {
            System.out.println("The deck is out of cards.\nDeck is shuffled.\n");
            shuffle();
            topOfTheDeck = 10;
        }
        topOfTheDeck--;
        return cards[topOfTheDeck];
    }
}