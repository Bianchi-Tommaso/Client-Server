package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client 
{
    private Socket socket;  //Il socket ha il compito di creare una comunicazione tra due programmi in esecuzione nella rete
    private DataInputStream input;  //input serve per leggere i mesaggi scritti in console
    private DataOutputStream output; //output scrive i messaggi nello Stream e il Server li riceve
    private String ipAddress;   //indirizzo Ip del Server
    private int porta;          //porta del server
    
    public Client (String ipAddress, int porta) throws IOException
    {
        this.ipAddress = ipAddress;
        this.porta = porta;
    }
        
    public void Client()
    {       
        try
        {
            socket = new Socket(ipAddress, porta);  //Il Socket acquisisce i valori controllando se tutto funziona correttamente
            System.out.println("Connesso");
            
            input = new DataInputStream(System.in);
            
            output = new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException e)    //Errore in caso ci sia dell'input sbagliato
        {
            System.out.println("Errore Input");
            System.exit(0);
        }
    
        String inputMessaggio = "";

        while(!inputMessaggio.equals("STOP"))   //Finché l'utente non scrivera "STOP" il Client continua la sua esecuzione.
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
            //Qui Avviene la chiusura della connessione.
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
