import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Approval extends Application {

    @Override
    public void start(Stage primaryStage) {
      primaryStage.setTitle("Form Document");

      // Create a GridPane to organize the form elements
      GridPane grid = new GridPane();
      grid.setHgap(10);
      grid.setVgap(10);

      // Create labels and text fields for the form
      Label nameLabel = new Label("Name:");
      TextField nameField = new TextField();

      Label emailLabel = new Label("Email:");
      TextField emailField = new TextField();

      // Add the elements to the GridPane
      grid.add(nameLabel, 0, 0);
      grid.add(nameField, 1, 0);
      grid.add(emailLabel, 0, 1);
      grid.add(emailField, 1, 1);

      // Create a Submit button
      Button submitButton = new Button("Submit");
      submitButton.setOnAction(e -> {
          // Handle the form submission here
          String name = nameField.getText();
          String email = emailField.getText();
          // Perform actions with the form data
          System.out.println("Name: " + name);
          System.out.println("Email: " + email);
      });

      // Add the Submit button to the GridPane
      grid.add(submitButton, 1, 2);

      // Create the scene and set it on the stage
      Scene scene = new Scene(grid, 300, 150);
      primaryStage.setScene(scene);

      // Show the stage
      primaryStage.show();
    }

    public static void main(String[] args) {
      launch();
    }

}