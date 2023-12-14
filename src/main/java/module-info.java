module com.example.korisnik {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.korisnik to javafx.fxml;
    exports com.example.korisnik;
}