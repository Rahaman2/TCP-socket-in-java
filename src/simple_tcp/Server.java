package simple_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("PORT 2020 is open");
        Socket socket = serverSocket.accept(); // a blocking method 
        System.out.println("Client "+ socket.getInetAddress());

        // input and output buffers
        BufferedReader insocket = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        outSocket.println("hello");

        String message = insocket.readLine();

        System.out.println("CLient says " + message);

        serverSocket.close(); // always close the socket
        System.out.println("Socket is closed");
    }

    
    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
