import Factory.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    TextField host, port, sentData;
    TextArea result;
    DataOutputStream out;
    DataInputStream in;
    Socket client;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Клиент");
        stage.setWidth(800);
        stage.setHeight(800);

        Group group = createGroup();
        Scene scene = new Scene(group);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        client.close();
    }

    private Group createGroup() {
        ButtonFactory buttonFactory = new ButtonFactory();
        AbstractFactory textAreaFactory = new TextAreaFactory();
        TextFieldFactory textFieldFactory = new TextFieldFactory();
        AbstractFactory labelFactory = new LabelFactory();


        host = (TextField) textFieldFactory.createComponent("127.0.0.1");
        port = (TextField) textFieldFactory.createComponent("1234");
        HBox hBox = new HBox(16,
                labelFactory.createComponent("IP ADRESS"),
                host,
                labelFactory.createComponent("port"),
                port,
                buttonFactory.createComponent("connect", connectClick())
        );
        hBox.setPadding(new Insets(16));

        sentData = (TextField) textFieldFactory.createComponent("0", 150, 200);
        result = (TextArea) textAreaFactory.createComponent(" ", 150, 300);
        return new Group(
                hBox,
                labelFactory.createComponent("sending", 150, 150),
                labelFactory.createComponent("result", 160, 250),
                buttonFactory.createComponent("send", 50, 200, sendClick()),
                sentData,
                result
        );
    }

    private EventHandler<ActionEvent> connectClick(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    client = new Socket(host.getText(), Integer.parseInt(port.getText()));
                    out = new DataOutputStream(client.getOutputStream());
                    in = new DataInputStream(client.getInputStream());
                } catch (IOException e) {
                    result.setText("Неверный IP-адрес");
                }
            }
        };
    }
    private EventHandler<ActionEvent> sendClick(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    out.writeUTF(sentData.getText());
                    System.out.println("Отправлено");
                    result.setText(in.readUTF());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

}