import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAExample {
    private static final String ALGORITHM = "RSA";

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            String originalData = "This is a secret message";

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            String encryptedData = Base64.getEncoder().encodeToString(cipher.doFinal(originalData.getBytes()));
            System.out.println("Encrypted Data: " + encryptedData);

            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            String decryptedData = new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
            System.out.println("Decrypted Data: " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
