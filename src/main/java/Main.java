import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8090;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");
            out.println("Write your name");

            final String name = in.readLine();

            out.println("Are you child? (Y/N)");

            final String answer = in.readLine();
            if (answer.equals("N")) {
                out.println(String
                        .format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            } if (answer.equals("Y")) {
                out.println(String
                        .format("Welcome to the kids area, %s! Let's play!", name));
            } else {
                out.println("Wrong symbol!");
            }
        }
    }
}
