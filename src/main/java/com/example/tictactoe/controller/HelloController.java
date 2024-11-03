package com.example.tictactoe.controller;

import com.example.tictactoe.model.GameState;
import com.example.tictactoe.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

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


        int index = Arrays.asList(buttons).indexOf((Button)event.getSource());
        GameState success = model.nextMove(index, nowSym);

        switch (success) {
            case NEXT_MOVE -> {
                nowSym = (nowSym == 1) ? 0 : 1;
                updateBoard();
            }
            case GAME_WON -> {
                updateBoard();
                informationAlert("You are won!");
                //resetGame();
            }
            case GAME_OVER -> {
                updateBoard();
                informationAlert("The game is tied!");
                //resetGame();
            }
        }
    }

    private void informationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game results");
        alert.setHeaderText(null);
        alert.setContentText(message);

        ButtonType buttonType = new ButtonType("New game");
        alert.getButtonTypes().setAll(buttonType);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonType) {
            model.resetBoard();
            nowSym = 0;
            updateBoard();
        } else {
            //Exit from game
        }
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
