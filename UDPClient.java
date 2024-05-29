
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Esta classe define um cliente UDP que se comunica com um servidor UDP.
 * O cliente envia uma mensagem para o servidor e fecha a conexão.
 */
public class UDPClient {
    public static void main(String[] args) {
        // Define o endereço IP do servidor
        String serverIP = "localhost";
        // Define a porta do servidor
        int serverPort = 9876;

        try {
            // Cria um socket UDP para o cliente
            DatagramSocket clientSocket = new DatagramSocket();
            // Obtém o endereço IP do servidor
            InetAddress serverIpAddress = InetAddress.getByName(serverIP);

            // Define a mensagem que será enviada para o servidor
            String message = "Hello World";
            // Converte a mensagem para bytes
            byte[] sendData = message.getBytes();

            // Cria um pacote UDP com os dados a serem enviados
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIpAddress, serverPort);
            // Envia o pacote para o servidor
            clientSocket.send(sendPacket);
            // Fecha a conexão do socket
            clientSocket.close();

        } catch (Exception e) {
            // Imprime qualquer exceção que ocorra durante a comunicação
            System.out.println(e.toString());
        }
    }
}

