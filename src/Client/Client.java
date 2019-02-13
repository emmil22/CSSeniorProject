package Client;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	public static void main (String[] args) {
	Socket socket = null;
	int portNumber = 2222;
	try {
	socket = new Socket("localhost", portNumber);	
	}
	catch (IOException ex) {
		System.err.println("Fatal Connection Error!");
		ex.printStackTrace();
	}
	}
}
