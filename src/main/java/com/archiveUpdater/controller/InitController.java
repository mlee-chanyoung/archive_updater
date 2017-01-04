package com.archiveUpdater.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controller for the initial startup screen.
 *
 * Create 01/04/2017
 */
public class InitController extends Controller {

    @FXML private Button addButton;
    @FXML private Button updateButton;
    @FXML private Button exitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    /**
     * Exits the application.
     *
     * @param e  the event that triggers the action
     */
    @FXML
    public void exitApp(ActionEvent e) {
        getApplication().getStage().close();
    }
}