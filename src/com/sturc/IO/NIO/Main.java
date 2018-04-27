package com.sturc.IO.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);

            //chained write to file
            byte[] outputBytes = "Hello world!".getBytes();
            byte[] outputBytes2 = "Another string!".getBytes();
            buffer.put(outputBytes).putInt(44).putInt(-44).put(outputBytes2).putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

/*            byte[] outputBytes = "Hello world!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(44);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-44);
            byte[] outputBytes2 = "Another string!".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();*/

            binChannel.write(buffer);


            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("input String = " + new String(inputString));
            System.out.println("int 1 = " + readBuffer.getInt());
            System.out.println("int 2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("input String2 = " + new String(inputString2));
            System.out.println("int 3 = " + readBuffer.getInt());



            /*ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            buffer.flip();

            int numBytes = binChannel.write(buffer);
            System.out.println("Bytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(44);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Bytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-44);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Bytes written was: " + numBytes);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
//                System.out.println("byte buffer = " + new String(outputBytes));
            }

            //Absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));


            //Relative read
*//*            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());*//*

            channel.close();
            ra.close();*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
