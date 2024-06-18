
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class sha512 {

    public static String getSHA512Digest(String input) {
        try {
            // Create a MessageDigest instance for SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // Compute the digest
            byte[] digestBytes = md.digest(input.getBytes());

            // Convert the byte array into a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : digestBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to compute SHA-512 digest:");
        String input = scanner.nextLine();
        scanner.close();

        String digest = getSHA512Digest(input);
        System.out.println("SHA-512 Digest: " + digest);
    }
}



    

