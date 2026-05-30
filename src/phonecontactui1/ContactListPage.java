
package PhoneContactUI1;

import javafx.application.Application;
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
         
        HBox buttonRow = new HBox(10);

        Button allBtn = new Button("All");
        Button addBtn = new Button("Add Contact");

        buttonRow.getChildren().addAll(allBtn, addBtn);

        TextField name = new TextField();
        name.setPromptText("Name");

        TextField number = new TextField();
        number.setPromptText("Number");

        inputBox = new HBox(10, name, number);
        inputBox.setVisible(false);

        // saved contacts
        addContact("Prapti", "01711111111");
        addContact("Mariya", "01822222222");
        addContact("Esha", "01333333333");
        addContact("Sifat", "01933333323");

        // show the box where i can add name and number
        addBtn.setOnAction(e -> {
            if (!layout.getChildren().contains(inputBox)) {
                layout.getChildren().add(inputBox);
            }
            inputBox.setVisible(true);//the input box will pop
      
            if (!name.getText().isEmpty() && !number.getText().isEmpty()) {

                addContact(name.getText(), number.getText());

                name.clear();
                number.clear();

                inputBox.setVisible(false);//afyrt xcontact saving the box will vanish
            }
        });

        layout.getChildren().addAll(search, buttonRow, contactList);

        Scene scene = new Scene(layout, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Contact List");
        primaryStage.show();
    }

    void addContact(String name, String number) {

        HBox box = new HBox(15);
        box.setAlignment(Pos.CENTER_LEFT);

        VBox info = new VBox(5);
        info.getChildren().addAll(new Label(name), new Label(number));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button call = new Button("Call");

        box.getChildren().addAll(info, spacer, call);

        contactList.getChildren().add(box);
    }

    public static void main(String[] args) {
        launch(args);
    }
}