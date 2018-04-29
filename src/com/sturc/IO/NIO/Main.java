package com.sturc.IO.NIO;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();

            Runnable writer = () -> {
                try {
                    Pipe.SinkChannel sinkChannel = pipe.sink();
                    ByteBuffer buffer = ByteBuffer.allocate(56);

                    for (int i = 0; i < 10; i++) {
                        String currentTime = "Time is = " + System.currentTimeMillis();

                        buffer.put(currentTime.getBytes());
                        buffer.flip();

                        while (buffer.hasRemaining()) {
                            sinkChannel.write(buffer);
                        }
                        buffer.flip();
                        Thread.sleep(100);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            Runnable reader = () -> {
                try {
                    Pipe.SourceChannel sourceChannel = pipe.source();
                    ByteBuffer buffer = ByteBuffer.allocate(56);

                    for (int i = 0; i < 10; i++) {
                        int bytesRead = sourceChannel.read(buffer);
                        byte[] timeString = new byte[bytesRead];
                        buffer.flip();
                        buffer.get(timeString);
                        System.out.println("Reader thread: " + new String(timeString));
                        buffer.flip();
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

/*
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);

            //chained write to file
//            byte[] outputBytes = "Hello world!".getBytes();
//            byte[] outputBytes2 = "Another string!".getBytes();
//            buffer.put(outputBytes).putInt(44).putInt(-44).put(outputBytes2).putInt(1000);
//            buffer.flip();
//            binChannel.write(buffer);

            byte[] outputBytes = "Hello world!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(44);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-44);
            byte[] outputBytes2 = "Another string!".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();


            */
/*//*
/ write randomly
            byte[] outputString = "Hello world!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Another string!".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(44);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-44);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));*//*



        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }
}
