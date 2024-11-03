package com.example.tictactoe.model;

public class Model {
    private final char[] board = new char[9];
    private static final char player1Symbol = 'X';
    private static final char player2Symbol = 'O';

    public  Model() {

    }

    public GameState nextMove(int index, int playerNumber)  {
        if(index >= 0 && index < board.length) {
            if (board[index] == 0) {

                board[index] = playerNumber == 0 ? player1Symbol : player2Symbol;
                if (CheckGameIsOver())
                    return GameState.GAME_OVER;
                if (CheckWin())
                    return GameState.GAME_WON;
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
        char[] board = getBoard();

        for (int[] condition : winConditions) {
            if (board[condition[0]] != 0 &&
                    board[condition[0]] == board[condition[1]] &&
                    board[condition[1]] == board[condition[2]]) {
                return true;
            }
        }
        return false;
    }


    public boolean CheckGameIsOver() {
        for (char c : board) {
            if (c == 0) {
                return false;
            }
        }
        return true;

    }

    public char[] getBoard() {
        return board;
    }
}
