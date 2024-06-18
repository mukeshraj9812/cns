
import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;
    import java.util.Scanner;

public class MD5 {
    

    
        public static String getMD5Hash(String input) {
            try {
                // Create a MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
    
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
            System.out.println("Enter text to compute MD5 hash:");
            String input = scanner.nextLine();
            scanner.close();
    
            String hash = getMD5Hash(input);
            System.out.println("MD5 Hash: " + hash);
        }
    }
    
    

