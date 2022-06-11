package com.brodgers;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String _name;
    private List<Card> _cards = new ArrayList<Card>();

    Player(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public int numberOfCards() {
        return _cards.size();
    }

    public void addToTopOfHand(List<Card> cards) {
        _cards.addAll(0, cards);
    }

    public void addToTopOfHand(Card c) {
        _cards.add(0, c);
    }

    public void addToBottomOfHand(List<Card> cards) {
        _cards.addAll(cards);
    }

    public Card takeTopCard() {
        return _cards.remove(0);
    }

    public boolean hasCards() {
        return !_cards.isEmpty();
    }

    public String showHand() {
        StringBuilder sb = new StringBuilder();
        for (Card c : _cards) {
            sb.append(c);
            sb.append(", ");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return String.format("%s %d", _name, _cards.size());
    }
}
