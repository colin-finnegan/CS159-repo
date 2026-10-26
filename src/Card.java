public class Card {

    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;

    private final int suit;

    /**
     * Constructs a card of the given rank and suit.
     *
     * @param rank the rank
     * @param suit the suit
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13) {
            throw new IllegalArgumentException("invalid rank: " + rank);
        }
        if (suit < 0 || suit > 3) {
            throw new IllegalArgumentException("invalid suit: " + suit);
        }
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Constructs a card of the given rank and suit.
     *
     * @param rank string representation of the rank
     * @param suit string representation of the suit
     */
    public Card(String rank, String suit) {
        this.rank = parseRank(rank);
        this.suit = parseSuit(suit);
    }

    /**
     * Compares this card with that card.
     *
     * @param that the card to compare
     * @return -1 if this card comes before that card, 0 if the two cards are
     *     equal, or +1 if this card comes after that card
     */
    public int compareTo(Card that) {
        int result;
        if (this.suit < that.suit) {
            result = -1;
        } else if (this.suit > that.suit) {
            result = 1;
        } else if (this.rank < that.rank) {
            result = -1;
        } else if (this.rank > that.rank) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * Returns true if the given card has the same rank and same suit.
     *
     * @param obj the other Card
     * @return true if the two are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card that = (Card) obj;
            return this.rank == that.rank && this.suit == that.suit;
        }
        return false;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    /**
     * Determines the integer rank from the given string rank.
     *
     * @param str the string representation of the rank
     * @return the rank integer, or -1 if invalid
     */
    public static int parseRank(String str) {
        for (int i = 0; i < RANKS.length; i++) {
            if (str.equals(RANKS[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("invalid rank: " + str);
    }

    /**
     * Determines the integer suit from the given string suit.
     *
     * @param str the string representation of the suit
     * @return the suit integer, or -1 if invalid
     */
    public static int parseSuit(String str) {
        for (int i = 0; i < SUITS.length; i++) {
            if (str.equals(SUITS[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("invalid suit: " + str);
    }

    /**
     * Gets the card's index in a sorted deck of 52 cards.
     *
     * @return index of the card
     */
    public int position() {
        return this.suit * 13 + this.rank - 1;
    }

    @Override
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

}
