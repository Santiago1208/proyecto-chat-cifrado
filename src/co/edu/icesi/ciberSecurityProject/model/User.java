package co.edu.icesi.ciberSecurityProject.model;

/**
 *
 * @author Santiago
 */
public class User {
    
    private String nickname;
    
    private String ipAddress;
    
    private String state;
    
    public User() {
    
    }
    
    
    public User(String nickname, String ipAddress, String state) {
        this.nickname = nickname;
        this.ipAddress = ipAddress;
        this.state = state;
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
