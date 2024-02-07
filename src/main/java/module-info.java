module com.example.colculationart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jsoup;
    requires org.apache.commons.io;


    opens com.example.colculationart to javafx.fxml;
    exports com.example.colculationart;
}