package simple_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class Client {

    public Client() throws IOException {
        Socket socket = new Socket( "localhost" ,2020);
        System.out.println("Successfully connected to the server");

        BufferedReader insocket = new BufferedReader( new InputStreamReader( socket.getInputStream()));
        PrintWriter outsocket = new PrintWriter(new OutputStreamWriter( socket.getOutputStream() ));

        String message = insocket.readLine();
        System.out.println("Server says " + message);

        outsocket.println("hey there server");
        socket.close();
        System.out.println("Socket is closed");
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
