/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
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
    
    
    // ---------------------------------------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------------------------------------
    
    
    
    // ---------------------------------------------------------------------------------------------------
    // Services
    // ---------------------------------------------------------------------------------------------------
}
