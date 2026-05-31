
package PhoneContactUI1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContactListPage extends Application {

    VBox contactList = new VBox(15);
    HBox inputBox;

    @Override
    public void start(Stage primaryStage) {

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        TextField search = new TextField();
        search.setPromptText("Search Contacts");
        search.setStyle("-fx-background-radius: 10;" +"-fx-border-radius: 20;" +
                          "-fx-padding: 8 15 8 15;" +"-fx-font-size: 15px;");

        Button addBtn = new Button("Add Contact");
        addBtn.setStyle("-fx-background-radius: 10;" +"-fx-padding: 6 10 6 10;" +"-fx-font-size: 15px;");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setStyle("-fx-background-radius: 8;" +"-fx-border-radius: 8;");

        TextField numberField = new TextField();
        numberField.setPromptText("Number");
        numberField.setStyle("-fx-background-radius: 8;" + "-fx-border-radius: 8;");

        inputBox = new HBox(10, nameField, numberField);
        inputBox.setVisible(false);

        addContact("Prapti", "01711111111");
        addContact("Mariya", "01822222222");
        addContact("Faria", "01333333333");
        addContact("Mashrafee", "01933333323");

        addBtn.setOnAction(e -> {

            if (!layout.getChildren().contains(inputBox)) {
                layout.getChildren().add(inputBox);
            }

            inputBox.setVisible(true);

            String name = nameField.getText().trim();
            String number = numberField.getText().trim();

            if (!name.isEmpty() && !number.isEmpty()) {

                addContact(name, number);

                nameField.clear();
                numberField.clear();

                inputBox.setVisible(false);
            }
        });

        layout.getChildren().addAll(search, addBtn, contactList);

        Scene scene = new Scene(layout, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Contact List");
        primaryStage.show();
    }

    void addContact(String name, String number) {

        HBox b = new HBox(15);
        b.setAlignment(Pos.CENTER_LEFT);
        b.setPadding(new Insets(12));

b.setStyle(
    "-fx-border-color: #7A869A;" +
    "-fx-border-width: 1;" +
    "-fx-border-radius: 10;" +
    "-fx-padding: 10;"
);

        VBox info = new VBox(5);
        info.getChildren().addAll(new Label(name),new Label(number));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button callBtn = new Button("Call");
        callBtn.setStyle("-fx-background-radius: 10;" +"-fx-padding: 6 10 6 10;" +"-fx-font-size: 15px;");

        b.getChildren().addAll(info, spacer, callBtn);

        contactList.getChildren().add(b);
    }

    public static void main(String[] args) {
        launch(args);
    }
}