module coit11134.ictassetmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens coit11134.ictassetmanager to javafx.fxml;
    exports coit11134.ictassetmanager;
}
