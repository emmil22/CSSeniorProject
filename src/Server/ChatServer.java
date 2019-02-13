package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	private static ServerSocket serverSocket = null;
	private static int portNumber = 2222;
	
	public static void main(String[] args) {
		
		
		try {
			serverSocket = new ServerSocket(portNumber);	
		}
		catch(IOException ex) {
			System.err.println("Could not listen on port: " + portNumber);
			System.exit(1);
		}
		
		
	}
	
	public static void acceptClients() {
		while(true) {
			try{
				Socket socket = serverSocket.accept();
			}
			
			catch (IOException ex) {
				System.out.println("Accept failed on: " + portNumber);
			}
		}
		
	}
	
}
