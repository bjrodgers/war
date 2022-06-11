package com.brodgers;

import java.util.*;

public class WarGame {
    private final Deck _deck;
    private final Player _playerA;
    private final Player _playerB;

    WarGame(String playerOne, String playerTwo) {
        _deck = new Deck();
        _playerA = new Player(playerOne);
        _playerB = new Player(playerTwo);
    }

    public void deal() {
        _deck.shuffle();

        int cardCount = 0;
        while (!_deck.isEmpty()) {
            if (cardCount++ % 2 == 0) {
                _playerA.addToTopOfHand(_deck.takeTopCard());
            } else {
                _playerB.addToTopOfHand(_deck.takeTopCard());
            }
        }
    }

    public void play() {
        int roundCount = 0;

        List<Card> cardsToWin = new ArrayList<Card>();
        while (_playerA.hasCards() && _playerB.hasCards()) {
            roundCount++;
            Card cardA = _playerA.takeTopCard();
            Card cardB = _playerB.takeTopCard();

            cardsToWin.add(cardA);
            cardsToWin.add(cardB);

            Player winner = null;
            switch (cardA.compareTo(cardB)) {
                case -1 -> winner = _playerB;
                case 0 -> {
                    if (_playerA.hasCards()) cardsToWin.add(_playerA.takeTopCard());
                    if (_playerB.hasCards()) cardsToWin.add(_playerB.takeTopCard());
                }
                case 1 -> winner = _playerA;
            }

            if (winner != null) {
                Collections.shuffle(cardsToWin); // Adds some "realness" to the game
                winner.addToBottomOfHand(cardsToWin);

                System.out.printf("[%4s] %s %s vs %s %s [%s wins %d cards] - (%s to %s)%n",
                        roundCount,
                        _playerA.getName(),
                        cardA.toString(),
                        _playerB.getName(),
                        cardB.toString(),
                        winner.getName(),
                        cardsToWin.size(),
                        _playerA,
                        _playerB
                );

                cardsToWin.clear();
            } else {
                System.out.printf("[%4s] %s %s vs %s %s WAR!! %d cards at stake (%s to %s)%n",
                        roundCount,
                        _playerA.getName(),
                        cardA.toString(),
                        _playerB.getName(),
                        cardB.toString(),
                        cardsToWin.size(),
                        _playerA,
                        _playerB
                );
            }
        }

        Player gameWinner = _playerA.numberOfCards() > _playerB.numberOfCards() ? _playerA : _playerB;
        System.out.printf("%s is the Winner!%n", gameWinner.getName());
    }

}
