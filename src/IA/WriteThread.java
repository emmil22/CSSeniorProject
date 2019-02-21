package IA;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WriteThread extends Thread {
	private PrintWriter writer;
	private Socket socket;
	private ChatClient client;
	Scanner input = new Scanner(System.in);
	
	public WriteThread(Socket socket, ChatClient client) {
		this.socket = socket;
		this.client = client;
		
		try {
			OutputStream output = socket.getOutputStream();
			writer = new PrintWriter(output, true);
		} catch (IOException ex) {
			System.out.println("Error getting output stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void sendMessage(String s) {
		writer.println(s);
	}
	
	public void run() {
		
		// Console console = System.console();
		System.out.print("Enter your name: ");
		String userName = input.nextLine();
		// String userName = console.readLine("\nEnter your name: ");
		client.setUserName(userName);
		writer.println(userName);
		
		String text;
		
		do {
//			System.out.print("\n" + "[" + userName + "]:");
			text = input.nextLine();
			// text = console.readLine("[" + userName + "]: ");
			writer.println("[" + userName + "]:" + text);
			
		} while (!text.equals("log out"));
		
		try {
			socket.close();
		} catch (IOException ex) {
			
			System.out.println("Error writing to server: " + ex.getMessage());
		}
	}
}