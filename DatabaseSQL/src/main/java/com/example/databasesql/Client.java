package com.example.databasesql;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.199.46", 4455);

    }
}
