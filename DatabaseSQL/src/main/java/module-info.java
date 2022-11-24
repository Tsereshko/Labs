module com.example.databasesql {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.databasesql to javafx.fxml;
    exports com.example.databasesql;
}