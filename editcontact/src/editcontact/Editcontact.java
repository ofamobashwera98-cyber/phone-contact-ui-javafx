/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package editcontact;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
