package profile_view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
        
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.TOP_RIGHT);
        topBar.getChildren().add(editButton);
        
        //profile picture 
        Image image = new Image("file:profile.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Layout
        VBox layout = new VBox(10);        
         layout.setStyle(
                "-fx-padding: 20;" +
                "-fx-alignment: center;"
        );

        layout.getChildren().addAll(topBar,imageView,title,
                nameLabel,               
                phoneLabel,
                emailLabel);

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