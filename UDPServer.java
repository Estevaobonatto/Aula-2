
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDPServer {

    /**
     * Método principal do servidor UDP.
     * Recebe mensagens de um cliente UDP em loop.
     * @param args - Parâmetros de linha de comando (não utilizados)
     */
    public static void main(String[] args){
        // Define a porta do servidor
        int serverPort = 9876;
        try{
            // Cria um socket UDP para receber as mensagens
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            // Cria um array para receber os dados do pacote UDP
            byte[] receivedData = new byte[1024];
            // Loop infinito para receber mensagens
            while(true){
                // Cria um pacote UDP para receber os dados
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                // Recebe o pacote UDP do cliente
                serverSocket.receive(receivedPacket);
                // Converte os dados recebidos para uma string
                String receivedMessage = new String(receivedPacket.getData());
                // Imprime a mensagem recebida
                System.out.println("Mensagem recebida! " + receivedMessage);
            }
        }catch(Exception e){
            // Imprime qualquer exceção que ocorra durante a comunicação
            System.out.println(e.toString());
        }
    }


}
