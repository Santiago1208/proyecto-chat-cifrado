/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.ciberSecurityProject.model;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.KeyAgreement;

/**
 *
 * @author Santiago
 */
public class Conversation {
    
    private User logged;
    
    private User friend;
    
    private PublicKey publicKey;
    
    private PrivateKey privateKey;
    
    private PublicKey friendPublicKey;
    
    private PrivateKey friendPrivateKey;
    
    private KeyAgreement commonKey;

    public User getLogged() {
        return logged;
    }

    public void setLogged(User logged) {
        this.logged = logged;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public PublicKey getFriendPublicKey() {
        return friendPublicKey;
    }

    public void setFriendPublicKey(PublicKey friendPublicKey) {
        this.friendPublicKey = friendPublicKey;
    }

    public PrivateKey getFriendPrivateKey() {
        return friendPrivateKey;
    }

    public void setFriendPrivateKey(PrivateKey friendPrivateKey) {
        this.friendPrivateKey = friendPrivateKey;
    }
    

    public KeyAgreement getCommonKey() {
        return commonKey;
    }

    public void setCommonKey(KeyAgreement commonKey) {
        this.commonKey = commonKey;
    }
    
    
    
}
