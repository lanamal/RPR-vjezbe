package com.example.lv10_lv11;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class GlavnaController {
    @FXML
    private TableView<Grad> tableView;
    @FXML
    private Button dodajGradButton;
    @FXML
    private Button dodajDrzavuButton;
    @FXML
    private Button izmijeniGradButton;
    @FXML
    private Button obrisiGradButton;
    @FXML
    private TableColumn<Grad, Integer> idColumn;
    @FXML
    private TableColumn<Grad, String> nazivColumn;
    @FXML
    private TableColumn<Grad, Integer> stanovnikaColumn;
    @FXML
    private TableColumn<Grad, Drzava> drzavaColumn;
    private final ObservableList<Grad> gradList = FXCollections.observableArrayList();
    private final ObjectProperty<Grad> selectedGrad = new SimpleObjectProperty<>();
    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nazivColumn.setCellValueFactory(cellData -> cellData.getValue().nazivProperty());
        stanovnikaColumn.setCellValueFactory(cellData -> cellData.getValue().brojStanovnikaProperty().asObject());
        drzavaColumn.setCellValueFactory(cellData -> cellData.getValue().drzavaProperty());

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            selectedGrad.set(newValue);
        });


        gradList.addAll(Grad.getGradList());
        tableView.setItems(gradList);
    }
    @FXML
    private void handleDodajGradButtonClick() {
        openAddForm("grad.fxml", "Dodaj Grad",null);
    }
    @FXML
    private void handleDodajDrzavuButtonClick() {
        openAddForm("drzava.fxml", "Dodaj Državu",null);
    }
    private void openAddForm(String fxmlFileName, String title, Grad grad) {
        if(grad == null){ //Dodavanje novog grada
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle(title);
                stage.setScene(new Scene(loader.load()));
                stage.showAndWait();
                gradList.setAll(Grad.getGradList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{ //Izmjena postojećeg
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle(title);
                stage.setScene(new Scene(loader.load()));
                GradController gradController = loader.getController();
                gradController.initializeWithGrad(grad); //Popunjavanje gotovim podacima
                stage.showAndWait();
                gradList.setAll(Grad.getGradList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void handleIzmijeniGradButtonClick() {

        Grad selected = selectedGrad.get();

        if (selected != null) {
            // Fill the form fields with the selected Grad's data

            openAddForm("grad.fxml", "Izmijeni Grad",selected);
        } else {
            // Handle no selection
        }
    }
    @FXML
    private void handleObrisiGradButtonClick() {
        Grad selected = selectedGrad.get();

        if (selected != null) {
            gradList.remove(selected);
            Grad.getGradList().remove(selected);
            gradList.setAll(Grad.getGradList());

        } else {
            // Handle no selection
        }
    }
}