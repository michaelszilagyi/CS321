import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.layout.GridPane;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class MainScreen extends Application {

        private static Stage mainStage;
        private static Scene mainScene;
        
        public static void main(String[] args){
                launch(args);
        }

        //Used in order to get back to this main menu screen
        public static Stage getStage(){
                return mainStage;
        }

        //Same as above
        public static Scene getScene(){
                return mainScene;
        }

        @Override
        public void start(Stage primaryStage) {
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(10, 10, 10, 10));
                grid.setVgap(15);
                grid.setHgap(15);

                //Setting up the main menu screen
                primaryStage.setTitle("Main Screen");
                Label topLabel = new Label();
                topLabel.setText("Main Screen");
                topLabel.setFont(new Font("Montserrat", 24));
                GridPane.setConstraints(topLabel, 0, 0);
                grid.getChildren().add(topLabel);

                //HOME BUTTON
                Button DE = new Button("Data Entry");
                GridPane.setConstraints(DE, 0, 2);
                DE.setMaxWidth(100);
                grid.getChildren().add(DE);
                DE.setOnAction(e -> primaryStage.setScene(DE_screen.getScene()));

                Scene ourScene = new Scene(grid, 800, 600);
                mainStage = primaryStage;
                mainScene = ourScene;

                //set our screen to the DE scene
                primaryStage.setScene(ourScene);
                primaryStage.show();

        }   

}