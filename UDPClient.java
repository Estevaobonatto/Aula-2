import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        String serverIP = "localhost";
        int serverPort = 9876;

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverIpAddress = InetAddress.getByName(serverIP);
            String message = "Hello World";
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIpAddress, serverPort);
            clientSocket.send(sendPacket);
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

