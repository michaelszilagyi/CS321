import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.lang.reflect.*;

public class Approval extends Application {
   private Declaration dec;

   private Declaration make_test_decl() {
      return new Declaration("2/27/1990", "Faustino Freidman", "Faustino@Freidman.gmail.com",
         12, 11111, "Miguelina Thursby",
         222222, false, 1313131);
   }


   //precondition: dec must have been instantiated
    @Override
    public void start(Stage primaryStage) {
      primaryStage.setTitle("Approval");

      //Create a GridPane to organize the form elements
      GridPane grid = new GridPane();

      grid.setHgap(12);
      grid.setVgap(15);

      // Create text that displays fields of declaration
      var dec_fields = Declaration.class.getFields();
      var text_fields = new ArrayList<TextField>();
      for(Field field : dec_fields) {
         Object f;

         try { f = field.get(dec); } catch (Exception e) { continue; }

         if (f instanceof String) {
            text_fields.add(new TextField(field.getName() + f));
         } else if (f instanceof Integer) {
            String num = Integer.toString((Integer) f);
            text_fields.add(new TextField(field.getName() + num));
         } else if (f instanceof Boolean) {
            String cond = 
            text_fields.add(field.getName() + f);
         }
         var name = field.getName();

      }

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
      dec = make_test_decl();
      launch();
    }

}