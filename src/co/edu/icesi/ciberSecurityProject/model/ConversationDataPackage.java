package co.edu.icesi.ciberSecurityProject.model;

import java.io.Serializable;

/**
 *
 * @author Santiago
 */
public class ConversationDataPackage implements Serializable {
    
    private String userNickName;
    
    private String ipAddress;
    
    private String friendIPAddress;
    
    private String message;
    
    private String code;

    public ConversationDataPackage() {
    
    }

    public ConversationDataPackage(String userNickName, String ipAddress, String friendIPAddress, String message, String code) {
        this.userNickName = userNickName;
        this.ipAddress = ipAddress;
        this.friendIPAddress = friendIPAddress;
        this.message = message;
        this.code = code;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    

    public String getFriendIPAddress() {
        return friendIPAddress;
    }

    public void setFriendIPAddress(String friendIPAddress) {
        this.friendIPAddress = friendIPAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
