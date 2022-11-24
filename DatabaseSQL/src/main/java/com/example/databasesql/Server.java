package com.example.databasesql;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7800);
        System.out.println(Inet4Address.getLocalHost().toString());
        server.accept();
        System.out.println("connected");
    }
}
