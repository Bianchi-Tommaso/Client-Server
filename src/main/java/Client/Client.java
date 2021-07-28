package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client 
{
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private String ipAddress;
    private int porta;
    
    public Client (String ipAddress, int porta) throws IOException
    {
        this.ipAddress = ipAddress;
        this.porta = porta;
    }
        
    public void Client()
    {       
        try
        {
            socket = new Socket(ipAddress, porta);
            System.out.println("Connesso");
            
            input = new DataInputStream(System.in);
            
            output = new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException e)
        {
            System.out.println("Errore Input");
            System.exit(0);
        }
    
        String inputMessaggio = "";

        while(!inputMessaggio.equals("STOP"))
        {
            try
            {
                inputMessaggio = input.readLine();
                output.writeUTF(inputMessaggio);

            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
        
        try
        {
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException e)
            {
                System.out.println(e);
            }
    }
}
