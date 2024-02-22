import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args)
	{
		final int PORT = 8080; // Note: port 8080 may be in use on your device
		try
		{
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("Server is ready to receive.");
			Socket client = server.accept();
			System.out.println("Client connected.");
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);	
			String msg = in.readLine();
			do
			{
				System.out.println("Message from client: " + msg);	
				out.println(msg);
			} while((msg = in.readLine()) != null && !msg.equalsIgnoreCase("Exit"));
			in.close();
			out.close();
			client.close();
			server.close();
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
	}
}