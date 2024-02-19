package Mine;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {

        //try block that creates a server socket object, and a socket object for recieving the client.
        //PrintWriter gets the output from the client socket while an object inputstreamreader reads the data, 
        //then sends it to a bufferreader object.
        try(
            ServerSocket server = new ServerSocket(8080);

            Socket client = server.accept();

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            //InputStreamReader reads bytes to char
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
            )
            //takes the input to be returned to the client
        {
            String input;

            while ((input = in.readLine()) != null)
            {
                out.println(input);
            }

        }
        //exception in the case our try statement to connect sockets fails.
        catch (IOException e)
        {
            System.err.println("Server socket failed to start");
        }
    }

}
