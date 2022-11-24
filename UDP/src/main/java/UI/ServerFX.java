package UI;

import Factory.*;
import UDP.Server;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.URL;
import java.util.Objects;

public class ServerFX extends Application{
    private static DatagramSocket socket;
    private static TextField port;
    private static TextArea result;
    private static Stage primary;

    private static Server server;

    public static void setText(String s ){
        result.setText(s);
    }
    public static void addText(String s){
        result.setText(result.getText() + s);
    }

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Сервер");
        stage.setWidth(800);
        stage.setHeight(800);


        Group group = createGroup();
        Scene scene = new Scene(group);

        stage.setScene(scene);
        primary = stage;
        stage.show();
    }
    private Group createGroup() {
        AbstractFactory textAreaFactory = new TextAreaFactory();
        TextFieldFactory textFieldFactory = new TextFieldFactory();
        AbstractFactory labelFactory = new LabelFactory();
        ButtonFactory buttonFactory = new ButtonFactory();

        Button button = (Button) buttonFactory.createComponent("start", startButton());
        port = (TextField) textFieldFactory.createComponent("4444");
        HBox hBox = new HBox(16,
                labelFactory.createComponent("port"),
                port,
                button
        );
        hBox.setPadding(new Insets(16));

        result = (TextArea) textAreaFactory.createComponent(" ", 150, 300);
        return new Group( hBox, result);
    }

    private EventHandler<ActionEvent> startButton() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                server = new Server(4444);
                server.start();
            }
        };
    }
}