package RMI.Server;


import java.rmi.Remote;
import java.rmi.RemoteException;

/*
*
* Interface Remota do Servidor
*/
public interface Server extends Remote {

    // Metodo responsavel por receber e armazenar a conexao do cliente
    void connect(String client) throws RemoteException;

    // Metodo responsavel por receber a mensagem(jogada) do cliente
    void receiveMessage(String message, String clientServer) throws RemoteException;

    // Metodo responsavel por encerrar a conexao de determinado cliente
    void disconnect(String client) throws RemoteException;

}
