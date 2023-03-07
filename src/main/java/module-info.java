module com.example.grafikrechner {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
    requires org.testng;

    opens com.example.grafikrechner to javafx.fxml;
    exports com.example.grafikrechner;
}