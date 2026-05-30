package profile_view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Profile_View extends Application {

    @Override
    public void start(Stage primaryStage) {
        
    }

    public static void profile(String name, String phone, String email) {

        // profile window creation
        Stage profileStage = new Stage();

        // Labels
        Label title = new Label("View Profile");

        Label nameLabel = new Label(
                "Name: " + name
        );

        Label phoneLabel = new Label(
                "Phone: " + phone
        );

        Label emailLabel = new Label(
                "Email: " + email
        );
        //button for edit contact
        Button editButton = new Button("Edit");
        editButton.setStyle ( "-fx-font-size: 14px;"
        );


        // Layout
        VBox layout = new VBox(10);        
         layout.setStyle(
                "-fx-padding: 20;" +
                "-fx-alignment: center;"
        );

        layout.getChildren().addAll(title,
                nameLabel,               
                phoneLabel,
                emailLabel,editButton );

        Scene scene = new Scene(layout, 300, 200);
        profileStage.setTitle("Profile View");
         
        // Set scene
        profileStage.setScene(scene);
        profileStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}