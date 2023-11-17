import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.lang.reflect.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.application.Platform;
import javafx.geometry.*;
import javafx.collections.*;

public class Approval extends Application {
   private static Declaration dec;
   private static int times_called;

   private static Declaration make_test_decl() {

      if(times_called == 0) {
         times_called++;
         return new Declaration("2/27/1990", "Faustino Freidman", "Faustino@Freidman.gmail.com",
            12, 11111, "Quinn Brade",
               222222, false, 1313131);
      } else {
         return new Declaration("7/15/1985", "Weldon Grigg", "Weldon@Grigg.gmail.com",
         6, 11551, "Ty Perilli",
         333333, false, 13565);
      }
   }
   /*
   private Node getByUserData(Parent parent, Object data) {
      for (Node n : parent.getChildren()) {
          if (data.equals(n.getUserData())) {
              return n;
          }
      }
      return null;
   }
   */
   //precondition: dec must have been instantiated
    @Override
    public void start(Stage primaryStage) {
      primaryStage.setTitle("Approval");

      // Create a Vbox to organize the elements vertically
      var vbox = new VBox(10);

      var gnb_name = "getNextButton";

      // Create an approval button
      Button approveButton = new Button("Approve");
      approveButton.setOnAction(e -> {
         //var getNextButton = getByUserData(vbox, "getNextButton");
         //clear previous declaration

         Button oldNextButton = null;
         for (Node n : vbox.getChildren()) {
            if (gnb_name.equals(n.getUserData())) {
               oldNextButton = (Button) n;
            }
         }
         vbox.getChildren().clear();

         //add the get next button
         vbox.getChildren().add(oldNextButton);

         //to add during next sprint
      });

      //create a rejection button
      Button rejectButton = new Button("Reject");
      rejectButton.setOnAction(e -> {
         //var getNextButton = getByUserData(vbox, "getNextButton");

         Button oldNextButton = null;
         for (Node n : vbox.getChildren()) {
            if (gnb_name.equals(n.getUserData())) {
               oldNextButton = (Button) n;
            }
         }

         //clear previous declaration
         vbox.getChildren().clear();

         //add the get next button
         vbox.getChildren().add(oldNextButton);

         //to add during next sprint
      });

      // Create getNext button
      Button getNextButton = new Button("Get Next");
      getNextButton.setUserData("getNextButton");

      getNextButton.setOnAction(unused -> {
         
         //clear previous declaration
         vbox.getChildren().clear();

         //add the get next button
         vbox.getChildren().add(getNextButton);


         //todo next sprint: obtain next declaration
         dec = make_test_decl();

         // Create text that displays fields of declaration
         var dec_fields = Declaration.class.getFields();
         var text_fields = new ArrayList<Label>();
         for(Field field : dec_fields) {
            Object f;

            try { f = field.get(dec); } catch (Exception e) { continue; }

            var name = field.getName();
            name = name.replaceAll("(\\p{Lower})(\\p{Upper})","$1 $2");
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            var format = ": ";
            Label l = null;
            String elem = null;
            if (f instanceof String) {
               elem = (String) f;

            } else if (f instanceof Integer) {
               elem = Integer.toString((Integer) f);

            } else if (f instanceof Boolean) {
               elem = Boolean.toString((Boolean) f);
            } else {
               //shouldn't run in the current version of the code, but here for safety
               continue;
            }
            l = new Label(name + format + elem);
            l.setFont(new Font("Montserrat", 24));
            text_fields.add(l);
         }

         // Add the declaration fields to the vbox
         for (var f : text_fields) {
            vbox.getChildren().add(f);
         }

         //add approval and reject buttons
         vbox.getChildren().add(approveButton);
         vbox.getChildren().add(rejectButton);
      });

      vbox.getChildren().add(getNextButton);

      var backgroundFill = new BackgroundFill(Color.LIGHTBLUE, null, null);
      var bg = new Background(backgroundFill);
      vbox.setBackground(bg);
      // Create the scene and set it on the stage
      Scene scene = new Scene(vbox, 400, 510);
      primaryStage.setScene(scene);

      // Show the stage
      primaryStage.show();
    }

    public static void main(String[] args) {
      launch();
    }

}