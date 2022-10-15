package Main;

import Interface.Aplication;
import RMI.Client.ClientImp;
import RMI.Server.ServerImp;
import Utils.Window;

import java.rmi.RemoteException;

public class Main implements Aplication {

    /*
     * Variaveis Estaticas
     *
     */
    public static Window window;

    public static ClientImp client;

    public static ServerImp server;

    public static void main(String[] args) {
        window = new Window();
    }

    /*
     * Call back:
     *
     * Ao efetuar a conexao na JFrame a aplicação
     * RMI respectiva é inicializada
     */
    @Override
    public void initialize() {
        try {
            if(window.getAplicationConnection().equals("Server")){
                server = new ServerImp();
                server.startServer();
            }
            if(window.getAplicationConnection().equals("Client")){
                client = new ClientImp(window);
                client.startClient();
                client.connectServer();
            }

        } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        }
    }

    @Override
    public void sendClient() {
        client.sendServer(window.getMove(), window.getNamePlayer());
    }
}
