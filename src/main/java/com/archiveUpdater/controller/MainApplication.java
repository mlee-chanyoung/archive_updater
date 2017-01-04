package com.archiveUpdater.controller;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Main Controller for the application.
 *
 * Created 01/03/2017
 */
public class MainApplication extends Application {

    private Stage window;
    private static final int STAGE_WIDTH = 600;
    private static final int STAGE_HEIGHT = 600;

    /**
     * Starts the application
     *
     * @param args  the main method's arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setStage(primaryStage);
        window.setTitle("Synopsis Archive Updater");
        window.setMinWidth(STAGE_WIDTH);
        window.setMinHeight(STAGE_HEIGHT);
        window.setResizable(false);
        loadInit();
        window.show();
    }

    /**
     * Loads the startup screen onto the window
     */
    public void loadInit() {
        Controller initCtrl = loadFXML("/InitScreen.fxml");
        initCtrl.setApplication(this);
    }

    /**
     * Loads the entry adding screen onto the window.
     */
    public void loadAdd() {
        Controller addCtrl = loadFXML("/AddScreen.fxml");
        addCtrl.setApplication(this);
    }

    /**
     * Gets the application's window.
     *
     * @return the application window
     */
    public Stage getStage() {
        return this.window;
    }

    /**
     * Sets the application's window.
     *
     * @param window  the application window
     */
    public void setStage(Stage window) {
        this.window = window;
    }

    /**
     * Loads an FXML file to update a view inside of a pane.
     *
     * @param fxml  the fxml file to be loaded
     * @return the controller for the fxml file
     */
    private Controller loadFXML(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(this.getClass().getResource(fxml));
        InputStream stream = this.getClass().getResourceAsStream(fxml);
        Pane newView = new Pane();
        try {
            newView = (Pane) loader.load(stream);
        } catch (java.io.IOException e) {
            Logger.getLogger(this.getClass().getName()).log(
                Level.SEVERE, null, e);
        } finally {
            try {
                stream.close();
            } catch (java.io.IOException e) {
                Logger.getLogger(this.getClass().getName()).log(
                    Level.SEVERE, null, e);
            }
        }
        Scene scene = new Scene(newView, STAGE_WIDTH, STAGE_HEIGHT);
        window.setScene(scene);
        window.sizeToScene();
        return (Controller) loader.getController();
    }
}
