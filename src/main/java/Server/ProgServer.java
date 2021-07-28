package Server;

import java.io.IOException;

public class ProgServer 
{

    public static void main(String[] args) throws IOException 
    {
        Server server = new Server(5000);
        
        server.Server();
    }
    
}
