package httpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                    System.out.println("New client connected");
                    String line = in.readLine();
                    System.out.println(line);

                    if (line != null && line.startsWith("GET /hello")) {
                        String answer =
                                "HTTP/1.1 200 OK\r\n" +
                                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                                        "Content-Length: 22\r\n" +
                                        "Connection: close\r\n" +
                                        "\r\n" +
                                        "Hello, World and Olga!";
                        out.write(answer);
                    } else if (line != null) {
                        String answer =
                                "HTTP/1.1 404 Not Found\r\n" +
                                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                                        "Content-Length: 22\r\n" +
                                        "Connection: close\r\n" +
                                        "\r\n" +
                                        "404 Not Found";
                        out.write(answer);
                    }
                    out.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

