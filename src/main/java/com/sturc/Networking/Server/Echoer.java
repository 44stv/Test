package com.sturc.Networking.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;

    Echoer(Socket socket) {
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
                System.out.println("Received message  \"" + echoString + "\" from " + this.getName());

                if (echoString.equals("exit")) {
                    System.out.println(this.getName() + " disconnected.");
                    break;
                }

                if (echoString.equals("set priority")) {
                    System.out.print("Old priority = " + this.getPriority());

                    int newPriority = Integer.valueOf(input.readLine());
                    this.setPriority(newPriority);
                    System.out.println(". New priority = " + newPriority + " for " + this.getName());
                    echoString = "server set priority to " + newPriority;
                }

                if (echoString.equals("calc")) {
                    String figure = input.readLine();
                    System.out.println("Received figure \"" + figure + "\" from " + this.getName());

                    if (figure.equals("circle")){
                        double radius = Double.valueOf(input.readLine());
                        double area = radius * radius * Math.PI;
                        area = roundDouble(area);
                        System.out.println("Calculated circle area " + area + " for " + this.getName());
                        echoString = "Circle area = " + area;
                    }

                    if (figure.equals("square")){
                        double length = Double.valueOf(input.readLine());
                        double area = Math.pow(length, 2);
                        area = roundDouble(area);
                        System.out.println("Calculated square area " + area + " for " + this.getName());
                        echoString = "Square area = " + area;
                    }
                }

                output.println("Message from server: " + echoString);
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

    private double roundDouble(double number) {
        return (double) Math.round(number * 100) / 100;
    }
}
