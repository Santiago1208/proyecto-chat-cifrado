package co.edu.icesi.ciberSecurityProject.client.gui;

import co.edu.icesi.ciberSecurityProject.model.Commands;
import co.edu.icesi.ciberSecurityProject.model.ConversationDataPackage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azo_6
 */
public class ClientsConnectedListenener extends Thread {

        private ClientsConnected cc;

    public ClientsConnectedListenener(ClientsConnected cc) {
        this.cc = cc;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9091);
            Socket channel = server.accept();
            ConversationDataPackage data = new ConversationDataPackage();
            processCommand(data, channel);
        } catch (IOException ex) {
            Logger.getLogger(ClientsConnectedListenener.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ClientsConnectedListenener.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void processCommand(ConversationDataPackage data, Socket channel) throws NoSuchAlgorithmException, IOException {
        String code = data.getCode();
        if (code.equals(Commands.DH_KEYS)) {
            KeyPair keyPair = cc.generateKeyPair();
            
            ObjectOutputStream out = new ObjectOutputStream(channel.getOutputStream());
            data.setFriendKeys(keyPair);
            data.setCode(Commands.DH_RESPONSE_KEYS);
            out.writeObject(data);
            out.close();
        }
    }
    
    
}
