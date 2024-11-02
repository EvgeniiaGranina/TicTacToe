package com.example.tictactoe.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.example.tictactoe.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    private int nowSym = 0;
    private Button[] buttons;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8;

    @FXML
    void btnClick(ActionEvent event) {

        nowSym = (nowSym == 1) ? 0 : 1;
        int index = Arrays.asList(buttons).indexOf((Button)event.getSource());
        model.nextMove(index, nowSym);
        updateBoard();
    }

    private void updateBoard() {
        char[] board = model.getBoard();
        for (int i = 0; i < board.length; i++) {
                buttons[i].setText(String.valueOf(board[i]));
        }
    }

    private Model model = new Model();

    public Model getModel() {
        return model;
    }

    @FXML
    void initialize() {
        buttons = new Button[]{button0, button1, button2, button3, button4, button5, button6, button7, button8};
    }

}
