package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

  private int gameType;
  private Player player1;
  private Player player2;
  private int intMove1 = 0;
  private int intMove2 = 0;
  private int tie = 0; //implement history
  private boolean gameOver = false;


  public Game(int gameType) {


      player1 = new Player(1);

      //determine player 2
      if (gameType == 1) {
        player2 = new Player(1);
      }
      else {
        player2 = new Player(2);
      }

      while (!gameOver) {

          intMove1 = player1.playerMove();
          gameOver = Player.isGameEnds();

          if (!gameOver) {
            intMove2 = player2.playerMove();
            gameOver = Player.isGameEnds();
            if (!gameOver) {

              //determine winner
              if (intMove1 == intMove2) {
                System.out.println("Tie");
                tie++; //implement history
              } else {
                if ((intMove1 == 2) || (intMove2 == 2)) {
                  if (intMove1 == 2) {
                    if (intMove2 == 0) {
                      player2.setWin(1);
                      System.out.println("Player 2 wins");
                    } else {
                      player1.setWin(1);
                      System.out.println("Player 1 wins");
                    }
                  } else {
                    if (intMove1 == 0) {
                      player1.setWin(1);
                      System.out.println("Player 1 wins");
                    } else {
                      player2.setWin(1);
                      System.out.println("Player 2 wins");
                    }
                  }
                } else {
                  if (intMove1 > intMove2) {
                    player1.setWin(1);
                    System.out.println("Player 1 wins");
                  } else {
                    player2.setWin(1);
                    System.out.println("Player 2 wins");
                  }
                }
              }
            }
          }
      }
  }
}
