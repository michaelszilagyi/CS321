import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.layout.GridPane;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;


 
public class DE_screen extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        //create the grid to hold all the elements
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        //Title label
        primaryStage.setTitle("Data Entry");
        Label topLabel = new Label();
        topLabel.setText("Data Entry");
        topLabel.setFont(new Font("Montserrat", 24));
        GridPane.setConstraints(topLabel, 0, 0);
        grid.getChildren().add(topLabel);

        //NAME FIELD
        TextField name = new TextField();
        name.setPromptText("Enter your name. (First Last)");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 1);
        grid.getChildren().add(name);

        //DATE FIELD
        TextField date = new TextField();
        date.setPromptText("Enter the date. (MM/DD/YYYY)");
        GridPane.setConstraints(date, 0, 2);
        grid.getChildren().add(date);

        //EMAIL FIELD
        TextField email = new TextField();
        email.setPrefColumnCount(15);
        email.setPromptText("Enter your email.");
        GridPane.setConstraints(email, 0, 3);
        grid.getChildren().add(email);

        //DURATION FIELD
        TextField duration = new TextField();
        duration.setPrefColumnCount(15);
        duration.setPromptText("Enter the duration of your support. (Months)");
        GridPane.setConstraints(duration, 0, 4);
        grid.getChildren().add(duration);
        grid.getColumnConstraints().add(new ColumnConstraints(350));

        //APPLICANT NUMBER FIELD
        TextField appnum = new TextField();
        appnum.setPrefColumnCount(15);
        appnum.setPromptText("Enter your applicant number. (12 Digits)");
        GridPane.setConstraints(appnum, 0, 5);
        grid.getChildren().add(appnum);

        //IMMIGRANT NAME NUMBER FIELD
        TextField iname = new TextField();
        iname.setPrefColumnCount(15);
        iname.setPromptText("Enter immigrant name. (First Last)");
        GridPane.setConstraints(iname, 0, 6);
        grid.getChildren().add(iname);

        //ALIEN NUMBER NUMBER FIELD
        TextField anum = new TextField();
        anum.setPrefColumnCount(15);
        anum.setPromptText("Enter alien number. (8 digits)");
        GridPane.setConstraints(anum, 0, 7);
        grid.getChildren().add(anum);

        //SUBMIT BUTTON
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 0, 8);
        grid.getChildren().add(submit);

        //ERROR LABEL
        Label errorLabel = new Label();
        GridPane.setConstraints(errorLabel, 0, 9);
        GridPane.setColumnSpan(errorLabel, 2);
        grid.getChildren().add(errorLabel);

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
                public void handle(ActionEvent e) {
                    if ((appnum.getText() != null && !appnum.getText().isEmpty())) {
                        errorLabel.setText(name.getText() + " " + date.getText() + ", "
                            + "Your declaration has been submitted successfully. Have a great day!");
                    } else {
                        errorLabel.setText("You are missing the Applicant Number");
                    }
                }
            });

        grid.setAlignment(Pos.CENTER);

        Platform.runLater(() -> grid.requestFocus());

        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, null, null);
        Background background = new Background(backgroundFill);
        grid.setBackground(background);

        primaryStage.setScene(new Scene(grid, 600, 500));
        primaryStage.show();
    }
}

