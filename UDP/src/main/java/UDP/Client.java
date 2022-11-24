package UDP;

import UI.ClientFX;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

public class Client {
    private int port;
    private DatagramSocket socket;
    private DatagramPacket packet;

    public Client(int port) throws SocketException {
        this.port = port;
        socket = new DatagramSocket();
    }
    public void sendMessage(double a, double b, double c) throws IOException {
        byte[] buf = ByteBuffer.allocate(24)
                .putDouble(a)
                .putDouble(b)
                .putDouble(c)
                .array();

        packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), port);
        socket.send(packet);
    }
    public double receiveMessage() throws IOException {
        byte[] buf = ByteBuffer.allocate(8).array();
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        return ByteBuffer.wrap(buf).getDouble();
    }
}
