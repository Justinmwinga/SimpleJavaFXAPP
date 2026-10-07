package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        // Title
        Label title = new Label("Customer Manager");

        // Customer name
        Label nameLabel = new Label("Customer name");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter customer name");

        // Remarks
        Label remarksLabel = new Label("Remarks");
        TextArea remarksArea = new TextArea();
        remarksArea.setPromptText("Enter customer remarks");
        remarksArea.setPrefRowCount(4);
        remarksArea.setWrapText(true);

        // Province
        Label provinceLabel = new Label("Province");
        ComboBox<String> provinceBox = new ComboBox<>();

        provinceBox.getItems().addAll(
            "Central",
            "Copperbelt",
            "Eastern",
            "Luapula",
            "Lusaka",
            "Muchinga",
            "Northern",
            "North-Western",
            "Southern",
            "Western"
        );

        provinceBox.setPromptText("Choose a province");

        // Save button
        Button saveButton = new Button("Save customer");

        // Status message
        Label statusMessage = new Label();

        // Save button event
        saveButton.setOnAction(event -> {

            String name = nameField.getText().trim();
            String remarks = remarksArea.getText().trim();
            String province = provinceBox.getValue();

            if (name.isEmpty()) {
                statusMessage.setText("Please enter the customer name.");
                nameField.requestFocus();
                return;
            }

            if (province == null) {
                statusMessage.setText("Please choose a province.");
                provinceBox.requestFocus();
                return;
            }

            statusMessage.setText(
                "Customer saved: " + name + " - " + province
            );

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Customer Saved");
            alert.setHeaderText("Customer information");
            alert.setContentText(
                "Name: " + name
                + "\nProvince: " + province
                + "\nRemarks: " + remarks
            );
            alert.showAndWait();
        });

        // Layout
        VBox layout = new VBox(10);

        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_LEFT);

        layout.getChildren().addAll(
            title,
            nameLabel,
            nameField,
            remarksLabel,
            remarksArea,
            provinceLabel,
            provinceBox,
            saveButton,
            statusMessage
        );

        // Scene
        Scene scene = new Scene(layout, 500, 550);

        stage.setTitle("Customer Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
