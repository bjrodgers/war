package com.brodgers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> _cards = new ArrayList<Card>();

    Deck() {
       for (SUIT s : SUIT.values()) {
           for (int i=1;i<=13;i++) {
               _cards.add(new Card(s, i));
           }
        }
    }

    void shuffle() {
        Collections.shuffle(_cards);
        Collections.shuffle(_cards);
        Collections.shuffle(_cards);
    }

    public Card takeTopCard() {
        return _cards.remove(0);
    }

    public boolean isEmpty() {
        return _cards.isEmpty();
    }

    @Override
    public String toString() {
        return _cards.toString();
    }
}
