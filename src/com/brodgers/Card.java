package com.brodgers;

enum SUIT {Hearts, Spades, Diamonds, Clubs}

public class Card {
    private int _value;
    private SUIT _suit;

    Card(SUIT suit, int value) {
        this._suit = suit;
        this._value = value;
    }

    int compareTo(Card other) {
        return Integer.compare(this.getWarValue(), other.getWarValue());
    }

    public int getWarValue() {
        if (_value == 1) return 14;
        return _value;
    }

    public String getDisplay() {
        return switch (_value) {
            case 1 -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> Integer.toString(_value);
        };
    }

    private String _getPip() {
        return switch (_suit) {
            case Hearts -> "♥️️";
            case Spades -> "♠️️";
            case Diamonds -> "♦️";
            case Clubs -> "♣️️";
        };
    }

    @Override
    public String toString() {
        return String.format("%2s%s",getDisplay(), _getPip());
    }
}
