import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    private final static int MAX_BUFFER_SIZE = 30;
    public static void main(String[] args) {
        int port = 7001;
        byte[] buffer = new byte[MAX_BUFFER_SIZE];
        
        try {
            DatagramSocket server = new DatagramSocket(port);
            DatagramPacket data = new DatagramPacket(buffer, buffer.length);
            
            while (true) {
                try {
                    server.receive(data);
                    String message = new String(buffer, 0, data.getLength());
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
