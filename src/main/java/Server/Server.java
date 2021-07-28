package Server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    private Socket socket;
    private ServerSocket server;
    private DataInputStream input;
    private int porta;
    
    public Server(int porta) throws IOException
    {
        this.porta = porta;
    }
    
    public void Server()
    {
        try
        {
        server = new ServerSocket(porta);
        System.out.println("Server Avviato");
        
        System.out.println("In Attesa Del Client");
        
        socket = server.accept();
        System.out.println("Client Connesso");
        
        input = new DataInputStream (new BufferedInputStream(socket.getInputStream()));
        
        String inputMessaggio = "";
        
        while(!inputMessaggio.equals("STOP"))
        {
            try
            {
                inputMessaggio = input.readUTF();
                System.out.println(inputMessaggio);
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
            System.out.println("Chiusura Della Connessione");
        
            socket.close();
            input.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
