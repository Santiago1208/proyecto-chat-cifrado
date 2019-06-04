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
    
    private PublicKey publicKey;
    
    private PrivateKey privateKey;
    
    private KeyAgreement commonKey;
    
}
