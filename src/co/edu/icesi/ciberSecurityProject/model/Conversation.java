package co.edu.icesi.ciberSecurityProject.model;

import java.security.KeyPair;
import javax.crypto.KeyAgreement;

/**
 *
 * @author Santiago
 */
public class Conversation {
    
    private String loggedIPAddress;
    
    private String friendIPAddress;
    
    private KeyPair userKeyPair;
    
    private KeyPair friendKeyPair;
    
    private KeyAgreement commonKey;

    public Conversation() {
    
    }
    
    

    public Conversation(String loggedIPAddress, String friendIPAddress) {
        this.loggedIPAddress = loggedIPAddress;
        this.friendIPAddress = friendIPAddress;
    }

    public String getLoggedIPAddress() {
        return loggedIPAddress;
    }

    public void setLoggedIPAddress(String loggedIPAddress) {
        this.loggedIPAddress = loggedIPAddress;
    }

    public String getFriendIPAddress() {
        return friendIPAddress;
    }

    public void setFriendIPAddress(String friendIPAddress) {
        this.friendIPAddress = friendIPAddress;
    }

    public KeyPair getUserKeyPair() {
        return userKeyPair;
    }

    public void setUserKeyPair(KeyPair userKeyPair) {
        this.userKeyPair = userKeyPair;
    }

    public KeyPair getFriendKeyPair() {
        return friendKeyPair;
    }

    public void setFriendKeyPair(KeyPair friendKeyPair) {
        this.friendKeyPair = friendKeyPair;
    }
    
    public KeyAgreement getCommonKey() {
        return commonKey;
    }

    public void setCommonKey(KeyAgreement commonKey) {
        this.commonKey = commonKey;
    }
    
    
    
}
