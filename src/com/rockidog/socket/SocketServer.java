package com.rockidog.socket;

import java.io.InputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        InputStream inputStream = null;
        ServerSocket server = null;
        Socket client = null;
        byte[] buffer = null;
        
        while (true) {
            try {
                server = new ServerSocket(7000);
                client = server.accept();
                inputStream = client.getInputStream();
                buffer = new byte[20];
                inputStream.read(buffer);
                
                String str = new String(buffer);
                System.out.println(str);
                inputStream.close();
            }
            catch (IOException e) {
                System.out.println(e.toString());
            }
            finally {
                if (null != client) {
                    if (true == client.isConnected()) {
                        try {
                            client.close();
                        }
                        catch (IOException e) {
                            System.out.println(e.toString());
                        }
                    }
                }
                
                if (null != server) {
                    if (false == server.isClosed()) {
                        try {
                            server.close();
                        }
                        catch (IOException e) {
                            System.out.println(e.toString());
                        }
                    }
                }
            }
        }
    }
}

