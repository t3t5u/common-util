package com.github.t3t5u.common.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SecurityUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtils.class);

	private SecurityUtils() {
	}

	public static byte[] digestOrNull(final String algorithm, final byte[] input) {
		try {
			return digest(algorithm, input);
		} catch (final Throwable t) {
			LOGGER.info("digestOrNull", t);
			return null;
		}
	}

	public static byte[] digest(final String algorithm, final byte[] input) {
		try {
			return getMessageDigest(algorithm).digest(input);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("digest", e);
			throw new RuntimeException(e);
		}
	}

	public static MessageDigest digesterOrNull(final String algorithm) {
		try {
			return digester(algorithm);
		} catch (final Throwable t) {
			LOGGER.info("digesterOrNull", t);
			return null;
		}
	}

	public static MessageDigest digester(final String algorithm) {
		try {
			return getMessageDigest(algorithm);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("digester", e);
			throw new RuntimeException(e);
		}
	}

	public static KeyPair generateKeyPairOrNull(final String algorithm) {
		try {
			return generateKeyPair(algorithm);
		} catch (final Throwable t) {
			LOGGER.info("generateKeyPairOrNull", t);
			return null;
		}
	}

	public static KeyPair generateKeyPair(final String algorithm) {
		try {
			return getKeyPairGenerator(algorithm).generateKeyPair();
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generateKeyPair", e);
			throw new RuntimeException(e);
		}
	}

	public static KeyPair generateKeyPairOrNull(final String algorithm, final int keysize) {
		try {
			return generateKeyPair(algorithm, keysize);
		} catch (final Throwable t) {
			LOGGER.info("generateKeyPairOrNull", t);
			return null;
		}
	}

	public static KeyPair generateKeyPair(final String algorithm, final int keysize) {
		try {
			return getKeyPairGenerator(algorithm, keysize).generateKeyPair();
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generateKeyPair", e);
			throw new RuntimeException(e);
		}
	}

	public static PublicKey generatePublicKeyOrNull(final String algorithm, final byte[] encodedKey) {
		try {
			return generatePublicKey(algorithm, encodedKey);
		} catch (final Throwable t) {
			LOGGER.info("generatePublicKeyOrNull", t);
			return null;
		}
	}

	public static PublicKey generatePublicKey(final String algorithm, final byte[] encodedKey) {
		try {
			return getKeyFactory(algorithm).generatePublic(new X509EncodedKeySpec(encodedKey));
		} catch (final InvalidKeySpecException e) {
			LOGGER.warn("generatePublicKey", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generatePublicKey", e);
			throw new RuntimeException(e);
		}
	}

	public static PublicKey generatePublicKeyOrNull(final String algorithm, final KeySpec keySpec) {
		try {
			return generatePublicKey(algorithm, keySpec);
		} catch (final Throwable t) {
			LOGGER.info("generatePublicKeyOrNull", t);
			return null;
		}
	}

	public static PublicKey generatePublicKey(final String algorithm, final KeySpec keySpec) {
		try {
			return getKeyFactory(algorithm).generatePublic(keySpec);
		} catch (final InvalidKeySpecException e) {
			LOGGER.warn("generatePublicKey", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generatePublicKey", e);
			throw new RuntimeException(e);
		}
	}

	public static PrivateKey generatePrivateKeyOrNull(final String algorithm, final byte[] encodedKey) {
		try {
			return generatePrivateKey(algorithm, encodedKey);
		} catch (final Throwable t) {
			LOGGER.info("generatePrivateKeyOrNull", t);
			return null;
		}
	}

	public static PrivateKey generatePrivateKey(final String algorithm, final byte[] encodedKey) {
		try {
			return getKeyFactory(algorithm).generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
		} catch (final InvalidKeySpecException e) {
			LOGGER.warn("generatePrivateKey", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generatePrivateKey", e);
			throw new RuntimeException(e);
		}
	}

	public static PrivateKey generatePrivateKeyOrNull(final String algorithm, final KeySpec keySpec) {
		try {
			return generatePrivateKey(algorithm, keySpec);
		} catch (final Throwable t) {
			LOGGER.info("generatePrivateKeyOrNull", t);
			return null;
		}
	}

	public static PrivateKey generatePrivateKey(final String algorithm, final KeySpec keySpec) {
		try {
			return getKeyFactory(algorithm).generatePrivate(keySpec);
		} catch (final InvalidKeySpecException e) {
			LOGGER.warn("generatePrivateKey", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generatePrivateKey", e);
			throw new RuntimeException(e);
		}
	}

	public static SecretKey generateSecretKeyOrNull(final String algorithm, final KeySpec keySpec) {
		try {
			return generateSecretKey(algorithm, keySpec);
		} catch (final Throwable t) {
			LOGGER.info("generateSecretKeyOrNull", t);
			return null;
		}
	}

	public static SecretKey generateSecretKey(final String algorithm, final KeySpec keySpec) {
		try {
			return getSecretKeyFactory(algorithm).generateSecret(keySpec);
		} catch (final InvalidKeySpecException e) {
			LOGGER.warn("generateSecretKey", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generateSecretKey", e);
			throw new RuntimeException(e);
		}
	}

	public static SecretKey generateSecretKeyOrNull(final String algorithm) {
		try {
			return generateSecretKey(algorithm);
		} catch (final Throwable t) {
			LOGGER.info("generateSecretKeyOrNull", t);
			return null;
		}
	}

	public static SecretKey generateSecretKey(final String algorithm) {
		try {
			return getKeyGenerator(algorithm).generateKey();
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generateSecretKey", e);
			throw new RuntimeException(e);
		}
	}

	public static SecretKey generateSecretKeyOrNull(final String algorithm, final int keysize) {
		try {
			return generateSecretKey(algorithm, keysize);
		} catch (final Throwable t) {
			LOGGER.info("generateSecretKeyOrNull", t);
			return null;
		}
	}

	public static SecretKey generateSecretKey(final String algorithm, final int keysize) {
		try {
			return getKeyGenerator(algorithm, keysize).generateKey();
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("generateSecretKey", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] signOrNull(final String algorithm, final PrivateKey privateKey, final byte[] data) {
		try {
			return sign(algorithm, privateKey, data);
		} catch (final Throwable t) {
			LOGGER.info("signOrNull", t);
			return null;
		}
	}

	public static byte[] sign(final String algorithm, final PrivateKey privateKey, final byte[] data) {
		try {
			return getSignature(algorithm, privateKey, data).sign();
		} catch (final InvalidKeyException e) {
			LOGGER.warn("sign", e);
			throw new RuntimeException(e);
		} catch (final SignatureException e) {
			LOGGER.warn("sign", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("sign", e);
			throw new RuntimeException(e);
		}
	}

	public static Signature signerOrNull(final String algorithm, final PrivateKey privateKey) {
		try {
			return signer(algorithm, privateKey);
		} catch (final Throwable t) {
			LOGGER.info("signerOrNull", t);
			return null;
		}
	}

	public static Signature signer(final String algorithm, final PrivateKey privateKey) {
		try {
			return getSignature(algorithm, privateKey);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("signer", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("signer", e);
			throw new RuntimeException(e);
		}
	}

	public static Boolean verifyOrNull(final String algorithm, final PublicKey publicKey, final byte[] data, final byte[] signature) {
		try {
			return verify(algorithm, publicKey, data, signature);
		} catch (final Throwable t) {
			LOGGER.info("verifyOrNull", t);
			return false;
		}
	}

	public static boolean verify(final String algorithm, final PublicKey publicKey, final byte[] data, final byte[] signature) {
		try {
			return getSignature(algorithm, publicKey, data).verify(signature);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("verify", e);
			throw new RuntimeException(e);
		} catch (final SignatureException e) {
			LOGGER.warn("verify", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("verify", e);
			throw new RuntimeException(e);
		}
	}

	public static Signature verifierOrNull(final String algorithm, final PublicKey publicKey) {
		try {
			return verifier(algorithm, publicKey);
		} catch (final Throwable t) {
			LOGGER.info("verifierOrNull", t);
			return null;
		}
	}

	public static Signature verifier(final String algorithm, final PublicKey publicKey) {
		try {
			return getSignature(algorithm, publicKey);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("verifier", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("verifier", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] encryptOrNull(final String transformation, final Key key, final byte[] input) {
		try {
			return encrypt(transformation, key, input);
		} catch (final Throwable t) {
			LOGGER.info("encryptOrNull", t);
			return null;
		}
	}

	public static byte[] encrypt(final String transformation, final Key key, final byte[] input) {
		try {
			return encrypt(getCipher(transformation), key, input, null);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final IllegalBlockSizeException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final BadPaddingException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] encryptOrNull(final String transformation, final Key key, final byte[] input, final byte[] iv) {
		try {
			return encrypt(transformation, key, input, iv);
		} catch (final Throwable t) {
			LOGGER.info("encryptOrNull", t);
			return null;
		}
	}

	public static byte[] encrypt(final String transformation, final Key key, final byte[] input, final byte[] iv) {
		try {
			return encrypt(getCipher(transformation), key, input, iv);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final IllegalBlockSizeException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final BadPaddingException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("encrypt", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] decryptOrNull(final String transformation, final Key key, final byte[] input) {
		try {
			return decrypt(transformation, key, input);
		} catch (final Throwable t) {
			LOGGER.info("decryptOrNull", t);
			return null;
		}
	}

	public static byte[] decrypt(final String transformation, final Key key, final byte[] input) {
		try {
			return decrypt(getCipher(transformation), key, input, null);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final IllegalBlockSizeException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final BadPaddingException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		}
	}

	public static byte[] decryptOrNull(final String transformation, final Key key, final byte[] input, final byte[] iv) {
		try {
			return decrypt(transformation, key, input, iv);
		} catch (final Throwable t) {
			LOGGER.info("decryptOrNull", t);
			return null;
		}
	}

	public static byte[] decrypt(final String transformation, final Key key, final byte[] input, final byte[] iv) {
		try {
			return decrypt(getCipher(transformation), key, input, iv);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final IllegalBlockSizeException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final BadPaddingException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("decrypt", e);
			throw new RuntimeException(e);
		}
	}

	public static Cipher encipherOrNull(final String transformation, final Key key) {
		try {
			return encipher(transformation, key);
		} catch (final Throwable t) {
			LOGGER.info("encipherOrNull", t);
			return null;
		}
	}

	public static Cipher encipher(final String transformation, final Key key) {
		try {
			return encipher(getCipher(transformation), key, null);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("encipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("encipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("encipher", e);
			throw new RuntimeException(e);
		}
	}

	public static Cipher encipherOrNull(final String transformation, final Key key, final byte[] iv) {
		try {
			return encipher(transformation, key, iv);
		} catch (final Throwable t) {
			LOGGER.info("encipherOrNull", t);
			return null;
		}
	}

	public static Cipher encipher(final String transformation, final Key key, final byte[] iv) {
		try {
			return encipher(getCipher(transformation), key, iv);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("encipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("encipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("encipher", e);
			throw new RuntimeException(e);
		}
	}

	public static Cipher decipherOrNull(final String transformation, final Key key) {
		try {
			return decipher(transformation, key);
		} catch (final Throwable t) {
			LOGGER.info("decipherOrNull", t);
			return null;
		}
	}

	public static Cipher decipher(final String transformation, final Key key) {
		try {
			return decipher(getCipher(transformation), key, null);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("decipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("decipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("decipher", e);
			throw new RuntimeException(e);
		}
	}

	public static Cipher decipherOrNull(final String transformation, final Key key, final byte[] iv) {
		try {
			return decipher(transformation, key, iv);
		} catch (final Throwable t) {
			LOGGER.info("decipherOrNull", t);
			return null;
		}
	}

	public static Cipher decipher(final String transformation, final Key key, final byte[] iv) {
		try {
			return decipher(getCipher(transformation), key, iv);
		} catch (final InvalidKeyException e) {
			LOGGER.warn("decipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchAlgorithmException e) {
			LOGGER.warn("decipher", e);
			throw new RuntimeException(e);
		} catch (final NoSuchPaddingException e) {
			LOGGER.warn("decipher", e);
			throw new RuntimeException(e);
		}
	}

	private static MessageDigest getMessageDigest(final String algorithm) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance(algorithm);
	}

	private static KeyPairGenerator getKeyPairGenerator(final String algorithm) throws NoSuchAlgorithmException {
		return KeyPairGenerator.getInstance(algorithm);
	}

	private static KeyPairGenerator getKeyPairGenerator(final String algorithm, final int keysize) throws NoSuchAlgorithmException {
		final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
		keyPairGenerator.initialize(keysize);
		return keyPairGenerator;
	}

	private static KeyFactory getKeyFactory(final String algorithm) throws NoSuchAlgorithmException {
		return KeyFactory.getInstance(algorithm);
	}

	private static SecretKeyFactory getSecretKeyFactory(final String algorithm) throws NoSuchAlgorithmException {
		return SecretKeyFactory.getInstance(algorithm);
	}

	private static KeyGenerator getKeyGenerator(final String algorithm) throws NoSuchAlgorithmException {
		return KeyGenerator.getInstance(algorithm);
	}

	private static KeyGenerator getKeyGenerator(final String algorithm, final int keysize) throws NoSuchAlgorithmException {
		final KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
		keyGenerator.init(keysize);
		return keyGenerator;
	}

	private static Signature getSignature(final String algorithm, final PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException {
		final Signature signature = Signature.getInstance(algorithm);
		signature.initSign(privateKey);
		return signature;
	}

	private static Signature getSignature(final String algorithm, final PrivateKey privateKey, final byte[] data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		final Signature signature = Signature.getInstance(algorithm);
		signature.initSign(privateKey);
		signature.update(data);
		return signature;
	}

	private static Signature getSignature(final String algorithm, final PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException {
		final Signature signature = Signature.getInstance(algorithm);
		signature.initVerify(publicKey);
		return signature;
	}

	private static Signature getSignature(final String algorithm, final PublicKey publicKey, final byte[] data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		final Signature signature = Signature.getInstance(algorithm);
		signature.initVerify(publicKey);
		signature.update(data);
		return signature;
	}

	private static Cipher getCipher(final String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
		return Cipher.getInstance(transformation);
	}

	private static byte[] encrypt(final Cipher cipher, final Key key, final byte[] input, final byte[] iv) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return !ArrayUtils.isEmpty(iv) ? doEncrypt(cipher, key, input, iv) : doEncrypt(cipher, key, input);
	}

	private static byte[] doEncrypt(final Cipher cipher, final Key key, final byte[] input, final byte[] iv) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		final int blockSize = getBlockSize(cipher);
		doInit(cipher, Cipher.ENCRYPT_MODE, key, blockSize > 0 ? new IvParameterSpec(ArrayUtils.subarray(iv, 0, blockSize)) : null);
		return cipher.doFinal(input);
	}

	private static byte[] doEncrypt(final Cipher cipher, final Key key, final byte[] input) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		final byte[] iv = doInit(cipher, Cipher.ENCRYPT_MODE, key, (AlgorithmParameterSpec) null);
		return !ArrayUtils.isEmpty(iv) ? ArrayUtils.addAll(iv, cipher.doFinal(input)) : cipher.doFinal(input);
	}

	private static byte[] decrypt(final Cipher cipher, final Key key, final byte[] input, final byte[] iv) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return !ArrayUtils.isEmpty(iv) ? doDecrypt(cipher, key, input, iv) : doDecrypt(cipher, key, input);
	}

	private static byte[] doDecrypt(final Cipher cipher, final Key key, final byte[] input, final byte[] iv) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		final int blockSize = getBlockSize(cipher);
		doInit(cipher, Cipher.DECRYPT_MODE, key, blockSize > 0 ? new IvParameterSpec(ArrayUtils.subarray(iv, 0, blockSize)) : null);
		return cipher.doFinal(input);
	}

	private static byte[] doDecrypt(final Cipher cipher, final Key key, final byte[] input) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		final int blockSize = getBlockSize(cipher);
		final byte[] iv = doInit(cipher, Cipher.DECRYPT_MODE, key, blockSize > 0 ? new IvParameterSpec(ArrayUtils.subarray(input, 0, blockSize)) : null);
		return !ArrayUtils.isEmpty(iv) ? cipher.doFinal(input, iv.length, input.length - iv.length) : cipher.doFinal(input);
	}

	private static Cipher encipher(final Cipher cipher, final Key key, final byte[] iv) throws InvalidKeyException {
		final int opmode = Cipher.ENCRYPT_MODE;
		return !ArrayUtils.isEmpty(iv) ? doInit(cipher, opmode, key, iv) : doInit(cipher, opmode, key);
	}

	private static Cipher decipher(final Cipher cipher, final Key key, final byte[] iv) throws InvalidKeyException {
		final int opmode = Cipher.DECRYPT_MODE;
		return !ArrayUtils.isEmpty(iv) ? doInit(cipher, opmode, key, iv) : doInit(cipher, opmode, key);
	}

	private static Cipher doInit(final Cipher cipher, final int opmode, final Key key, final byte[] iv) throws InvalidKeyException {
		final int blockSize = getBlockSize(cipher);
		doInit(cipher, opmode, key, blockSize > 0 ? new IvParameterSpec(ArrayUtils.subarray(iv, 0, blockSize)) : null);
		return cipher;
	}

	private static Cipher doInit(final Cipher cipher, final int opmode, final Key key) throws InvalidKeyException {
		doInit(cipher, opmode, key, (AlgorithmParameterSpec) null);
		return cipher;
	}

	private static byte[] doInit(final Cipher cipher, final int opmode, final Key key, final AlgorithmParameterSpec params) throws InvalidKeyException {
		if (params == null) {
			return init(cipher, opmode, key);
		}
		try {
			return init(cipher, opmode, key, params);
		} catch (final InvalidAlgorithmParameterException e) {
			LOGGER.info("init", e);
			return init(cipher, opmode, key);
		}
	}

	private static byte[] init(final Cipher cipher, final int opmode, final Key key) throws InvalidKeyException {
		cipher.init(opmode, key);
		return getIV(cipher);
	}

	private static byte[] init(final Cipher cipher, final int opmode, final Key key, final AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
		cipher.init(opmode, key, params);
		return getIV(cipher);
	}

	private static byte[] getIV(final Cipher cipher) {
		try {
			return cipher.getIV();
		} catch (final Throwable t) {
			LOGGER.info("getIV", t);
			return null;
		}
	}

	private static int getBlockSize(final Cipher cipher) {
		try {
			return cipher.getBlockSize();
		} catch (final Throwable t) {
			LOGGER.info("getBlockSize", t);
			return -1;
		}
	}
}
