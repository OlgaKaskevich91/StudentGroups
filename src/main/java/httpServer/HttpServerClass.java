package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpServerClass {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/students", new StudentsHandler());
        httpServer.createContext("/hello", new HelloHandler());

        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("Server started on port 8080");
    }
}

class StudentsHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                String response = "Students in the class";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody();) {
                    os.write(response.getBytes(StandardCharsets.UTF_8));
                }
            } else {
                exchange.getResponseHeaders().add("Allow", "GET");
                exchange.sendResponseHeaders(405, -1);
                System.out.println("Unsupported HTTP method: " + exchange.getRequestMethod());
            }
        } finally {
            exchange.close();
        }
    }
}

class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                String response = "Hello,World and Olga!";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody();) {
                    os.write(response.getBytes(StandardCharsets.UTF_8));
                }
            } else {
                exchange.getResponseHeaders().add("Allow", "GET");
                exchange.sendResponseHeaders(405, -1);
                System.out.println("Unsupported HTTP method: " + exchange.getRequestMethod());
            }
        } finally {
            exchange.close();
        }
    }
}


