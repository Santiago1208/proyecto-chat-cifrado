/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Thread responsible for attend new connections for the clients.
 * @author Santiago
 */
public class ListeningThread extends Thread {
    
    // ---------------------------------------------------------------------------------------------------
    // Fields
    // ---------------------------------------------------------------------------------------------------
    
    /**
     * Represents the channel through connection with clients is stablished.
     */
    private final ServerSocket server;
    
    // ---------------------------------------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------------------------------------

    public ListeningThread(ServerSocket server) {
        this.server = server;
    }    

    // ---------------------------------------------------------------------------------------------------
    // Services
    // ---------------------------------------------------------------------------------------------------    

    @Override
    public void run() {
        while (true) {
            try {
                server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
