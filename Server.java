package Mine;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {

        try(
            ServerSocket server = new ServerSocket(8080);

            Socket client = server.accept();

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            //InputStreamReader reads bytes to char
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
            )
        {
            String input;

            while ((input = in.readLine()) != null)
            {
                out.println(input);
            }

        }
        catch (IOException e)
        {
            System.err.println("Server socket failed to start");
        }
    }

}
