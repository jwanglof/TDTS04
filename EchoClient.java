import java.io.*;
import java.net.*;

public class EchoClient 
{
	public static void main(String[] args) throws IOException
	{
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		String echoAddress = "130.236.187.206";

		try
		{
			echoSocket = new Socket(echoAddress, 7);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		}
		catch (UnknownHostException e)
		{
			System.err.println("Don't know about host: " + echoAddress);
			System.exit(1);
		}
		catch (IOException e)
		{
			System.err.println("Couldn't get I/O for " + "the connection to: " + echoAddress);
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		while ((userInput = stdIn.readLine()) != null)
		{
			out.println(userInput);
			System.out.println("echo: "+ in.readLine());
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}

# http://www.coderanch.com/t/207466/sockets/java/Proxy-Server-Java
# http://stackoverflow.com/questions/860362/write-http-proxy-in-java