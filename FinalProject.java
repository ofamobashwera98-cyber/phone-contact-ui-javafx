/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import static javafx.application.Application.launch;

public class FinalProject extends Application {

    VBox contactList = new VBox(15);  // global variables
    HBox inputBox;

    @Override
    public void start(Stage primaryStage) {

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        TextField search = new TextField();
        search.setPromptText("Search Contacts");
        search.setStyle("-fx-background-radius: 10;" +
                "-fx-border-radius: 20;" +
                "-fx-padding: 8 15 8 15;" +
                "-fx-font-size: 15px;");

        Button addBtn = new Button("Add Contact");
        addBtn.setStyle("-fx-background-radius: 10;" +
                "-fx-padding: 6 10 6 10;" +
                "-fx-font-size: 15px;");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField numberField = new TextField();
        numberField.setPromptText("Number");

        inputBox = new HBox(10, nameField, numberField);
        inputBox.setVisible(false);  // for keeping number and name input box initially invisible

        addContact("Prapti", "01711111111");
        addContact("Mariya", "01822222222");
        addContact("Faria", "01333333333");
        addContact("Mashrafee", "01933333323");

        addBtn.setOnAction(e -> {

            if (!layout.getChildren().contains(inputBox)) {
                layout.getChildren().add(inputBox);
            }

            inputBox.setVisible(true);  // boxes will be visible

            String name = nameField.getText().trim();
            String number = numberField.getText().trim();

            if (!name.isEmpty() && !number.isEmpty()) {

                addContact(name, number);

                nameField.clear();
                numberField.clear();

                inputBox.setVisible(false);   //boxes will be invisible again
            }
        });

        layout.getChildren().addAll(search, addBtn, contactList);

        primaryStage.setScene(new Scene(layout, 400, 600));
        primaryStage.setTitle("Contact List");
        primaryStage.show();
    }

    // ================= contact list creation method for contactlist page =================
    void addContact(String name, String number) {

        HBox box = new HBox(15);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(12));

        box.setStyle("-fx-border-color: #7A869A; -fx-border-width: 1; -fx-border-radius: 10; -fx-padding: 10;");

        VBox info = new VBox(5);

        Label nameLabel = new Label(name);
        Label phoneLabel = new Label(number);

        info.getChildren().addAll(nameLabel, phoneLabel);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button viewBtn = new Button("View");

        viewBtn.setOnAction(e ->
                openProfile(name, number,
                        name.toLowerCase() + "@gmail.com",
                        box,
                        nameLabel,
                        phoneLabel)
        );

        box.getChildren().addAll(info, spacer, viewBtn);
        contactList.getChildren().add(box);
    }

        // ================= view profile window =================
    void openProfile(String name,
                     String phone,
                     String email,
                     HBox contactBox,
                     Label nameLabel,
                     Label phoneLabel) {

        Stage stage = new Stage();

        ImageView imageView = new ImageView();
        

        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        imageView.setPreserveRatio(true);

        Label title = new Label("Profile");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        Label profileName = new Label("👤 " + name);
        Label profilePhone = new Label("📞 " + phone);
        Label emailLabel = new Label("✉ " + email);

        Button editButton = new Button("Edit");
        Button callButton = new Button("Call");

        editButton.setOnAction(e ->
                openEdit(name, phone, email,
                        contactBox,
                        nameLabel,
                        phoneLabel,
                        profileName,
                        profilePhone,
                        stage)
        );

        HBox row = new HBox(10, editButton, callButton);
        row.setAlignment(Pos.CENTER);

        VBox root = new VBox(15,
                imageView,
                title,
                profileName,
                profilePhone,
                emailLabel,
                row
        );

        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 550));
        stage.setTitle("Profile");
        stage.show();
    }

    //================= edit contact window =================
    void openEdit(String name,
                  String phone,
                  String email,
                  HBox contactBox,
                  Label nameLabel,
                  Label phoneLabel,
                  Label profileName,
                  Label profilePhone,
                  Stage profileStage) {

        Stage stage = new Stage();

        ImageView profileImageView = new ImageView();
        profileImageView.setFitWidth(120);
        profileImageView.setFitHeight(120);

        TextField nameField = new TextField(name);
        TextField phoneField = new TextField(phone);
        TextField emailField = new TextField(email);

        Button photoBtn = new Button("Change Photo");

        photoBtn.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(stage);
            if (file != null) {
                profileImageView.setImage(new Image(file.toURI().toString()));
            }
        });

        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");

         // ================= functionality of update button =================
        updateBtn.setOnAction(e -> {

            String newName = nameField.getText().trim();
            String newPhone = phoneField.getText().trim();

            if (newName.isEmpty() || newPhone.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Empty not allowed!").show();
                return;
            }

            //home page update
            nameLabel.setText(newName);
            phoneLabel.setText(newPhone);

            VBox info = (VBox) contactBox.getChildren().get(0);
            ((Label) info.getChildren().get(0)).setText(newName);
            ((Label) info.getChildren().get(1)).setText(newPhone);

            // profile update
            profileName.setText("👤 " + newName);
            profilePhone.setText("📞 " + newPhone);

            new Alert(Alert.AlertType.INFORMATION,
                    "Contact Updated Successfully!").show();

            stage.close();
        });

        // ================= functionality of delete button =================
        deleteBtn.setOnAction(e -> {

            contactList.getChildren().remove(contactBox);

            new Alert(Alert.AlertType.INFORMATION,
                    "Contact Deleted Successfully!").show();

            stage.close();
            profileStage.close();
        });

        HBox nameRow = new HBox(10, new Label("Name"), nameField);
        nameRow.setAlignment(Pos.CENTER);

        HBox phoneRow = new HBox(10, new Label("Phone"), phoneField);
        phoneRow.setAlignment(Pos.CENTER);

        HBox emailRow = new HBox(10, new Label("Email"), emailField);
        emailRow.setAlignment(Pos.CENTER);

        HBox buttonRow = new HBox(20, updateBtn, deleteBtn);
        buttonRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(15,
                profileImageView,
                photoBtn,
                nameRow,
                phoneRow,
                emailRow,
                buttonRow
        );

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 450, 550));
        stage.setTitle("Edit Contact");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}