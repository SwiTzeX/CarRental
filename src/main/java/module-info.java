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

    opens com.carrental to javafx.fxml;
    exports com.carrental;
    exports com.carrental.customnodes;
    opens com.carrental.customnodes to javafx.fxml;
}