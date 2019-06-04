package co.edu.icesi.ciberSecurityProject.client.gui;

import co.edu.icesi.ciberSecurityProject.model.Commands;
import co.edu.icesi.ciberSecurityProject.model.ConversationDataPackage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class ClientListeningThread extends Thread {
    
    private ClientChat owner;

    public ClientListeningThread(ClientChat owner) {
        this.owner = owner;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9090);
            Socket channel = server.accept();
            ObjectInputStream in = new ObjectInputStream(channel.getInputStream());
            ConversationDataPackage data = (ConversationDataPackage) in.readObject();
            processCommand(data);
            
        } catch (IOException ex) {
            Logger.getLogger(ClientListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void processCommand(ConversationDataPackage data) {
        String code = data.getCode();
        if (code.equals(Commands.START_CONVERSATION)) {
            // Diffie Hellman
        } else {
            // desencriptar mensaje
            // concatenar mensaje a la vista
        }
    }
    
}