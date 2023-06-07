module com.carrental.carrental {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;
    requires com.google.api.client;
    requires google.api.client;
    requires com.google.api.client.json.gson;
    requires com.google.api.client.auth;
    requires javax.mail.api;
    requires org.apache.commons.codec;
    requires com.google.api.services.gmail;
    requires com.google.api.client.extensions.java6.auth;
    requires com.google.api.client.extensions.jetty.auth;
    //requires javax.mail.api;
    //requires com.google.api.client.auth;
    //requires java.mail;


    opens com.carrental.models to javafx.base;
    opens com.carrental.tables to javafx.base;
    exports com.carrental;
    exports com.carrental.customnodes;
    opens com.carrental.customnodes to javafx.fxml;
    opens com.carrental to javafx.base, javafx.fxml;
}