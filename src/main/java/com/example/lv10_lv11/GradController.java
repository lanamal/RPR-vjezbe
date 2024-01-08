package com.example.lv10_lv11;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GradController {
    @FXML
    private TextField nazivTextField;
    private SimpleStringProperty naziv;
    @FXML
    private TextField brojStanovnikaTextField;
    private SimpleStringProperty brojStanovnika;
    @FXML
    private ChoiceBox<Drzava> drzavaChoiceBox;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    private Grad grad;
    public GradController() {
        naziv = new SimpleStringProperty("");
        brojStanovnika = new SimpleStringProperty("");
    }
    public void initialize() {
        drzavaChoiceBox.getItems().addAll(Drzava.getDrzavaList());
        drzavaChoiceBox.getSelectionModel().selectFirst();

        nazivTextField.textProperty().bindBidirectional(naziv);
        brojStanovnikaTextField.textProperty().bindBidirectional(brojStanovnika);
    }
    @FXML
    private void handleOkButtonClick() {
        String naziv = nazivTextField.getText();
        String brojStanovnikaString = brojStanovnikaTextField.getText();

        if (!naziv.isEmpty() && isNumeric(brojStanovnikaString)) {
            int brojStanovnika = Integer.parseInt(brojStanovnikaString);
            Drzava selectedDrzava = drzavaChoiceBox.getValue();

            if (grad != null) {
                grad.setNaziv(naziv);
                grad.setBrojStanovnika(brojStanovnika);
                grad.setDrzava(selectedDrzava);
            } else {
                grad = new Grad(1, naziv, brojStanovnika, selectedDrzava);
            }

            closeStage();
        } else {
            // Handle invalid input
        }
    }
    @FXML
    private void handleCancelButtonClick() {
        grad = null;
        closeStage();
    }
    public Grad getGrad() {
        return grad;
    }
    private void closeStage() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    public void initializeWithGrad(Grad gradEdit) {
        nazivTextField.setText(gradEdit.getNaziv());
        brojStanovnikaTextField.setText(String.valueOf(gradEdit.getBrojStanovnika()));
        drzavaChoiceBox.setValue(gradEdit.getDrzava());
        grad = gradEdit;
    }

}
