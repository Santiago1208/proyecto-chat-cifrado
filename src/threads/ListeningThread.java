package threads;

import java.io.IOException;
import java.net.ServerSocket;
import model.User;

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
    
    /**
     * Represents the user listening.
     */
    private User user;
    
    // ---------------------------------------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------------------------------------

    public ListeningThread(ServerSocket server, User user) {
        this.server = server;
        this.user = user;
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
