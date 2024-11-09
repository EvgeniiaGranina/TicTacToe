package com.example.tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ModelTest {
    private Model model;

    @BeforeEach
    void setUp() {
        model = new Model();
        model.resetBoard();
    }

    @Test
    void testHorizontalWin() {
        model.nextMove(6, 0);
        model.nextMove(7, 0);
        model.nextMove(8, 0);
        assertTrue(model.CheckWin('X'));
    }

    @Test
    void testVerticalWin() {
        model.nextMove(1, 1);
        model.nextMove(4, 1);
        model.nextMove(7, 1);
        assertTrue(model.CheckWin('O'));
    }

    @Test
    void testDiagonalWin() {
        model.nextMove(2, 1);
        model.nextMove(4, 1);
        model.nextMove(6, 1);
        assertTrue(model.CheckWin('O'));
    }

    @Test
    void testDraw() {
        model.nextMove(0, 0);
        model.nextMove(1, 1);
        model.nextMove(2, 0);
        model.nextMove(3, 1);
        model.nextMove(4, 0);
        model.nextMove(5, 1);
        model.nextMove(6, 1);
        model.nextMove(7, 0);
        model.nextMove(8, 1);
        assertTrue(model.CheckGameIsOver());
    }
}
