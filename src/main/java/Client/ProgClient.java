package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgClient 
{
    public static void main(String[] args) throws IOException
    {
        String ipAddress = "";
        System.out.println("Inserire Indirizzo IP");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ipAddress = br.readLine();
        Client client = new Client(ipAddress, 5000);
        
        client.Client();
    }
    
}
