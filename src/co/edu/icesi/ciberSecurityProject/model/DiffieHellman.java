package co.edu.icesi.ciberSecurityProject.model;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;


import javax.crypto.KeyAgreement;

public class DiffieHellman {

	private PrivateKey privateKey;
	private PublicKey publicKey;
	private PublicKey receivedPublicKey;
	private byte[] secretKey;

	//Metodo que genera la clave secreta en comun
	public void generateCommonSecretKey() {

		try {
			final KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
			keyAgreement.init(privateKey);
			keyAgreement.doPhase(receivedPublicKey, true);

			secretKey = shortenSecretKey(keyAgreement.generateSecret());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Metodo que genera las claves
	public void generateKeys() {

		try {
			final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
			keyPairGenerator.initialize(1024);

			final KeyPair keyPair = keyPairGenerator.generateKeyPair();

			privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private byte[] shortenSecretKey(final byte[] longKey) {

		try {
			final byte[] shortenedKey = new byte[8];

			System.arraycopy(longKey, 0, shortenedKey, 0, shortenedKey.length);

			return shortenedKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	 public void receivePublicKeyFrom(final Person person) {
//
//	        receivedPublicKey = person.getPublicKey();
//	    }
}

