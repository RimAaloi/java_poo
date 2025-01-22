package com.javafx.javafx.controller;

import com.javafx.javafx.metier.IMetier;
import com.javafx.javafx.metier.MetierImpl;
import com.javafx.javafx.models.Departement;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class DepartementController implements Initializable {
    private final IMetier metier = new MetierImpl();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @FXML
    private TableView<Departement> departementTable;
    @FXML private TableColumn<Departement, Integer> idColumn;
    @FXML private TableColumn<Departement, String> nomColumn;
    @FXML private TableColumn<Departement, Void> actionsColumn;
    @FXML private Button addButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTable();
        loadDepartments();
        styleComponents(); // Appliquer les styles ici
    }

    private void setupTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        setupActionsColumn();
    }

    private void setupActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editBtn = new Button("Modifier");
            private final Button deleteBtn = new Button("Supprimer");

            {
                // Appliquer les styles directement ici
                editBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 10; -fx-border-radius: 5;");
                deleteBtn.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 10; -fx-border-radius: 5;");

                editBtn.setOnAction(event -> handleEdit(getTableView().getItems().get(getIndex())));
                deleteBtn.setOnAction(event -> handleDelete(getTableView().getItems().get(getIndex())));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox buttons = new HBox(10, editBtn, deleteBtn);
                    buttons.setStyle("-fx-alignment: center;");
                    setGraphic(buttons);
                }
            }
        });
    }

    private void loadDepartments() {
        departementTable.setItems(FXCollections.observableArrayList(metier.getAllDepartements()));
    }

    private void handleEdit(Departement departement) {
        TextInputDialog dialog = new TextInputDialog(departement.getNom());
        dialog.setTitle("Modifier Département");
        dialog.setHeaderText("Modifier le département");
        dialog.setContentText("Nouveau nom:");

        dialog.showAndWait().ifPresent(nom -> {
            departement.setNom(nom);
            metier.updateDepartement(departement);
            loadDepartments();
        });
    }

    private void handleDelete(Departement departement) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer le département");
        alert.setContentText("Confirmer la suppression de ce département ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                metier.deleteDepartement(departement.getId());
                loadDepartments();
            }
        });
    }

    @FXML
    private void handleAdd() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ajouter Département");
        dialog.setHeaderText("Ajouter un département");
        dialog.setContentText("Nom :");

        dialog.showAndWait().ifPresent(nom -> {
            Departement dept = new Departement();
            dept.setNom(nom);
            metier.addDepartement(dept);
            loadDepartments();
        });
    }

    private void styleComponents() {
        // Appliquer un style au bouton Ajouter Département
        addButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 15; -fx-border-radius: 5;");

        // Appliquer un style à la table
        departementTable.setStyle("-fx-border-color: #2c3e50; -fx-border-radius: 10;");
    }
}
