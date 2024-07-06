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
    requires org.slf4j;
    requires mysql.connector.j;
    requires org.apache.commons.csv;


    opens com.example.colculationart to javafx.fxml;
    exports com.example.colculationart;
    exports com.example.colculationart.hibernate;
    opens com.example.colculationart.hibernate to javafx.fxml;
    opens com.example.colculationart.hibernate.entity to org.hibernate.orm.core;
    exports com.example.colculationart.test;
    opens com.example.colculationart.test to javafx.fxml;
    exports com.example.colculationart.controller;
    opens com.example.colculationart.controller to javafx.fxml;
    opens com.example.colculationart.hibernate.entity.artifact to org.hibernate.orm.core;
    opens com.example.colculationart.hibernate.entity.character to org.hibernate.orm.core;
    exports com.example.colculationart.utils;
    opens com.example.colculationart.utils to javafx.fxml;
    exports com.example.colculationart.parser;
    opens com.example.colculationart.parser to javafx.fxml;
}