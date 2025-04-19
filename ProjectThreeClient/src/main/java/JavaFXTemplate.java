/*
 * CS342 Fall 2024
 * Burak Simsek
 * 3-Card Poker Game
 * Project #2
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.IOException; // Add this import

public class JavaFXTemplate extends Application {

    // Main stage reference for scene transitions
    private Stage primaryStage;

    // Player and Dealer instances for game tracking
    private Player playerOne;
    private Player playerTwo;
    private Dealer theDealer;

    public JavaFXTemplate() {
        // Initialize player and dealer instances
        playerOne = new Player();
        playerTwo = new Player();
        theDealer = new Dealer();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;

            // Load the initial welcome screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
            Parent welcomeRoot = loader.load();

            // Get the controller and set the stage
            GameController gameController = loader.getController();
            gameController.setStage(primaryStage);

            // Create a scene and add the CSS file
            Scene welcomeScene = new Scene(welcomeRoot, 800, 600); // Adjust width and height as needed
            welcomeScene.getStylesheets().add(getClass().getResource("/default.css").toExternalForm()); // Apply default CSS

            primaryStage.setTitle("3 Card Poker");
            primaryStage.setScene(welcomeScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load the welcome screen.");
        }
    }

    // Method to transition to the gameplay scene
    public void loadGameScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameplay.fxml"));
            Parent gameRoot = loader.load();
            Scene gameScene = new Scene(gameRoot, 1000, 800); // Adjust width and height as needed
            gameScene.getStylesheets().add(getClass().getResource("default.css").toExternalForm()); // Apply default CSS

            // Set up the menu bar
            BorderPane root = new BorderPane(gameRoot);
            root.setTop(createMenuBar(gameScene));

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load the gameplay screen.");
        }
    }

    // Method to create a menu bar with options
    private MenuBar createMenuBar(Scene scene) {
        MenuBar menuBar = new MenuBar();
        Menu optionsMenu = new Menu("Options");

        // Exit option
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> primaryStage.close());

        // Fresh Start option (reset winnings and reload the welcome screen)
        MenuItem freshStartItem = new MenuItem("Fresh Start");
        freshStartItem.setOnAction(e -> {
            playerOne = new Player();
            playerTwo = new Player();
            try {
                start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // New Look option (apply alternative CSS)
        MenuItem newLookItem = new MenuItem("New Look");
        newLookItem.setOnAction(e -> {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/newlook.css").toExternalForm());
        });

        // Default Look option (revert to default CSS)
        MenuItem defaultLookItem = new MenuItem("Default Look");
        defaultLookItem.setOnAction(e -> {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/default.css").toExternalForm());
        });

        optionsMenu.getItems().addAll(exitItem, freshStartItem, newLookItem, defaultLookItem);
        menuBar.getMenus().add(optionsMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
