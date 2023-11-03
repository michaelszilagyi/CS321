import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;

public class Review_Screen extends Application {
    /* TEMPORARY HARDCODED EXAMPLES */
    private Declaration dec1 = new Declaration("01/01/2001", "hiba", "hiba@gmail.com", 1, 1, "awan", 123, false, 321);
    private Declaration dec2 = new Declaration("02/02/2002", "mehr", "mehr@gmail.com", 2, 2, "bano", 456, false, 654);
    private Declaration dec3 = new Declaration("03/03/2003", "ayra", "ayra@gmail.com", 3, 3, "aslam", 789, false, 987);
    private Declaration[] decs = {dec1, dec2, dec3};
    private int decIndex = 0;
    
    @Override
    public void start(Stage primaryStage){
        /* SET WINDOW TITLE */
        primaryStage.setTitle("Review Screen");

        /* MAIN VBOX CONTAINING ALL LAYOUTS */
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(10);

        /* CREATE A TITLE LABEL */
        Label titleLabel = new Label("Review");
        titleLabel.setFont(Font.font("Open Sans", 20));
        VBox titleBox = new VBox();
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().add(titleLabel);
        root.getChildren().add(titleBox);

        /* CREATE GRID HOLDING ALL FIELDS */
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(10);

        /* CREATE LABELS */
        Label nameLabel = new Label("Name");
        nameLabel.setFont(Font.font("Open Sans", 14));
        Label dateLabel = new Label("Date");
        dateLabel.setFont(Font.font("Open Sans", 14));
        Label emailLabel = new Label("Email");
        emailLabel.setFont(Font.font("Open Sans", 14));
        Label durationLabel = new Label("Support Duration");
        durationLabel.setFont(Font.font("Open Sans", 14));
        Label appNumLabel = new Label("Applicant Number");
        appNumLabel.setFont(Font.font("Open Sans", 14));
        Label immigrantLabel = new Label("Immigrant Name");
        immigrantLabel.setFont(Font.font("Open Sans", 14));
        Label alienNumLabel = new Label("Alien Number");
        alienNumLabel.setFont(Font.font("Open Sans", 14));

        /* CREATE ASSOCIATED TEXT FIELDS */
        TextField nameField = new TextField(decs[decIndex].name);
        nameField.setFont(Font.font("Open Sans", 13));
        TextField dateField = new TextField(decs[decIndex].date);
        dateField.setFont(Font.font("Open Sans", 13));
        TextField emailField = new TextField(decs[decIndex].email);
        emailField.setFont(Font.font("Open Sans", 13));
        TextField durationField = new TextField(String.valueOf(decs[decIndex].durationOfSupport));
        durationField.setFont(Font.font("Open Sans", 13));
        TextField appNumField = new TextField(String.valueOf(decs[decIndex].applicantNumber));
        appNumField.setFont(Font.font("Open Sans", 13));
        TextField immigrantField = new TextField(String.valueOf(decs[decIndex].immigrantName));
        immigrantField.setFont(Font.font("Open Sans", 13));
        TextField alienNumField = new TextField(String.valueOf(decs[decIndex].alienNumber));
        alienNumField.setFont(Font.font("Open Sans", 13));

        /* SET ALIGNMENT OF FIELDS */
        nameField.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        dateField.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        emailField.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        durationField.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        appNumField.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        immigrantField.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        alienNumField.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);

        /* ADD EVERYTHING TO GRIDPLANE */
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(dateLabel, 0, 1);
        grid.add(dateField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(durationLabel, 0, 3);
        grid.add(durationField, 1, 3);
        grid.add(appNumLabel, 0, 4);
        grid.add(appNumField, 1, 4);
        grid.add(immigrantLabel, 0, 5);
        grid.add(immigrantField, 1, 5);
        grid.add(alienNumLabel, 0, 6);
        grid.add(alienNumField, 1, 6);

        /* ADD GRID UNDERNEATH THE TITLE */
        root.getChildren().add(grid);

        /* SUBMIT BUTTON */
        Button submit = new Button("Submit");
        grid.add(submit, 0, 7);

        /* RESULT LABEL */
        Label resultLabel = new Label();
        grid.add(resultLabel, 1, 7);

        /* SUBMIT BUTTON ACTIONS */
        submit.setOnAction(e -> {

            TextField[] textFields = {nameField, dateField, emailField, durationField, appNumField, immigrantField, alienNumField};

            /* CHECK FOR EMPTY FIELDS */
            for (int i = 0; i < textFields.length; i++){
                if (textFields[i].getText().isEmpty()){
                    resultLabel.setText("Field missing info");
                }
            }

            if (decIndex < decs.length-1){
                /* Result message when declaration is submitted */
                resultLabel.setText("declaration " + appNumField.getText() + " submitted");
                
                /* in actual implementation declarations will be updated */

                /* Move to next declaration */
                decIndex++;

                /* Fill text feilds with new info */
                nameField.setText(decs[decIndex].name);
                dateField.setText(decs[decIndex].date);
                emailField.setText(decs[decIndex].email);
                durationField.setText(String.valueOf(decs[decIndex].durationOfSupport));
                appNumField.setText(String.valueOf(decs[decIndex].applicantNumber));
                immigrantField.setText(decs[decIndex].immigrantName);
                alienNumField.setText(String.valueOf(decs[decIndex].alienNumber));
            } else {
                /* REsult message when no more delcarations */
                resultLabel.setText("all available declarations have been submitted");

                /* Make all text fields disabled */
                for (TextField field : textFields){
                    field.setDisable(true);
                }
            }

        });

        /* SET BACKGROUND */
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);


        /* CREATE SCRENE */
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);

        /* SHOW WINDOW */
        primaryStage.show();

    }
    public static void main( String[] args )
    {
        launch(args);
    }
}

