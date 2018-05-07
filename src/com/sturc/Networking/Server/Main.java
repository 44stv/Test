package com.sturc.Networking.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        int clientNumber = 0;

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("Server started.");

//            ExecutorService executorService = Executors.newFixedThreadPool(15);

            while (true) {
                clientNumber++;
                Socket socket = serverSocket.accept();
                Echoer newClient = new Echoer(socket);
                newClient.setName("Client " + clientNumber);
                newClient.start();
//                new Echoer (serverSocket.accept()).start();
                System.out.println(newClient.getName() + " connected.");
            }

        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}

