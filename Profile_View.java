/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Profile_View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Profile_View extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    public static void profile(String name, String phone, String email) {

        Stage profileStage = new Stage();

        // Title
        Label title = new Label("Profile");
        title.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        // Profile Image
        Image image = new Image("file:my_profile.jpg");
        ImageView imageView = new ImageView();

        if (!image.isError()) {
            imageView.setImage(image);
        } else {
            System.out.println("Image load failed! Check file path.");
        }

        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        imageView.setPreserveRatio(true);

        // Labels
        Label nameLabel = new Label("👤  " + name);
        Label phoneLabel = new Label("📞  " + phone);
        Label emailLabel = new Label("✉  " + email);

        nameLabel.setStyle("-fx-font-size: 16px;");
        phoneLabel.setStyle("-fx-font-size: 16px;");
        emailLabel.setStyle("-fx-font-size: 16px;");

        // Buttons
        Button editButton = new Button("Edit");
        Button callButton = new Button("Call");
        
        HBox rowBar = new HBox(10);
        rowBar.setAlignment(Pos.CENTER);
        rowBar.getChildren().addAll(editButton, callButton);

        // Layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.TOP_CENTER);

        layout.setStyle(
                "-fx-padding: 20;" +
                "-fx-background-color: white;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"
        );

        layout.getChildren().addAll(
                imageView,
                title,
                nameLabel,
                phoneLabel,
                emailLabel,
                rowBar
        );

        Scene scene = new Scene(layout, 400, 550);

        profileStage.setTitle("Profile View");
        profileStage.setScene(scene);
        profileStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}