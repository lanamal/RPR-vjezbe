package com.example.korisnik;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormaController {
    public TextField imeField;
    public TextField prezimeField;
    public TextField emailField;
    public TextField korImeField;
    public PasswordField lozinkaField;
    private KorisniciModel model;
    public ListView<Korisnik> listaKorisnika;

    public FormaController(KorisniciModel m) {
        model=m;
    }
    @FXML
    public void initialize() {
        imeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailField.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korImeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        lozinkaField.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
        listaKorisnika.setItems((ObservableList<Korisnik>) model.getKorisnici());
        listaKorisnika.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            model.setTrenutniKorisnik((com.example.korisnik.Korisnik) newKorisnik);
            listaKorisnika.refresh();
        });
        model.trenutniKorisnikProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if(oldKorisnik != null) {
                imeField.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                prezimeField.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                emailField.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                korImeField.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
                lozinkaField.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
            }
            if(newKorisnik == null) {
                imeField.setText("");
                prezimeField.setText("");
                emailField.setText("");
                korImeField.setText("");
                lozinkaField.setText("");
            }
            else{
                imeField.textProperty().bindBidirectional(newKorisnik.imeProperty());
                prezimeField.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                emailField.textProperty().bindBidirectional(newKorisnik.emailProperty());
                korImeField.textProperty().bindBidirectional(newKorisnik.korisnickoImeProperty());
                lozinkaField.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
            }
        });
    }
    @FXML
    public void onDodajButtonClick(ActionEvent actionEvent) {
        model.setTrenutniKorisnik(new Korisnik("", "", "", "", ""));
        model.dodajNovogKorisnika(model.getTrenutniKorisnik());
        listaKorisnika.refresh();
    }
    @FXML
    public void onKrajButtonClick(ActionEvent actionEvent) {
        Stage stage=(Stage) listaKorisnika.getScene().getWindow();
        stage.close();
    }

}