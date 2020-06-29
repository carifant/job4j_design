package ru.job4j.soccet;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String log4jConfPath = "C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        try (ServerSocket server = new ServerSocket(9000)) {
            boolean b = true;
            while (b) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            b = false;
                            break;
                        } else if (str.contains("Hello")) {
                            out.write("Hello\r\n\r\n".getBytes());
                        } else {
                            String[] temp = str.split("[= ]");
                            if (temp.length > 2) {
                                out.write(temp[2].getBytes());
                            }
                        }
                        str = in.readLine();
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("IOException", e);
        }
    }
}