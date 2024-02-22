import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException {
		final String SERVERADDR = "localhost";
		final int PORT = 8080; // Note: port 8080 may be in use on your device
		try
		{
			Socket server = new Socket(SERVERADDR, PORT);
			PrintWriter out = new PrintWriter(server.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter message: ");
			String clientMsg;
			while((clientMsg = input.readLine()) != null && !clientMsg.equalsIgnoreCase("Exit"))
			{
				out.println(clientMsg);
				String msg = in.readLine();
				System.out.println("Message from server: " + msg);
				System.out.println("Type 'Exit' to close the client.");
				System.out.print("Enter message: ");
			}
			out.close();
			in.close();
			input.close();
			server.close();
		}
		catch(UnknownHostException e)
		{
			System.err.println(e.getMessage());
		}
    }
}