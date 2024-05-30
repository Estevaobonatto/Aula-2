import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class UDPServer {

    public static void main(String[] args) {
        int serverPort = 9876;
        try {
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            byte[] receivedData = new byte[1024];
            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                serverSocket.receive(receivedPacket);
                String receivedMessage = new String(receivedPacket.getData());
                JOptionPane.showMessageDialog(null, "Mensagem recebida: " + receivedMessage);

                //parte 2

                InetAddress clientIPAddress = receivedPacket.getAddress();
                int clientPort = receivedPacket.getPort();
                String responseMessage = "Mensagem de resposta";

                byte[] sendData = responseMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

