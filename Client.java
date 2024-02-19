package Mine;

import java.net.*;
import java.io.*;

public class Client
{
    public static void main(String[] args) {
        
        //Try block to connect client socket to localhost and the servers port, this allows it to connect.
        //printwriter takes the output and inputstreamreader takes byte values and bridges them to string
        //for the bufferedreader to read
        try (
            Socket client = new Socket("localhost", 8080);

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            //InputStreamReader bridges bytes to char
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));


            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))
            )
            //takes input from user ASWELL as outputting the echo from the server if there is one.
        {
            String input;

            while ((input = stdin.readLine()) != null)
            {
                out.println(input);
                System.out.println("echo: " + in.readLine());
            }
        }
        //Exception incase the socket connection fails.
        catch (IOException e)
        {
            System.err.println("Socket connection failed");
        }
    }
}
