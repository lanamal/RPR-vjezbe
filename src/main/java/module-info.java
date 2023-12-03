module com.example.lv6z1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires testfx.core;
    requires testfx.junit5;


    opens com.example.lv6z1 to javafx.fxml;
    exports com.example.lv6z1;
}