
package PhoneContactUI1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContactListPage extends Application {

    @Override
    public void start(Stage primaryStage) { 
        Label l = new Label("Contact List");
        BorderPane root = new BorderPane();
        //layout
        VBox main = new VBox(20);
        main.setPadding(new Insets(20));
        
        //search bar
        TextField search = new TextField();

        search.setPromptText("Search Contacts");

        search.setPrefHeight(45);

        HBox buttonRow = new HBox(10);
        
        //all the buttons
        Button allBtn = new Button("All");
        Button Add = new Button("Add Contacts");
        
        buttonRow.getChildren().addAll(allBtn,Add);

        main.getChildren().addAll(l,search,buttonRow);

        root.setCenter(main);

        Scene scene = new Scene(root, 450, 750);

        primaryStage.setTitle("Phone Contact UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
