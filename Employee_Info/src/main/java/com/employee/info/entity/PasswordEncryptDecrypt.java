package com.employee.info.entity;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Component;

@Component
public final class PasswordEncryptDecrypt {
	
	private static final String ALGORITHM = "AES";
	private static final byte[] keyvalue = "1234578912345781".getBytes();

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyvalue, ALGORITHM);
		return key;
	}
	
	
	public static String encrypt(String valueToEncrypt) throws Exception {

		Cipher cipher = Cipher.getInstance(ALGORITHM);

		cipher.init(Cipher.ENCRYPT_MODE, generateKey());

		byte[] encValue = cipher.doFinal(valueToEncrypt.getBytes());
		
		byte[] encryptedByteValue = Base64.encode(encValue);

		return new String(encryptedByteValue);

	}

	public static String decrypt(String valueToDecrypt) throws Exception {

		Cipher cipher = Cipher.getInstance(ALGORITHM);

		cipher.init(Cipher.DECRYPT_MODE, generateKey());

		byte[] decodedBytes = Base64.decode(valueToDecrypt.getBytes());

		return new String(cipher.doFinal(decodedBytes));
	}


}
