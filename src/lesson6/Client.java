package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final int SERVER_PORT = 8189;
    public static final String SERVER_HOST = "localhost";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket;

        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("Вы подключились");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread thread1 = new Thread(() -> {
                try {
                    while (true) {
                        String messageFromServer = in.readUTF();
                        System.out.println(messageFromServer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Сервер отключился.");
                }
            });
            thread1.start();
            Thread thread2 = new Thread(() -> {
                try {
                    while (true) {
                        String messageFromClient = scanner.nextLine();
                            out.writeUTF("Клиент: " + messageFromClient);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}







