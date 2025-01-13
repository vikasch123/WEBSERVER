import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {

        int port = 8020;
        ServerSocket socket=new ServerSocket(port);
        socket.setSoTimeout(10000);  // after 10 sec the socket will be closed
        while(true) {
            try {
                System.out.println("server is listening on port " + port);
                Socket acceptedConnection = socket.accept();
                System.out.println("connection accepted from " + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from server");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        try {
            Server server = new Server();
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
