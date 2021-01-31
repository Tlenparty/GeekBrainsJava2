package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        Socket socket;
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Сервер запущен, ожидаем подключения..");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread thread1 = new Thread(() -> {
                try {
                    while (true) {
                        String messageFromClient = in.readUTF();
                        System.out.println(messageFromClient);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread1.start();
            Thread thread2 = new Thread(() -> {
                try {
                    while (true) {
                        String message = scanner.nextLine();
                            out.writeUTF("Сервер: " + message);
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
