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
    
    public void addConversation(Conversation c) {
        String friendIPAddress = c.getFriend().getIpAddress();
        boolean exists = false;
        for (int i = 0; i < conversations.size(); i++) {
            Conversation current = conversations.get(i);
            if (current.getFriend().getIpAddress().equals(friendIPAddress)) {
                exists = true;
            }
        }
        if (!exists) {
            conversations.add(c);
        }
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
