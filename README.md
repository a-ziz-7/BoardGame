# GoHome Game

## Overview

The GoHome Game is a simple board game implemented in Java. It can be played with 2 to 4 players, and the objective is to reach or pass the "home" square first. The game features a game board with obstacles, player pieces, and a deck of cards that influence player movement and actions. Players take turns drawing cards and following instructions to move forward, backward, or perform special actions like losing a turn or swapping places with another player.

This README provides an overview of the game's functionality, how to play it, and how to set up and run the game.

## Features

- 2 to 4 players can participate in a game.
- The game board consists of a customizable number of squares, with obstacles that can impact player progress.
- Players draw cards from a deck, and each card contains instructions for movement or actions.
- The player with the shortest name gets the first turn.
- Obstacles on the board can set back players by a certain number of spaces.

## How to Play

1. The game starts with each player at position 0 on the board.
2. Players take turns in order, with the player who has the shortest name going first.
3. On each turn, a player draws a card from the deck, which contains instructions:
   - If the card has a number from 1 to 4, the player moves forward by that number of spaces.
   - If the card says "Lose a turn," the player's turn is skipped.
   - If the card says "Switch places with another player," the player can choose another player to swap positions with.
4. If a player lands on an obstacle, they move backward by a specific number of spaces.
5. The game continues until a player reaches or passes the "home" square.

## Getting Started

1. Clone the GoHome Game repository to your local machine.
2. Ensure you have Java installed on your computer.
3. Compile the Java source files.
