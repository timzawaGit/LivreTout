package fr.doranco.livretout.control.cryptage.algo;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import fr.doranco.livretout.enums.AlgoCryptage;


public class CryptageDES {

	private CryptageDES() {
	}

	public final static byte[] encrypt(String messageToEncrypt, SecretKey key) throws Exception {

		// On choisit l'algorithme de cryptage
		Cipher cipher = Cipher.getInstance(AlgoCryptage.DES.toString());
		
		// On initialise le mode à appliquer (ici : cryptage)
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		// On transforme le message à crypter en bytes
		byte[] messageInByte = messageToEncrypt.getBytes("UTF-8");
		
		// On réalise l'opération de décryptage.
		byte[] messageEncrypte = cipher.doFinal(messageInByte);
		
		return messageEncrypte;
	}

	public final static String decrypt(byte[] messageToDecrypt, SecretKey key) throws Exception {
		
		// On choisit l'algorithme de cryptage
		Cipher cipher = Cipher.getInstance(AlgoCryptage.DES.toString());
		
		// On initialise le mode à appliquer (ici : cryptage)
		cipher.init(Cipher.DECRYPT_MODE, key);

		// On réalise l'opération de décryptage.
		byte[] messageDecrypte = cipher.doFinal(messageToDecrypt);
		
		// On transforme le message décrypté en String
		String originalMessage = new String(messageDecrypte, "UTF-8");
		
		return originalMessage;

	}
}
