package Server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    private Socket socket; //Il socket ha il compito di creare una comunicazione tra due programmi in esecuzione nella rete
    private ServerSocket server; //Server ha il compito di mettersi in ascolto nella porta
    private DataInputStream input;  //Per leggere i messaggi che invia il Client
    private int porta;
    
    public Server(int porta) throws IOException
    {
        this.porta = porta;
    }
    
    public void Server()
    {
        try
        {
        server = new ServerSocket(porta);   //Qui Il server verifica se la porta è disponibile altrimenti genere a un eccezzione(per esempio se la Porta è gia in uso)
        System.out.println("Server Avviato");
        
        System.out.println("In Attesa Del Client");
        
        socket = server.accept(); //Qui il server accetta la richiesta del Client di entrare nel Socket
        System.out.println("Client Connesso");
        
        input = new DataInputStream (new BufferedInputStream(socket.getInputStream()));
        
        String inputMessaggio = "";
        
        while(!inputMessaggio.equals("STOP"))
        {
            try
            {
                inputMessaggio = input.readUTF(); //Lettura dei messaggi del CLient e stampa
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
