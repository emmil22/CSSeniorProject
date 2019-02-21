package IA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class UserThread extends Thread {
	private Socket socket;
	private ChatServer server;
	private PrintWriter writer;
	private String userName;

	public UserThread(Socket socket, ChatServer server) {
		this.socket = socket;
		this.server = server;
	}

	public void run() {
		try {
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			OutputStream output = socket.getOutputStream();
			writer = new PrintWriter(output, true);

			writer.println("Enter your username:");
			
			userName = reader.readLine();
			server.addUserName(userName);

			server.showMessage("New user connected: " + userName, this);

			printUsers();

			String clientMessage;

			do {
				clientMessage = reader.readLine();
				server.showMessage("[" + userName + "]:" + clientMessage, this);

			} while (!clientMessage.equals("bye"));

			server.removeUser(userName, this);
			socket.close();

			server.showMessage(userName + " has quit.", this);

		} catch (IOException ex) {
			System.out.println("Error in UserThread: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	
	  //Sends a list of online users to the newly connected user.
	 
	void printUsers() {
		if (server.hasUsers()) {
			writer.println("Connected users: " + server.getUserNames());
		} else {
			writer.println("No other users connected");
		}
	}

	
	 // Sends a message to the client.
	 
	void sendMessage(String message) {
		writer.println(message);
	}
}