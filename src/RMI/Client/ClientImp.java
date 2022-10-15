package RMI.Client;

import RMI.Server.Server;
import Utils.Messages;
import Utils.Window;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ClientImp extends UnicastRemoteObject implements Client {

    Window window;

    Server server;
    public ClientImp(Window window) throws RemoteException{
        super();
        this.window = window;
    }

    @Override
    public void changePlayer(String message) throws RemoteException {
        if(message.equals(Messages.FINISH.getValue())){
            System.exit(0);
        }
        window.updateTable(message);
    }

    @Override
    public void initializePlayer(String client) throws RemoteException {
        window.isClient(client);

        if(client.equals(Messages.CONNECTCLIENT1.getValue()))
            window.enableTable();
    }

    // Disponibiliza os serviços do cliente
    public  void startClient(){
        try{
            LocateRegistry.getRegistry(1099);
            Client client = new ClientImp(window);
            Naming.rebind(window.getNamePlayer(), client);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Conexão
    // Primeiro contato do cliente com o servidor
    public  void connectServer(){
        try {
            server = (Server) Naming.lookup("Servidor");
            server.connect(window.getNamePlayer());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Enviar mensagem para o servidor
    public void sendServer(String message, String clientServer){
        try{
            window.disabledTable();
            server.receiveMessage(message, clientServer);
            if(message.equals(Messages.FINISH.getValue())){
                exitClient();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void exitClient(){
       try{
           server.disconnect(window.getNamePlayer());
           System.exit(0);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
