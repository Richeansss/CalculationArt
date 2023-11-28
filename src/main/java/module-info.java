module com.example.colculationart {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;
    requires mysql.connector.j;
    requires org.apache.commons.io;


    opens com.example.colculationart to javafx.fxml;
    exports com.example.colculationart;
}