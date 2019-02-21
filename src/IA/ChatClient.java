package IA;

import java.net.*;
import java.io.*;


public class ChatClient {
	private String hostname = "";
	private int port;
	private String userName;
	//private int port;

	public ChatClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void execute() {
		try {
			
			Socket socket = new Socket(hostname, port);
			System.out.println("Connected to the chat server");

			

			new ReadThread(null, socket, this).start();
			new WriteThread(socket, this).start();

		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O Error: " + ex.getMessage());
		}

	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	String getUserName() {
		return this.userName;
	}


	public static void main(String[] args) {

		String hostname = "localhost";
		int port = 2222;
		//Emilys-MacBook-Pro.local
		ChatClient client = new ChatClient(hostname, port);
		client.execute();
	}
}