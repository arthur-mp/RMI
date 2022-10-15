package RMI.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 *
 * Interface Remota do Cliente
 */
public interface Client extends Remote {

    // Metodo responsavel pela troca de jogador, dado o proximo jogador
    void changePlayer(String message) throws RemoteException;

    void initializePlayer(String client) throws RemoteException;

}
