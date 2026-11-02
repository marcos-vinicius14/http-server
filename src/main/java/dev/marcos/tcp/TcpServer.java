package dev.marcos.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *  ServerSocket e responsavel por escutar e aceitar conexoes tcp
 *  ServerSocket: Aguarda novas conexoes
 *  Socket: represanta conexoes ja estabelecidas
 *
 * */
public class TcpServer {

  // Cria um servidor TCP e deixa-o preparado para receber conexoes
  public ServerSocket createTcpServer(int port) throws IOException {
    ServerSocket serverSocket = new ServerSocket(port);

    return serverSocket;
  }

  // recebe um Socket existente, aguarda uma conexao e retorna o socket do client
  public Socket acceptConnection(ServerSocket socket) throws IOException {
    Socket clientSocket = socket.accept();

    return clientSocket;
  }
}
