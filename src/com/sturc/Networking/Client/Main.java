package com.sturc.Networking.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost", 5000)) {

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString, response;

            do {
                System.out.print("Enter message: ");
                echoString = scanner.nextLine();
                echoString = echoString.toLowerCase();

                output.println(echoString);

                if (echoString.equals("set priority")) {
                    System.out.print("Enter number (1-10): ");
                    int newPriority = Integer.parseInt(scanner.nextLine());
                    /*int newPriority = scanner.nextInt();
                    scanner.nextLine();*/
                    output.println(newPriority);
                }



                if (!echoString.equals("exit")) {
                    response = input.readLine();
                    System.out.println(response);
                }


            } while (!echoString.equals("exit"));


        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out.");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
