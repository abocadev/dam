module dev.boca {
    requires javafx.controls;
    requires javafx.fxml;

    opens dev.boca to javafx.fxml;
    exports dev.boca;
}
