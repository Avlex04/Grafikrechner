module com.example.grafikrechner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.grafikrechner to javafx.fxml;
    exports com.example.grafikrechner;
    exports com.example;
    opens com.example to javafx.fxml;
}