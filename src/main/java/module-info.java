module com.example.colculationart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.commons.io;
    requires org.hibernate.orm.core;
    requires org.jsoup;
    requires java.persistence;
    requires java.naming;
    requires static lombok;
    requires jakarta.persistence;



    opens com.example.colculationart to javafx.fxml;
    exports com.example.colculationart;
    exports com.example.colculationart.hibernate;
    opens com.example.colculationart.hibernate to javafx.fxml;
    opens com.example.colculationart.hibernate.entity to org.hibernate.orm.core;
    exports com.example.colculationart.test;
    opens com.example.colculationart.test to javafx.fxml;
}