package ru.job4j.soccet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean b = true;
            while (b) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("?msg=Exit")) {
                            b = false;
                            break;
                        } else if (str.contains("?msg=Hello")) {
                            out.write("Hello\r\n\r\n".getBytes());
                        } else {
                            String[] temp = str.split("[= ]");
                            if (temp.length > 2) {
                                out.write(temp[2].getBytes());
                            }
                        }
                    }

                }
            }
        }
    }
}