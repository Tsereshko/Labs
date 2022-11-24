package com.example.databasesql;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> columnLength;

    @FXML
    private TableColumn<?, ?> columnMaterial;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnWeight;

    @FXML
    private TableColumn<?, ?> columnWidth;

    @FXML
    private TableView<?> tableFurniture;

    @FXML
    void initialize() {
        assert columnLength != null : "fx:id=\"columnLength\" was not injected: check your FXML file 'client.fxml'.";
        assert columnMaterial != null : "fx:id=\"columnMaterial\" was not injected: check your FXML file 'client.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'client.fxml'.";
        assert columnPrice != null : "fx:id=\"columnPrice\" was not injected: check your FXML file 'client.fxml'.";
        assert columnWeight != null : "fx:id=\"columnWeight\" was not injected: check your FXML file 'client.fxml'.";
        assert columnWidth != null : "fx:id=\"columnWidth\" was not injected: check your FXML file 'client.fxml'.";
        assert tableFurniture != null : "fx:id=\"tableFurniture\" was not injected: check your FXML file 'client.fxml'.";

    }

}
