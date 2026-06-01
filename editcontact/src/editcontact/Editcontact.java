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
import javafx.scene.layout.HBox;
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
        nameField.setPrefWidth(220);

        phoneField = new TextField();
        phoneField.setPromptText("Enter Phone Number");
        phoneField.setPrefWidth(220);

        emailField = new TextField();
        emailField.setPromptText("Enter Email");
        emailField.setPrefWidth(220);
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");

        updateBtn.setPrefWidth(100);
        deleteBtn.setPrefWidth(100);
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
        Label nameLabel = new Label("Name");
        nameLabel.setMinWidth(70);

        HBox nameRow = new HBox(10);
        nameRow.setAlignment(Pos.CENTER);
        nameRow.getChildren().addAll(nameLabel, nameField);
        Label phoneLabel = new Label("Phone");
        phoneLabel.setMinWidth(70);

        HBox phoneRow = new HBox(10);
        phoneRow.setAlignment(Pos.CENTER);
        phoneRow.getChildren().addAll(phoneLabel, phoneField);
        
        Label emailLabel = new Label("Email");
        emailLabel.setMinWidth(70);

        HBox emailRow = new HBox(10);
        emailRow.setAlignment(Pos.CENTER);
        emailRow.getChildren().addAll(emailLabel, emailField);
        HBox buttonRow = new HBox(20);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.getChildren().addAll(updateBtn, deleteBtn);
         VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        Label title = new Label("Edit Contact");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        root.getChildren().addAll(
                title,
                profileImageView,
                photoBtn,
                nameRow,
                phoneRow,
                emailRow,
                buttonRow
        );

        Scene scene = new Scene(root, 450, 550);

        primaryStage.setTitle("Edit Contact");
        primaryStage.setScene(scene);
        primaryStage.show();
   }

       
        public static void main(String[] args) {
        launch(args);
    }
    
}
