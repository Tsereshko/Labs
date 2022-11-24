import java.net.*;
import java.io.*;

public class Server extends Thread {
    static int port = 1234;
    private final ServerSocket serverSocket;
    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public static void main(String [] args) {
        try {
            Thread t = new Server(1234);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try {
                System.out.println("Ожидаю");
                Socket server = serverSocket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                while(true) {
                    String str = numberToString(in.readUTF());
                    out.writeUTF(str);
                }

            } catch (IOException e) {
                System.out.println("Клиент отключился");
            }
        }
    }

    private static String numberToString(String s){
        switch (s){
            case "0":
                return "Ноль";
            case "1":
                return "Один";
            case "2":
                return "Два";
            case "3":
                return "Три";
            case "4":
                return "Четыре";
            case "5":
                return "Пять";
            case "6":
                return "Шесть";
            case "7":
                return "Семь";
            case "8":
                return "Восемь";
            case "9":
                return "Девять";
            default:
                return "Неверный ввод";
        }
    }
}