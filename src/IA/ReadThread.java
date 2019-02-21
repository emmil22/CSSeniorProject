package IA;

import java.io.*;
import java.net.*;

import javax.swing.JTextArea;

/**
 * This thread is responsible for reading server's input and printing it
 * to the console.
 * It runs in an infinite loop until the client disconnects from the server.
 *
 */
public class ReadThread extends Thread {
	private BufferedReader reader;
	private ChatClient client;
	private JTextArea tx;

	public ReadThread(JTextArea tx, Socket socket, ChatClient client) {
		this.client = client;
		this.tx = tx;
		try {
			InputStream input = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input));
		} catch (IOException ex) {
			System.out.println("Error getting input stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				String response = reader.readLine();
				System.out.println(response);
				tx.append(response + "\n");

				// prints the username after displaying the server's message
			} catch (IOException ex) {
				System.out.println("Error reading from server: " + ex.getMessage());
				ex.printStackTrace();
				break;
			}
		}
	}
}