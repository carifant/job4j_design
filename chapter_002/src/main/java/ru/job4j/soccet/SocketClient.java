package ru.job4j.soccet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket()) {
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),8189),2000);
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        }
    }
}
