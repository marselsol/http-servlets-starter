package http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        //http port - 80
        //https port - 443
        //
        try (var socket = new Socket("localhost", 7777);
        var outputStream = new DataOutputStream(socket.getOutputStream());
        var inputStream = new DataInputStream(socket.getInputStream());
        var scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("Response from server: " + inputStream.readUTF());
            }
        }
    }
}
