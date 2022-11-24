package UDP;

import Factory.*;
import UI.ServerFX;
import Util.TasksCreator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.concurrent.*;

public class Server extends Thread {

    private DatagramSocket socket;

    public Server(int port) {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException exception) {
            System.out.println(exception);
        }
        ServerFX.setText("Сервер запущен");
    }
// пишел нахуй
    @Override
    public void run() {
        Future<Double> futureTask1;
        Future<Double> futureTask2;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        byte[] buf;
        double a, b, c;

        try{
            FileWriter writer = new FileWriter("file.txt", false);
        } catch (IOException e) {
            System.out.println("Файла не существует");
            throw new RuntimeException(e);
        }

        while (true) {
            buf = new byte[24];

            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);

            try {

                socket.receive(packet);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                ServerFX.setText("Клиент подключён\n");

                a = ByteBuffer.wrap(buf).getDouble(0);
                b = ByteBuffer.wrap(buf).getDouble(8);
                c = ByteBuffer.wrap(buf).getDouble(16);

                ServerFX.addText("\nКлиент прислал данные\n" +
                        "a:" + a + "\n" +
                        "b" + b + "\n" +
                        "c" + c + "\n");

                futureTask1 = executorService.submit(TasksCreator.getTask1(a, b));
                futureTask2 = executorService.submit(TasksCreator.getTask2(b, c));
                double result = futureTask1.get() + futureTask2.get();

                FileWriter writer = new FileWriter("file.txt", true);

                String writable = "a: " + a + "\nb: " + b + "\nc: " + c + "\nresult: "+ result + "\n\n";
                writer.write(writable);
                writer.flush();

                buf = ByteBuffer.allocate(8)
                        .putDouble(result)
                        .array();
                ServerFX.addText("result: " + result + "\n");
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);

            } catch (IOException | InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

