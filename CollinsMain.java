//JavaFX Project Chapter 20 - Section 2. Anna Collins

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import java.util.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.LinkedList;


public class CollinsMain extends Application {

    LinkedList<Integer> object = new LinkedList<>();
    TextField _textField = new TextField();
    Label _numLabel = new Label();

    // Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 20, Program 2");
        BorderPane pane = new BorderPane();


        Button sortBtn = new Button("Sort");
        Button shuffleBtn = new Button("Shuffle");
        Button reverseBtn = new Button("Reverse");

        Label _textLabel = new Label("Enter a number");
        HBox hBoxBtn = new HBox(sortBtn, shuffleBtn, reverseBtn);
        HBox topHBox = new HBox(_textLabel, _textField);
        hBoxBtn.setSpacing(10);
        hBoxBtn.setAlignment(Pos.CENTER);
        topHBox.setSpacing(10);
        topHBox.setAlignment(Pos.CENTER);
        pane.setTop(topHBox);
        pane.setCenter(_numLabel);
        pane.setBottom(hBoxBtn);

        _textField.setOnAction(e ->  {
            //when the user hits enter the entered data is processed
            //if found to be a number not entered yet, it will be added to the list
            //if already entered, will be told already entered
            //if not a number will be told it isn't a valid number
            try{
                int userInput = Integer.parseInt(_textField.getText());
               if(!object.contains(userInput)){
                   object.add(userInput);
                   displayLabel();
               }
               else
                   {
                   _numLabel.setText("This number has already been entered!");
                   _textField.setText("");
               }
            }
            catch (NumberFormatException ex) {
                _numLabel.setText("You did not enter a valid numeric number");
                _textField.setText("");

            }
        });

        sortBtn.setOnAction(e -> {
            //Sort button will sort the current list and display the results
            Collections.sort(object);
            displayLabel();
        });

        shuffleBtn.setOnAction(e -> {
            //Shuffle button will Shuffle the current list and display the results
            Collections.shuffle(object);
            displayLabel();

        });

        reverseBtn.setOnAction(e ->{
            //Reverse button will Reverse the current list and display the results
            Collections.reverse(object);
            displayLabel();
        });

        Scene scene = new Scene(pane, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void displayLabel(){
        //Method for the label
        String userInput = "";
        for (Integer x: object){
            userInput += x + " ";
        }
        _numLabel.setText(userInput);
        _textField.setText("");

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
