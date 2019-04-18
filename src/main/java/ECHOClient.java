import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ECHOClient {

    private static final String host = "127.0.0.1";
    private static final int port = 59090;

    public static void main(String[] args) throws IOException {
        try (var socket = new Socket(host, port)) {
            System.out.println("Client connected to " + host + " at port " + port);

            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.equals("exit")) {
                        System.out.println("Client exited the program");
                        break;
                    }

                    out.println(line);
                    System.out.println(in.nextLine());
                }
            }

            System.out.println("Closing the connection on " + host + " at port " + port + "...");
        }
    }
}
