package co.edu.icesi.ciberSecurityProject.model;

import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class User {
    
    private String nickname;
    
    private String ipAddress;
    
    private String state;
    
    private ArrayList<Conversation> conversations;

    public User() {
    
    }
    
    
    public User(String nickname, String ipAddress, String state) {
        this.nickname = nickname;
        this.ipAddress = ipAddress;
        this.state = state;
        conversations = new ArrayList<>();
    }
    
    

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
