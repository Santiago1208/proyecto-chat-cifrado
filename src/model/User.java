package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Class which represents an user who wants to chat with other user.
 *
 * @author Santiago
 */
public class User {
    
    // ---------------------------------------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------------------------------------
    
    /**
     * It's the user's username.
     */
    private String username;
    
    /**
     * It's the user's private key to encrypt messages.
     */
    private PrivateKey privateKey;
    
    /**
     * It's the user's public key to decrypt messages.
     */
    private PublicKey publicKey;
    
    /**
     * It's the channel used to send messages to another user.
     */
    private Socket channel;
    
    /**
     * It's the object used to write on the channel.
     */
    private PrintWriter writer;
    
    /**
     * It's the object used to read from the channel.
     */
    private BufferedReader reader;
    
    // ---------------------------------------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------------------------------------
    
    public User(String username, Socket channel) throws IOException {
        this.username = username;
        this.privateKey = null;
        this.publicKey = null;
        this.channel = channel;
        this.writer = new PrintWriter(channel.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
    }
    
    // ---------------------------------------------------------------------------------------------------
    // Services
    // ---------------------------------------------------------------------------------------------------

    
}
