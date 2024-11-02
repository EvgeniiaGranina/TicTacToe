package com.example.tictactoe.model;

public class Model {
    private final char[] board = new char[9];
    private static final char player1Symbol = 'X';
    private static final char player2Symbol = 'O';

    public  Model() {

    }

    public boolean nextMove(int index, int playerNumber)  {
        if(index >= 0 && index < board.length) {
            if (board[index] == 0) {

                board[index] = playerNumber == 0 ? player1Symbol : player2Symbol;
                checkGameIsOver();
                UpdateGameBoard();
                return true;
            }
            else
                return false;
        } else {
            return false;
        }
    }

    private void UpdateGameBoard() {

    }

    private void checkGameIsOver() {


    }

    public char[] getBoard() {
        return board;
    }
}
