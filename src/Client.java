import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public void run () throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket("localhost", 8020);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello from client");
        String response = fromSocket.readLine();
        System.out.println(response); // the response from the server
        toSocket.close();
        fromSocket.close();

        socket.close();


    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
