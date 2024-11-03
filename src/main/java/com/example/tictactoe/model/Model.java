package com.example.tictactoe.model;

import javafx.scene.control.Button;

import java.util.Arrays;

public class Model {
    private final char[] board = new char[9];
    private static final char player1Symbol = 'X';
    private static final char player2Symbol = 'O';
    private static final char clearCellSymbol = 0;

    public  Model() {
        resetBoard();
    }

    public GameState nextMove(int index, int playerNumber)  {
        if(index >= 0 && index < board.length) {
            if (board[index] == clearCellSymbol) {

                board[index] = playerNumber == 0 ? player1Symbol : player2Symbol;
                if (CheckWin())
                    return GameState.GAME_WON;
                if (CheckGameIsOver())
                    return GameState.GAME_OVER;
                return GameState.NEXT_MOVE;
            }
            else
                return GameState.IDLE;
        } else {
            return GameState.IDLE;
        }
    }
    private final  int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public boolean CheckWin() {

        for (int[] condition : winConditions) {
            System.out.println(board[condition[0]] + " " + board[condition[1]] + " " + board[condition[2]]);
            if (board[condition[0]] != clearCellSymbol &&
                    board[condition[0]] == board[condition[1]] &&
                    board[condition[1]] == board[condition[2]]) {
                return true;
            }
        }
        System.out.println("-------");
        return false;
    }


    public boolean CheckGameIsOver() {
        for (char c : board) {
            if (c == clearCellSymbol) {
                return false;
            }
        }
        return true;

    }
    public void resetBoard() {
        Arrays.fill(board, clearCellSymbol);
    }

    public char[] getBoard() {
        return board;
    }
}
