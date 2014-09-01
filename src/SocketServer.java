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
        
        try {
            server = new ServerSocket(7000);
            client = server.accept();
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
        
        while (true) {
            try {
                inputStream = client.getInputStream();
                buffer = new byte[20];
                inputStream.read(buffer);
                
                String str = new String(buffer);
                System.out.println(str);
            }
            catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }
}

