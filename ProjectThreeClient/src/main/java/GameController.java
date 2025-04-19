/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameController {
    @FXML
    private TextField playerOneName;
    @FXML
    private TextField playerTwoName;
    @FXML
    private Button savePlayerOneButton;
    @FXML
    private Button savePlayerTwoButton;
    @FXML
    private Button startGameButton;

    private Stage stage; // Reference to the main stage

    // Method to set the stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleSavePlayerOne() {
        if (savePlayerOneButton.getText().equals("Save")) {
            if (!playerOneName.getText().trim().isEmpty() && !playerOneName.getText().equals(playerTwoName.getText())) {
                savePlayerOneButton.setText("Edit");
                playerOneName.setDisable(true);
                checkStartGameCondition(); // Check if both players' names are saved
            }
        } else {
            savePlayerOneButton.setText("Save");
            playerOneName.setDisable(false);
        }
    }

    @FXML
    public void handleSavePlayerTwo() {
        if (savePlayerTwoButton.getText().equals("Save")) {
            if (!playerTwoName.getText().trim().isEmpty() && !playerTwoName.getText().equals(playerOneName.getText())) {
                savePlayerTwoButton.setText("Edit");
                playerTwoName.setDisable(true);
                checkStartGameCondition(); // Check if both players' names are saved
            }
        } else {
            savePlayerTwoButton.setText("Save");
            playerTwoName.setDisable(false);
        }
    }

    @FXML
    public void startGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameplay.fxml"));
            Parent gameplayRoot = loader.load();

            // Get the GameplayController and pass player names
            GameplayController gameplayController = loader.getController();
            gameplayController.setPlayerNames(playerOneName.getText(), playerTwoName.getText());

            Scene gameplayScene = new Scene(gameplayRoot);
            stage.setScene(gameplayScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load the gameplay screen.");
        }
    }

    @FXML
    public void exitGame() {
        System.exit(0);
    }

    // Method to check if both player names are valid and saved
    private void checkStartGameCondition() {
        if (!playerOneName.getText().trim().isEmpty() && 
            !playerTwoName.getText().trim().isEmpty() && 
            savePlayerOneButton.getText().equals("Edit") &&
            savePlayerTwoButton.getText().equals("Edit")) {
            startGameButton.setDisable(false); // Enable the start button if both names are saved and valid
        } else {
            startGameButton.setDisable(true);
        }
    }
}
