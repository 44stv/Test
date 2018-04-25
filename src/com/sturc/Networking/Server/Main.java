package com.sturc.Networking.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        int clientNumber = 0;

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("Server started.");

            while (true) {
                clientNumber++;
                Socket socket = serverSocket.accept();
                Echoer echoer = new Echoer(socket);
                echoer.setName("Client " + clientNumber);
                echoer.start();
//                new Echoer (serverSocket.accept()).start();
                System.out.println(echoer.getName() + " connected.");
            }

        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}

