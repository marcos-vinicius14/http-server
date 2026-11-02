package dev.marcos;

import dev.marcos.tcp.TcpServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
  public static void main(String[] args) {
    TcpServer tcpServer = new TcpServer();

    try (ServerSocket serverSocket = tcpServer.createTcpServer(4221)) {

      while (true) {
        try (Socket clientSocket = tcpServer.acceptConnection(serverSocket)) {
          System.out.println(
              "TCP connection is sucessfull established ond addr "
                  + clientSocket.getRemoteSocketAddress());
        }
      }
    } catch (IOException ex) {
      System.err.println("Erro no servidor TCP " + ex.getMessage());
    }
  }
}
