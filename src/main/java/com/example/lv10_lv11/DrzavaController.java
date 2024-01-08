package com.example.lv10_lv11;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DrzavaController {
    @FXML
    private TextField nazivTextField;
    private SimpleStringProperty naziv;
    @FXML
    private ChoiceBox<Grad> glavniGradChoiceBox;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    private Drzava drzava;
    public DrzavaController() {
        naziv = new SimpleStringProperty("");
    }
    public void initialize() {
        glavniGradChoiceBox.getItems().addAll(Grad.getGradList());
        glavniGradChoiceBox.getSelectionModel().selectFirst();

        nazivTextField.textProperty().bindBidirectional(naziv);
    }
    @FXML
    private void handleOkButtonClick() {
        String naziv = nazivTextField.getText();
        Grad selectedGrad = glavniGradChoiceBox.getValue();

        if (!naziv.isEmpty() && selectedGrad != null) {

            drzava = new Drzava(1, naziv, selectedGrad);

            closeStage();
        } else {
            // Handle invalid input
        }
    }
    @FXML
    private void handleCancelButtonClick() {
        drzava = null;
        closeStage();
    }
    public Drzava getDrzava() {
        return drzava;
    }
    private void closeStage() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}