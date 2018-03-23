package com.sturc.Networking.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoString = input.readLine();
                System.out.println("Received client input: " + echoString);
                if (echoString.equals("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

/*                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }*/

                output.println("Echo from server: " + echoString);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Exception with closing socket.");
            }
        }
    }
}
