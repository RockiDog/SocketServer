import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
        int port = 7001;
        byte[] buffer = new byte[50];
        
        try {
            DatagramSocket server = new DatagramSocket(port);
            DatagramPacket data = new DatagramPacket(buffer, buffer.length);
            
            while (true) {
                try {
                    server.receive(data);
                    String message = new String(buffer).trim();
                    System.out.println(message);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (SocketException s) {
            s.printStackTrace();
        }
    }
}
