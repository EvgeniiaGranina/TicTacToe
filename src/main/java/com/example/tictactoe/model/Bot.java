package com.example.tictactoe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {

    private final Model gameModel;

    public Bot(Model gameModel) {
        this.gameModel = gameModel;
    }

    public GameState makeBotMove(int playerId) {
        char[] board = gameModel.getBoard();
        List<Integer> availablePositions = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == Model.clearCellSymbol) {
                availablePositions.add(i);
            }
        }

        if (!availablePositions.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(availablePositions.size());
            int position = availablePositions.get(randomIndex);
             return gameModel.nextMove(position, playerId);
        } else {
            return GameState.GAME_OVER;
        }
    }
}
