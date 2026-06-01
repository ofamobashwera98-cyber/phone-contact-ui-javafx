/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package editcontact;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Editcontact extends Application {
        TextField nameField;
        TextField phoneField;
        TextField emailField;
        ImageView profileImageView;
        
    @Override
    public void start(Stage primaryStage) {
        profileImageView = new ImageView();

        profileImageView.setFitWidth(120);
        profileImageView.setFitHeight(120);
        
        Image defaultImage = new Image("file:profile.png");
        profileImageView.setImage(defaultImage);
        Button photoBtn = new Button("Change Photo");

        photoBtn.setOnAction(e -> {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Profile Photo");

            File file = fileChooser.showOpenDialog(primaryStage);

            if (file != null) {
                Image image = new Image(file.toURI().toString());
                profileImageView.setImage(image);
            }
        });

        nameField = new TextField();
        nameField.setPromptText("Enter Name");

        phoneField = new TextField();
        phoneField.setPromptText("Enter Phone");

        emailField = new TextField();
        emailField.setPromptText("Enter Email");

        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");
        updateBtn.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Updated");
            alert.setHeaderText(null);
            alert.setContentText("Contact Updated Successfully!");
            alert.showAndWait();
        });
        deleteBtn.setOnAction(e -> {
            nameField.clear();
            phoneField.clear();
            emailField.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deleted");
            alert.setHeaderText(null);
            alert.setContentText("Contact Deleted!");
            alert.showAndWait();
        });
         VBox root = new VBox(15);
         root.setAlignment(Pos.CENTER);

         root.getChildren().addAll(
                new Label("Edit Contact"),
                profileImageView,
                photoBtn,
                new Label("Name"),
                nameField,
                new Label("Phone"),
                phoneField,
                new Label("Email"),
                emailField,
                updateBtn,
                deleteBtn
         );
        Scene scene = new Scene(root, 400, 650);
        primaryStage.setTitle("Edit Contact");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
