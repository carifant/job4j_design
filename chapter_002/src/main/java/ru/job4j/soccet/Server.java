package ru.job4j.soccet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try (java.net.ServerSocket serverSocket = new java.net.ServerSocket(8189);
             Socket socket = serverSocket.accept()) {
            System.out.println("клиент подключился");
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String temp = scanner.nextLine();
                if (temp.equals("exit")) {
                    break;
                }
                writer.println(temp + " answer");
            }
        }
    }
}
