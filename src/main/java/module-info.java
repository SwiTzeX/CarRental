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