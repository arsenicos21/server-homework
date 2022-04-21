import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8090;

        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String resp = in.readLine();
            System.out.println(resp);
            String input = scanner.nextLine();
            out.println(input);

            String yesOrNoAnswer = in.readLine();
            System.out.println(yesOrNoAnswer);
            input = scanner.nextLine();
            out.println(input);

            String finalString = in.readLine();
            System.out.println(finalString);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
