package com.github.t3t5u.common.util;

import static com.github.t3t5u.common.util.EncodingUtils.*;
import static com.github.t3t5u.common.util.SecurityUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

public class SecurityUtilsTest {
	private static final int KEYSIZE = 1024;
	// openssl genrsa -out rsa 1024
	// openssl rsa -pubout -in rsa
	private static final String RSA_PUBLIC_KEY = StringUtils.join(new String[] { "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzB/Xlp8ml17g43cL9mKfbuq9N", "jzJltcYsTgMMJNLu7/444TxLDlu9awoXmTS1ckLZzoWcWjOaMZuYV6PH9iDwDRLN", "ZbfJ4nOsl4Um11HILupdMmYXQm8MgKQ5RxdjYlhyTz2kWJ32LXm8RTaXB25kWMfB", "zRWsfISRR9IQ3bxl9wIDAQAB" });
	// openssl pkcs8 -topk8 -nocrypt -in rsa
	private static final String RSA_PRIVATE_KEY = StringUtils.join(new String[] {
			"MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALMH9eWnyaXXuDjd",
			"wv2Yp9u6r02PMmW1xixOAwwk0u7v/jjhPEsOW71rCheZNLVyQtnOhZxaM5oxm5hX",
			"o8f2IPANEs1lt8nic6yXhSbXUcgu6l0yZhdCbwyApDlHF2NiWHJPPaRYnfYtebxF",
			"NpcHbmRYx8HNFax8hJFH0hDdvGX3AgMBAAECgYBGEc2J7tubTwzJJPJWMtMvyqcl",
			"4e/FoxlG6dmDfT4ZSlDjjjP85Ee/oQ84ITxh77B+crgUc7FSnivZuiNd9dT5tooL",
			"2/yN4WRopOr/y6bxxNUZIn5kWKjyTbe2FMrfsSH41vnnX5On/RTm1ToufmHga5ML",
			"QuI5IHo4jB8XU62iIQJBAO1qEn+0SYEc1a6kLp/BNXXSXafUwHzBpksG1ADjlqwq",
			"zTgT3+k0iptD8/KitZPyFlAQtc3xOeLO6W3/2OqLTnkCQQDBC9o8qQocnE2vNwjM",
			"U6hsQVFdlJBy8izf8SduEy2zvxTDTKz3WyHoWloYuHO4RHxeeQ9AQqYIcJms1SiI",
			"SnvvAkAYTsHyHU1hUMh4BwtXA/srQwyfwGKs407ZY6uVI7grjH5SfYZxZBXE6+Iw",
			"N4SLzz+FlxBmM4qPtEumHYniCb1RAkA7iuJXT3Q0+ujjIEBwdWU/bq4gBRDAw32f",
			"3QviYbv48vj+fAnliZBd0HB1q37V2RnbMc/IbEY12DUuH9kOoJq1AkBGZX5qabhP",
			"nG0tofkwEU7vzFbmdudOcwjN/EByAid7O+CfFDScxgLIH5O08t9imaJOhkbCcnOQ",
			"/MQa4TIFB2YI" });
	// openssl dsaparam -out dsaparam 1024
	// openssl gendsa -out dsa dsaparam
	// openssl dsa -pubout -in dsa
	private static final String DSA_PUBLIC_KEY = StringUtils.join(new String[] {
			"MIIBtjCCASsGByqGSM44BAEwggEeAoGBAJf7bP2+jcZZ2VRgcnOmenuciMMlJUmM",
			"UEIMOHfrKMWUrJ4LafWkAjE946cQLmPxwNgF6KkzqQify8UNrer2aWQ6FRG0OKRC",
			"XbMIHlZSGPMChCiC2OqiSL6717W7nLZOOcV+UHiptdrjjiAcxR/DxGH9IvCgyRgj",
			"jPuFf+m96vofAhUAtXtap/lupfzDaaVLRFjZJDVqUFcCgYB4Dp5kX8+8JPSk/6fr",
			"dmbMLt2I/oJOYoDEzNFcWFrhGM/F5BPdxOEdQ1/ix6QJ1RzksBWum2DoRh1ZOXxz",
			"w3QvLigLQCoXg0+HvTTcdmWupKNeHC/4ZcAraGtuTFVy+JJjvJZ8KpmOPTdsjKTe",
			"fyTuui/dlI4eUaN3aiCqJY8CewOBhAACgYA9AnWNzoL/oxA+G0cig65EP+6jYG9u",
			"mnSl3HLJk7rIBLUGmNZToigH+1iYR49FjSz0HVVos132dlF/0l2bpwzxDJBD+keD",
			"35zTCHzYX6MZQxWgKHX3ivhRVQhXqgxJC/tzZBXchsPSjY7bOhBWMrsXd7gIcW+W",
			"1Gb6IHKHdx8TIQ==" });
	// openssl pkcs8 -topk8 -nocrypt -in dsa
	private static final String DSA_PRIVATE_KEY = StringUtils.join(new String[] {
			"MIIBSgIBADCCASsGByqGSM44BAEwggEeAoGBAJf7bP2+jcZZ2VRgcnOmenuciMMl",
			"JUmMUEIMOHfrKMWUrJ4LafWkAjE946cQLmPxwNgF6KkzqQify8UNrer2aWQ6FRG0",
			"OKRCXbMIHlZSGPMChCiC2OqiSL6717W7nLZOOcV+UHiptdrjjiAcxR/DxGH9IvCg",
			"yRgjjPuFf+m96vofAhUAtXtap/lupfzDaaVLRFjZJDVqUFcCgYB4Dp5kX8+8JPSk",
			"/6frdmbMLt2I/oJOYoDEzNFcWFrhGM/F5BPdxOEdQ1/ix6QJ1RzksBWum2DoRh1Z",
			"OXxzw3QvLigLQCoXg0+HvTTcdmWupKNeHC/4ZcAraGtuTFVy+JJjvJZ8KpmOPTds",
			"jKTefyTuui/dlI4eUaN3aiCqJY8CewQWAhRkghdC95YDNOaiUJle9z2PTy1GGA==" });
	private static final String INPUT_X8;
	private static final String INPUT_X16;
	private static final String INPUT_117;
	private static final String INPUT_128;
	static {
		final StringBuilder builderX8 = new StringBuilder();
		builderX8.append("12345678");
		builderX8.append("12345678");
		builderX8.append("12345678");
		builderX8.append("12345678");
		INPUT_X8 = builderX8.toString();
		final StringBuilder builderX16 = new StringBuilder();
		builderX16.append("1234567890123456");
		builderX16.append("1234567890123456");
		builderX16.append("1234567890123456");
		builderX16.append("1234567890123456");
		INPUT_X16 = builderX16.toString();
		final StringBuilder builder117 = new StringBuilder();
		builder117.append("12345678901234567890");
		builder117.append("12345678901234567890");
		builder117.append("12345678901234567890");
		builder117.append("12345678901234567890");
		builder117.append("12345678901234567890");
		builder117.append("12345678901234567");
		INPUT_117 = builder117.toString();
		final StringBuilder builder128 = new StringBuilder();
		builder128.append("12345678901234567890");
		builder128.append("12345678901234567890");
		builder128.append("12345678901234567890");
		builder128.append("12345678901234567890");
		builder128.append("12345678901234567890");
		builder128.append("12345678901234567890");
		builder128.append("12345678");
		INPUT_128 = builder128.toString();
	}

	@Test
	public void ハッシュ値を生成する() {
		// echo -n "てすと" | openssl dgst -md5
		assertThat(encodeHex(digest("MD5", getBytes("てすと"))), is("1c53d8d84415a5b4d10589f5cd724ca8"));
		// echo -n "てすと" | openssl dgst -sha1
		assertThat(encodeHex(digest("SHA-1", getBytes("てすと"))), is("2d2296cf8bf9abb02a8e5853ec0c08ebbfbc2aa5"));
		// echo -n "てすと" | openssl dgst -sha256
		assertThat(encodeHex(digest("SHA-256", getBytes("てすと"))), is("e715ed6eb0c8a52d8d016a8cf7d33daa39c874b134e43e6c16237db3ac360e6a"));
		// echo -n "てすと" | openssl dgst -sha384
		assertThat(encodeHex(digest("SHA-384", getBytes("てすと"))), is("856acf1e0122649919738a10bca5c91fdb240bf3772e4790a7d2c199bfb776fc0f201f6b1348a8f3a63163d6fe28d7f8"));
		// echo -n "てすと" | openssl dgst -sha512
		assertThat(encodeHex(digest("SHA-512", getBytes("てすと"))), is("1527dd12ce10ce3b28e47bedbab0d768b9d6d2a168c53fc1f1c69b5c790aa0f5114c7459936b178fd2746404c784ae122924f9b7211ef2bcb9fca4ee12cf060a"));
	}

	@Test
	public void 鍵を生成する() throws Exception {
		assertThat(generateKeyPair("RSA"), is(notNullValue()));
		assertThat(generateKeyPair("RSA", 512), is(notNullValue()));
		assertThat(generatePublicKey("RSA", decodeBase64(RSA_PUBLIC_KEY)), is(notNullValue()));
		assertThat(generatePublicKey("RSA", new X509EncodedKeySpec(decodeBase64(RSA_PUBLIC_KEY))), is(notNullValue()));
		assertThat(generatePrivateKey("RSA", decodeBase64(RSA_PRIVATE_KEY)), is(notNullValue()));
		assertThat(generatePrivateKey("RSA", new PKCS8EncodedKeySpec(decodeBase64(RSA_PRIVATE_KEY))), is(notNullValue()));
		assertThat(generateSecretKey("PBEWithMD5AndDES", new PBEKeySpec("password".toCharArray())), is(notNullValue()));
		assertThat(generateSecretKey("DES"), is(notNullValue()));
		assertThat(generateSecretKey("DES", 56), is(notNullValue()));
	}

	@Test
	public void NONEwithRSAで署名して検証する() throws Throwable {
		署名して検証する("NONEwithRSA", "てすと");
	}

	@Test
	public void MD2withRSAで署名して検証する() throws Throwable {
		署名して検証する("MD2withRSA", "てすと");
	}

	@Test
	public void MD5withRSAで署名して検証する() throws Throwable {
		署名して検証する("MD5withRSA", "てすと");
	}

	@Test
	public void SHA1withRSAで署名して検証する() throws Throwable {
		署名して検証する("SHA1withRSA", "てすと");
	}

	@Test
	public void SHA256withRSAで署名して検証する() throws Throwable {
		署名して検証する("SHA256withRSA", "てすと");
	}

	@Test
	public void SHA384withRSAで署名して検証する() throws Throwable {
		署名して検証する("SHA384withRSA", "てすと");
	}

	@Test
	public void SHA512withRSAで署名して検証する() throws Throwable {
		署名して検証する("SHA512withRSA", "てすと");
	}

	@Test
	public void NONEwithDSAで署名して検証する() throws Throwable {
		署名して検証する("NONEwithDSA", "12345678901234567890"); // データを20バイトにする
	}

	@Test(expected = SignatureException.class)
	public void NONEwithDSAで署名して検証してエラーになる() throws Throwable {
		署名して検証する("NONEwithDSA", "12345678901234567890" + "1"); // データが20バイトでないとエラーになる
	}

	@Test
	public void SHA1withDSAで署名して検証する() throws Throwable {
		署名して検証する("SHA1withDSA", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void NONEwithECDSAで署名して検証する() throws Throwable {
		署名して検証する("NONEwithECDSA", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void SHA1withECDSAで署名して検証する() throws Throwable {
		署名して検証する("SHA1withECDSA", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void SHA256withECDSAで署名して検証する() throws Throwable {
		署名して検証する("SHA256withECDSA", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void SHA384withECDSAで署名して検証する() throws Throwable {
		署名して検証する("SHA384withECDSA", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void SHA512withECDSAで署名して検証する() throws Throwable {
		署名して検証する("SHA512withECDSA", "てすと");
	}

	@Test
	public void AESの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES", "てすと");
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test
	public void AES_CBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/NoPadding", INPUT_X16); // 入力を16バイトの倍数にする
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/NoPadding", INPUT_X16, "初期化ベクトル"); // 入力を16バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void AES_CBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/NoPadding", INPUT_X16 + "1"); // 入力が16バイトの倍数でないとエラーになる
	}

	@Test
	public void AES_CBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void AES_CBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/PKCS1Padding", "てすと");
	}

	@Test
	public void AES_CBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/CBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void AES_CFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/CFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void AES_CFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/CFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void AES_CFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CFB/PKCS1Padding", "てすと");
	}

	@Test
	public void AES_CFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/CFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/CFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void AES_ECB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/ECB/NoPadding", INPUT_X16); // 入力を16バイトの倍数にする
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void AES_ECB_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/ECB/NoPadding", INPUT_X16 + "1"); // 入力が16バイトの倍数でないとエラーになる
	}

	@Test
	public void AES_ECB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/ECB/ISO10126Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void AES_ECB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/ECB/PKCS1Padding", "てすと");
	}

	@Test
	public void AES_ECB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/ECB/PKCS5Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test
	public void AES_OFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/OFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/OFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void AES_OFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/OFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/OFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void AES_OFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/OFB/PKCS1Padding", "てすと");
	}

	@Test
	public void AES_OFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/OFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/OFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void AES_PCBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/NoPadding", INPUT_X16); // 入力を16バイトの倍数にする
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/NoPadding", INPUT_X16, "初期化ベクトル"); // 入力を16バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void AES_PCBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/NoPadding", INPUT_X16 + "1"); // 入力が16バイトの倍数でないとエラーになる
	}

	@Test
	public void AES_PCBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void AES_PCBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/PKCS1Padding", "てすと");
	}

	@Test
	public void AES_PCBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("AES", "AES/PCBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void ARCFOURの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR", "てすと");
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CBC/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CBC/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CBC/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CBC/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CFB/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CFB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CFB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_CFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/CFB/PKCS5Padding", "てすと");
	}

	@Test
	public void ARCFOUR_ECB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/ECB/NoPadding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_ECB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/ECB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_ECB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/ECB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_ECB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/ECB/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_OFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/OFB/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_OFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/OFB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_OFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/OFB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_OFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/OFB/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_PCBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/PCBC/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_PCBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/PCBC/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_PCBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/PCBC/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void ARCFOUR_PCBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("ARCFOUR", "ARCFOUR/PCBC/PKCS5Padding", "てすと");
	}

	@Test
	public void Blowfishの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish", "てすと");
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test
	public void Blowfish_CBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void Blowfish_CBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void Blowfish_CBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void Blowfish_CBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/PKCS1Padding", "てすと");
	}

	@Test
	public void Blowfish_CBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void Blowfish_CFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void Blowfish_CFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void Blowfish_CFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CFB/PKCS1Padding", "てすと");
	}

	@Test
	public void Blowfish_CFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/CFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void Blowfish_ECB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/ECB/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void Blowfish_ECB_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/ECB/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void Blowfish_ECB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/ECB/ISO10126Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void Blowfish_ECB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/ECB/PKCS1Padding", "てすと");
	}

	@Test
	public void Blowfish_ECB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/ECB/PKCS5Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test
	public void Blowfish_OFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/OFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/OFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void Blowfish_OFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/OFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/OFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void Blowfish_OFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/OFB/PKCS1Padding", "てすと");
	}

	@Test
	public void Blowfish_OFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/OFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/OFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void Blowfish_PCBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void Blowfish_PCBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void Blowfish_PCBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void Blowfish_PCBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/PKCS1Padding", "てすと");
	}

	@Test
	public void Blowfish_PCBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("Blowfish", "Blowfish/PCBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DESの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES", "てすと");
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test
	public void DES_CBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void DES_CBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void DES_CBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DES_CBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/PKCS1Padding", "てすと");
	}

	@Test
	public void DES_CBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/CBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DES_CFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/CFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DES_CFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/CFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DES_CFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CFB/PKCS1Padding", "てすと");
	}

	@Test
	public void DES_CFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/CFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/CFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DES_ECB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/ECB/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void DES_ECB_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/ECB/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void DES_ECB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/ECB/ISO10126Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DES_ECB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/ECB/PKCS1Padding", "てすと");
	}

	@Test
	public void DES_ECB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/ECB/PKCS5Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test
	public void DES_OFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/OFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/OFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DES_OFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/OFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/OFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DES_OFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/OFB/PKCS1Padding", "てすと");
	}

	@Test
	public void DES_OFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/OFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/OFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DES_PCBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void DES_PCBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void DES_PCBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DES_PCBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/PKCS1Padding", "てすと");
	}

	@Test
	public void DES_PCBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DES", "DES/PCBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DESedeの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede", "てすと");
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test
	public void DESede_CBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void DESede_CBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void DESede_CBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DESede_CBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/PKCS1Padding", "てすと");
	}

	@Test
	public void DESede_CBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DESede_CFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DESede_CFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DESede_CFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CFB/PKCS1Padding", "てすと");
	}

	@Test
	public void DESede_CFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/CFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DESede_ECB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/ECB/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void DESede_ECB_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/ECB/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void DESede_ECB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/ECB/ISO10126Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DESede_ECB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/ECB/PKCS1Padding", "てすと");
	}

	@Test
	public void DESede_ECB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/ECB/PKCS5Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test
	public void DESede_OFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/OFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/OFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DESede_OFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/OFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/OFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DESede_OFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/OFB/PKCS1Padding", "てすと");
	}

	@Test
	public void DESede_OFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/OFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/OFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void DESede_PCBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void DESede_PCBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void DESede_PCBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void DESede_PCBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/PKCS1Padding", "てすと");
	}

	@Test
	public void DESede_PCBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("DESede", "DESede/PCBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void RC2の共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2", "てすと");
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_CBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void RC2_CBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_CBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC2_CBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/PKCS1Padding", "てすと");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_CBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_CFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_CFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC2_CFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CFB/PKCS1Padding", "てすと");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_CFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/CFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void RC2_ECB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/ECB/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void RC2_ECB_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/ECB/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test
	public void RC2_ECB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/ECB/ISO10126Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC2_ECB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/ECB/PKCS1Padding", "てすと");
	}

	@Test
	public void RC2_ECB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/ECB/PKCS5Padding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_OFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/OFB/NoPadding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/OFB/NoPadding", "てすと", "初期化ベクトル");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_OFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/OFB/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/OFB/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC2_OFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/OFB/PKCS1Padding", "てすと");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_OFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/OFB/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/OFB/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_PCBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/NoPadding", INPUT_X8); // 入力を8バイトの倍数にする
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/NoPadding", INPUT_X8, "初期化ベクトル"); // 入力を8バイトの倍数にする
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void RC2_PCBC_NoPaddingの共通鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/NoPadding", INPUT_X8 + "1"); // 入力が8バイトの倍数でないとエラーになる
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_PCBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/ISO10126Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/ISO10126Padding", "てすと", "初期化ベクトル");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC2_PCBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/PKCS1Padding", "てすと");
	}

	@Test(expected = InvalidKeyException.class)
	@Ignore("Oracle JDK 7でInvalidKeyExceptionになる")
	public void RC2_PCBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/PKCS5Padding", "てすと");
		共通鍵暗号で暗号化して複合する("RC2", "RC2/PCBC/PKCS5Padding", "てすと", "初期化ベクトル");
	}

	@Test
	public void RC4の共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4", "てすと");
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CBC/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CBC/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CBC/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CBC/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CFB/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CFB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CFB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_CFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/CFB/PKCS5Padding", "てすと");
	}

	@Test
	public void RC4_ECB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/ECB/NoPadding", "てすと");
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_ECB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/ECB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_ECB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/ECB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_ECB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/ECB/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_OFB_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/OFB/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_OFB_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/OFB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_OFB_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/OFB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_OFB_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/OFB/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_PCBC_NoPaddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/PCBC/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_PCBC_ISO10126Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/PCBC/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_PCBC_PKCS1Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/PCBC/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RC4_PCBC_PKCS5Paddingの共通鍵暗号で暗号化して複合する() throws Throwable {
		共通鍵暗号で暗号化して複合する("RC4", "RC4/PCBC/PKCS5Padding", "てすと");
	}

	@Test
	public void RSAの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA", "てすと");
		公開鍵暗号で暗号化して複合する("RSA", "RSA", INPUT_117); // 鍵の長さが1024ビット(128バイト)でパディングが11バイトなので、入力は最長で117バイトまで
		// デフォルトがECBで、ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void RSAの公開鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA", INPUT_117 + "1"); // 入力が117バイトを超えるとエラーになる
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CBC_NoPaddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CBC/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CBC_ISO10126Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CBC/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CBC_PKCS1Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CBC/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CBC_PKCS5Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CBC/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CFB_NoPaddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CFB/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CFB_ISO10126Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CFB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CFB_PKCS1Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CFB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_CFB_PKCS5Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/CFB/PKCS5Padding", "てすと");
	}

	@Test
	public void RSA_ECB_NoPaddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/ECB/NoPadding", INPUT_128); // 鍵の長さが1024ビット(128バイト)でパディングなしなので、入力を128バイトにする
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void RSA_ECB_NoPaddingの公開鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/ECB/NoPadding", INPUT_128 + "1"); // 入力が128バイトを超えるとエラーになる
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_ECB_ISO10126Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/ECB/ISO10126Padding", "てすと");
	}

	@Test
	public void RSA_ECB_PKCS1Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/ECB/PKCS1Padding", "てすと");
		公開鍵暗号で暗号化して複合する("RSA", "RSA/ECB/PKCS1Padding", INPUT_117); // 鍵の長さが1024ビット(128バイト)でパディングが11バイトなので、入力は最長で117バイトまで
		// ECBは初期化ベクトルが不要
	}

	@Test(expected = IllegalBlockSizeException.class)
	public void RSA_ECB_PKCS1Paddingの公開鍵暗号で暗号化して複合してエラーになる() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/ECB/PKCS1Padding", INPUT_117 + "1"); // 入力が117バイトを超えるとエラーになる
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_ECB_PKCS5Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/ECB/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_OFB_NoPaddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/OFB/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_OFB_ISO10126Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/OFB/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_OFB_PKCS1Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/OFB/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_OFB_PKCS5Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/OFB/PKCS5Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_PCBC_NoPaddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/PCBC/NoPadding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_PCBC_ISO10126Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/PCBC/ISO10126Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_PCBC_PKCS1Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/PCBC/PKCS1Padding", "てすと");
	}

	@Test(expected = NoSuchAlgorithmException.class)
	public void RSA_PCBC_PKCS5Paddingの公開鍵暗号で暗号化して複合する() throws Throwable {
		公開鍵暗号で暗号化して複合する("RSA", "RSA/PCBC/PKCS5Padding", "てすと");
	}

	@Test
	public void nullになる() {
		assertThat(digestOrNull(null, null), is(nullValue()));
		assertThat(generateKeyPairOrNull(null), is(nullValue()));
		assertThat(generateKeyPairOrNull(null, -1), is(nullValue()));
		assertThat(generatePublicKeyOrNull(null, (byte[]) null), is(nullValue()));
		assertThat(generatePublicKeyOrNull(null, (KeySpec) null), is(nullValue()));
		assertThat(generatePrivateKeyOrNull(null, (byte[]) null), is(nullValue()));
		assertThat(generatePrivateKeyOrNull(null, (KeySpec) null), is(nullValue()));
		assertThat(generateSecretKeyOrNull(null, null), is(nullValue()));
		assertThat(generateSecretKeyOrNull(null), is(nullValue()));
		assertThat(generateSecretKeyOrNull(null, -1), is(nullValue()));
		assertThat(signOrNull(null, null, null), is(nullValue()));
		assertThat(verifyOrNull(null, null, null, null), is(false)); // nullにならない
		assertThat(encryptOrNull(null, null, null), is(nullValue()));
		assertThat(encryptOrNull(null, null, null, null), is(nullValue()));
		assertThat(decryptOrNull(null, null, null), is(nullValue()));
		assertThat(decryptOrNull(null, null, null, null), is(nullValue()));
	}

	private static void 署名して検証する(final String algorithm, final String data) throws Throwable {
		try {
			byKeyPair(algorithm, data);
		} catch (final RuntimeException e) {
			throw e.getCause() != null ? e.getCause() : e;
		}
	}

	private static void 共通鍵暗号で暗号化して複合する(final String algorithm, final String transformation, final String input) throws Throwable {
		try {
			bySecretKey(algorithm, transformation, input);
		} catch (final RuntimeException e) {
			throw e.getCause() != null ? e.getCause() : e;
		}
	}

	private static void 共通鍵暗号で暗号化して複合する(final String algorithm, final String transformation, final String input, final String iv) throws Throwable {
		try {
			bySecretKey(algorithm, transformation, input, iv);
		} catch (final RuntimeException e) {
			throw e.getCause() != null ? e.getCause() : e;
		}
	}

	private static void 公開鍵暗号で暗号化して複合する(final String algorithm, final String transformation, final String input) throws Throwable {
		try {
			byKeyPair(algorithm, transformation, input);
		} catch (final RuntimeException e) {
			throw e.getCause() != null ? e.getCause() : e;
		}
	}

	// 公開鍵暗号で初期化ベクトルが必要なアルゴリズムがないため未使用
	@SuppressWarnings("unused")
	private static void 公開鍵暗号で暗号化して複合する(final String algorithm, final String transformation, final String input, final String iv) throws Throwable {
		try {
			byKeyPair(algorithm, transformation, input, iv);
		} catch (final RuntimeException e) {
			throw e.getCause() != null ? e.getCause() : e;
		}
	}

	private static void byKeyPair(final String algorithm, final String data) {
		final String publicKey = "DSA".equalsIgnoreCase(algorithm.replaceFirst("^.*with", "")) ? DSA_PUBLIC_KEY : RSA_PUBLIC_KEY;
		final String privateKey = "DSA".equalsIgnoreCase(algorithm.replaceFirst("^.*with", "")) ? DSA_PRIVATE_KEY : RSA_PRIVATE_KEY;
		final KeyPair[] keyPairs = new KeyPair[] { generateKeyPair(algorithm.replaceFirst("^.*with", ""), KEYSIZE), new KeyPair(generatePublicKey(algorithm.replaceFirst("^.*with", ""), decodeBase64(publicKey)), generatePrivateKey(algorithm.replaceFirst("^.*with", ""), decodeBase64(privateKey))) };
		assertThat(verify(algorithm, keyPairs[0].getPublic(), getBytes(data), sign(algorithm, keyPairs[0].getPrivate(), getBytes(data))), is(true));
		assertThat(verifyOrNull(algorithm, keyPairs[0].getPublic(), getBytes(data), signOrNull(algorithm, keyPairs[1].getPrivate(), getBytes(data))), is(false));
		assertThat(verifyOrNull(algorithm, keyPairs[1].getPublic(), getBytes(data), signOrNull(algorithm, keyPairs[0].getPrivate(), getBytes(data))), is(false));
		assertThat(verify(algorithm, keyPairs[1].getPublic(), getBytes(data), sign(algorithm, keyPairs[1].getPrivate(), getBytes(data))), is(true));
	}

	private static void bySecretKey(final String algorithm, final String transformation, final String input) throws InvalidKeyException {
		final KeySpec keySpec = "DES".equalsIgnoreCase(algorithm) ? new DESKeySpec(getBytes("12345678")) : "DESede".equalsIgnoreCase(algorithm) ? new DESedeKeySpec(getBytes("123456789012345678901234")) : null;
		final SecretKey[] keys = new SecretKey[] { generateSecretKey(algorithm), keySpec == null ? generateSecretKey(algorithm) : generateSecretKey(algorithm, keySpec) };
		assertThat(getString(decrypt(transformation, keys[0], encrypt(transformation, keys[0], getBytes(input)))), is(input));
		assertThat(getString(decryptOrNull(transformation, keys[0], encryptOrNull(transformation, keys[1], getBytes(input)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[1], encryptOrNull(transformation, keys[0], getBytes(input)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decrypt(transformation, keys[1], encrypt(transformation, keys[1], getBytes(input)))), is(input));
	}

	private static void bySecretKey(final String algorithm, final String transformation, final String input, final String iv) throws InvalidKeyException {
		final KeySpec keySpec = "DES".equalsIgnoreCase(algorithm) ? new DESKeySpec(getBytes("12345678")) : "DESede".equalsIgnoreCase(algorithm) ? new DESedeKeySpec(getBytes("123456789012345678901234")) : null;
		final SecretKey[] keys = new SecretKey[] { generateSecretKey(algorithm), keySpec == null ? generateSecretKey(algorithm) : generateSecretKey(algorithm, keySpec) };
		assertThat(getString(decrypt(transformation, keys[0], encrypt(transformation, keys[0], getBytes(input), getBytes(iv)), getBytes(iv))), is(input));
		assertThat(getString(decryptOrNull(transformation, keys[0], encryptOrNull(transformation, keys[0], getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // IVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[0], encryptOrNull(transformation, keys[0], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // IVを入れ替える
		assertThat(getString(decrypt(transformation, keys[0], encrypt(transformation, keys[0], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), is(input));
		assertThat(getString(decryptOrNull(transformation, keys[0], encryptOrNull(transformation, keys[1], getBytes(input), getBytes(iv)), getBytes(iv))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[0], encryptOrNull(transformation, keys[1], getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[0], encryptOrNull(transformation, keys[1], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[0], encryptOrNull(transformation, keys[1], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[1], encryptOrNull(transformation, keys[0], getBytes(input), getBytes(iv)), getBytes(iv))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[1], encryptOrNull(transformation, keys[0], getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[1], encryptOrNull(transformation, keys[0], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[1], encryptOrNull(transformation, keys[0], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decrypt(transformation, keys[1], encrypt(transformation, keys[1], getBytes(input), getBytes(iv)), getBytes(iv))), is(input));
		assertThat(getString(decryptOrNull(transformation, keys[1], encryptOrNull(transformation, keys[1], getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // IVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keys[1], encryptOrNull(transformation, keys[1], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // IVを入れ替える
		assertThat(getString(decrypt(transformation, keys[1], encrypt(transformation, keys[1], getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), is(input));
	}

	private static void byKeyPair(final String algorithm, final String transformation, final String input) {
		final KeyPair[] keyPairs = new KeyPair[] { generateKeyPair(algorithm, KEYSIZE), new KeyPair(generatePublicKey(algorithm, decodeBase64(RSA_PUBLIC_KEY)), generatePrivateKey(algorithm, decodeBase64(RSA_PRIVATE_KEY))) };
		assertThat(getString(decrypt(transformation, keyPairs[0].getPrivate(), encrypt(transformation, keyPairs[0].getPublic(), getBytes(input)))), is(input));
		assertThat(getString(decryptOrNull(transformation, keyPairs[0].getPrivate(), encryptOrNull(transformation, keyPairs[1].getPublic(), getBytes(input)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[1].getPrivate(), encryptOrNull(transformation, keyPairs[0].getPublic(), getBytes(input)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decrypt(transformation, keyPairs[1].getPrivate(), encrypt(transformation, keyPairs[1].getPublic(), getBytes(input)))), is(input));
	}

	private static void byKeyPair(final String algorithm, final String transformation, final String input, final String iv) {
		final KeyPair[] keyPairs = new KeyPair[] { generateKeyPair(algorithm, KEYSIZE), new KeyPair(generatePublicKey(algorithm, decodeBase64(RSA_PUBLIC_KEY)), generatePrivateKey(algorithm, decodeBase64(RSA_PRIVATE_KEY))) };
		assertThat(getString(decrypt(transformation, keyPairs[0].getPrivate(), encrypt(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(iv)), getBytes(iv))), is(input));
		assertThat(getString(decryptOrNull(transformation, keyPairs[0].getPrivate(), encryptOrNull(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // IVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[0].getPrivate(), encryptOrNull(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // IVを入れ替える
		assertThat(getString(decrypt(transformation, keyPairs[0].getPrivate(), encrypt(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), is(input));
		assertThat(getString(decryptOrNull(transformation, keyPairs[0].getPrivate(), encryptOrNull(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(iv)), getBytes(iv))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[0].getPrivate(), encryptOrNull(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[0].getPrivate(), encryptOrNull(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[0].getPrivate(), encryptOrNull(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[1].getPrivate(), encryptOrNull(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(iv)), getBytes(iv))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[1].getPrivate(), encryptOrNull(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[1].getPrivate(), encryptOrNull(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // 鍵とIVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[1].getPrivate(), encryptOrNull(transformation, keyPairs[0].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), not(is(input))); // 鍵を入れ替える
		assertThat(getString(decrypt(transformation, keyPairs[1].getPrivate(), encrypt(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(iv)), getBytes(iv))), is(input));
		assertThat(getString(decryptOrNull(transformation, keyPairs[1].getPrivate(), encryptOrNull(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(iv)), getBytes(StringUtils.reverse(iv)))), not(is(input))); // IVを入れ替える
		assertThat(getString(decryptOrNull(transformation, keyPairs[1].getPrivate(), encryptOrNull(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(iv))), not(is(input))); // IVを入れ替える
		assertThat(getString(decrypt(transformation, keyPairs[1].getPrivate(), encrypt(transformation, keyPairs[1].getPublic(), getBytes(input), getBytes(StringUtils.reverse(iv))), getBytes(StringUtils.reverse(iv)))), is(input));
	}
}
