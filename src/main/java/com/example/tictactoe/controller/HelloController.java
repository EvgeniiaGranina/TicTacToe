package com.example.tictactoe.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {
    private char nowSym = 'x';
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void btnClick(ActionEvent event) {

        ((Button)event.getSource()).setText(String.valueOf(nowSym));
        nowSym = (nowSym == 'x') ? 'o' : 'x';
    }

    @FXML
    void initialize() {

    }

}
