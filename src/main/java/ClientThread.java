import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {

    private String name;
    private Socket socket;

    ClientThread(String name, Socket clientSocket) {
        this.name = name;
        this.socket = clientSocket;
    }

    public void run() {
        try {
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("New Client Thread has been created!");

            ECHOServer.getInstance().addClientThread(this);

            while (true) {
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.equals("exit")) {
                        break;
                    }

                    System.out.println(this.name + " wrote : " + line);
                    Dispatcher.processMessage(out, line);
                }
            }

            ECHOServer.getInstance().removeClientThread(this);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}