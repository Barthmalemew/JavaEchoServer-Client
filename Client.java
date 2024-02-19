package Mine;

import java.net.*;
import java.io.*;

public class Client
{
    public static void main(String[] args) {
        try (
            Socket client = new Socket("localhost", 8080);

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            //InputStreamReader bridges bytes to char
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));


            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))
            )
        {
            String input;

            while ((input = stdin.readLine()) != null)
            {
                out.println(input);
                System.out.println("echo: " + in.readLine());
            }
        }
        catch (IOException e)
        {
            System.err.println("Socket connection failed");
        }
    }
}