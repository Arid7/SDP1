
import java.net.*;
import java.io.*;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.cnn.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
