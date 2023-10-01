module com.example.colculationart {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens com.example.colculationart to javafx.fxml;
    exports com.example.colculationart;
}