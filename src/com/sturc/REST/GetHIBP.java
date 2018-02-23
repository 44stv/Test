package com.sturc.REST;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class GetHIBP {

    private String pswd;

    public GetHIBP(String pswd) {
        this.pswd = pswd;
    }

    public String getSHA(){
        byte[] pswdByte = this.pswd.getBytes();
        byte[] hashedPswd = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            hashedPswd = md.digest(pswdByte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return byteArray2Hex(hashedPswd);
    }

    private static String byteArray2Hex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }


    public static void main(String[] args) {

        String pswd = "";
        GetHIBP getHIBP = new GetHIBP(pswd);
        String sha1 = getHIBP.getSHA();
        System.out.println(sha1);
        String trimmedSha1 = sha1.substring(0,5);
        System.out.println(trimmedSha1);

        String fullURL = "https://api.pwnedpasswords.com/range/"+trimmedSha1;

        try {
            URL url = new URL(fullURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output;
            PrintWriter writer = new PrintWriter("pswd.txt", "UTF-8");

            while ((output = br.readLine()) != null){
                writer.print(trimmedSha1);
                writer.println(output);
            }

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
