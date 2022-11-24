package UI;

import Factory.*;
import UDP.Client;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.SocketException;

public class ClientFX extends Application {
    private static Client client;
    private static TextArea result;
    private static TextField a, b, c;

    public static void main(String[] args) throws SocketException {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Клиент");
        stage.setWidth(800);
        stage.setHeight(800);

        VBox group = createGroup();
        Scene scene = new Scene(group);

        stage.setScene(scene);
        stage.show();
    }

    private VBox createGroup() {
        ButtonFactory buttonFactory = new ButtonFactory();
        AbstractFactory textAreaFactory = new TextAreaFactory();
        TextFieldFactory textFieldFactory = new TextFieldFactory();
        AbstractFactory labelFactory = new LabelFactory();

        HBox hBox = new HBox(16,
                labelFactory.createComponent("IP ADRESS"),
                labelFactory.createComponent("127.0.0.1"),
                labelFactory.createComponent("port"),
                labelFactory.createComponent("4444"),
                buttonFactory.createComponent("connect", connectClick())
        );
        hBox.setPadding(new Insets(16));

        a = (TextField) textFieldFactory.createComponent("0");
        b = (TextField) textFieldFactory.createComponent("0");
        c = (TextField) textFieldFactory.createComponent("0");
        HBox textFieldsHBox = new HBox( 16, a, b, c);
        result = (TextArea) textAreaFactory.createComponent(" ", 150, 300);
        return new VBox(
                16,
                hBox,
                labelFactory.createComponent("sending"),
                textFieldsHBox,
                buttonFactory.createComponent("send", sendClick()),
                labelFactory.createComponent("result"),
                result
        );
    }

    private EventHandler<ActionEvent> sendClick() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double dA, dB,dC;
                try{
                    dA = Double.parseDouble(a.getText());
                    dB = Double.parseDouble(b.getText());
                    dC = Double.parseDouble(c.getText());
                }catch (NumberFormatException numberFormatException){
                    result.setText("Неверный ввод");
                    return;
                }
                try {
                    client.sendMessage(dA, dB, dC);
                    double dResult = client.receiveMessage();
                    result.setText("Результат: " + String.valueOf(dResult));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private EventHandler<ActionEvent> connectClick() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    client = new Client(4444);
                } catch (SocketException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
