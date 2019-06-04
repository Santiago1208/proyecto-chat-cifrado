package co.edu.icesi.ciberSecurityProject.server;

import co.edu.icesi.ciberSecurityProject.model.Commands;
import co.edu.icesi.ciberSecurityProject.model.ConversationDataPackage;
import co.edu.icesi.ciberSecurityProject.model.User;
import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class ServerListeningThread extends Thread {

    private ServerFrame owner;

    public ServerListeningThread(ServerFrame owner) {
        this.owner = owner;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9999);
            while (true) {
                Socket channel = server.accept();
                ObjectInputStream in = new ObjectInputStream(channel.getInputStream());
                ConversationDataPackage data = (ConversationDataPackage) in.readObject();
                processPackage(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processPackage(ConversationDataPackage data) {
        String code = data.getCode();
        if (code.equals(Commands.CONNECT)) {
            User u = new User(data.getUserNickName(), data.getFriendIPAddress(), Commands.CONNECTED);
            //owner.addUser(u)
        } else if (code.equals(Commands.DISCONNECT)) {
            //owner.removeUser(data.getUserNickName());
        } else {
            redirectMessage(data);
        }
    }
    
    private void redirectMessage(ConversationDataPackage data) {
        try {
            Socket channel = new Socket(data.getFriendIPAddress(), 9090);
            ObjectOutputStream out = new ObjectOutputStream(channel.getOutputStream());
            out.writeObject(data);
            out.close();
            channel.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
