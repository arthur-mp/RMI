package RMI.Server;

import RMI.Client.Client;
import Utils.Messages;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImp extends UnicastRemoteObject implements Server{
    private static final long serialVersionUID = 1L;

    private List<Client> clients = new ArrayList<Client>();
    private boolean client1Connection = false;
    private boolean client2Connection = false;
    public ServerImp() throws RemoteException {
       super();
    }

    @Override
    public void connect(String clientServer) throws RemoteException {
        if(clientServer != null && clients.size() <= 2){
          try{
              Client client = (Client) Naming.lookup(clientServer);
              clients.add(client);
          }catch (Exception e){
              e.printStackTrace();
          }
        }
        if(clients.size() == 2){
            clients.get(0).initializePlayer(Messages.CONNECTCLIENT1.getValue());
            client1Connection = true;
        }
    }

    @Override
    public void receiveMessage(String message, String clientServer) throws RemoteException {
            try{
                Client client = (Client) Naming.lookup(clientServer);
                int index = clients.indexOf(client);
                if(!message.equals(Messages.FINISH.getValue())){
                    switch (index){
                        case 0:
                            if(!client2Connection){
                                client2Connection = true;
                                clients.get(1).initializePlayer(Messages.CONNECTCLIENT2.getValue());
                            }
                            clients.get(1).changePlayer(message);
                            break;
                        case 1:
                            clients.get(0).changePlayer(message);
                            break;
                    }
                }


            }catch (Exception e){
                e.printStackTrace();
            }
    }

    @Override
    public void disconnect(String clientServer) throws RemoteException {
       try{
           Client client = (Client) Naming.lookup(clientServer);
           int index = clients.indexOf(client);
          if(clients.size() != 0){
              switch (index){
                  case 0:
                      if(!client2Connection){
                          client2Connection = true;
                          clients.get(1).initializePlayer(Messages.CONNECTCLIENT2.getValue());
                      }
                      clients.get(1).changePlayer(Messages.FINISH.getValue());
                      break;
                  case 1:
                      clients.get(0).changePlayer(Messages.FINISH.getValue());
                      break;
              }
          }
           clients.clear();
           System.exit(0);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    // Disponibiliza os serviços do servidor
    public  void startServer(){

        try{
            Registry registry = LocateRegistry.createRegistry(1099);
            Server server = new ServerImp();
            Naming.rebind("Servidor", server);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws RemoteException {
//        new ServerImp();
//        startServer();
//    }
}
