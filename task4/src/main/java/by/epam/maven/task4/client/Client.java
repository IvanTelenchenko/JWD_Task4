package by.epam.maven.task4.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class Client {
	
	private static Socket clientSocket;
	private static BufferedReader consoleReader;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	
	private static final Logger log = Logger.getLogger(Client.class);
	
	public static void main(String args[]) throws UnknownHostException, IOException {

		try { 
			
			clientSocket = new Socket("127.0.0.1", 8000);
			consoleReader = new BufferedReader(new InputStreamReader(System.in));
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());

			log.info("Streams have been created");
			log.info("Client has connected");
			
			while (true) {

				String buf;
				buf = in.readUTF();
				System.out.println(buf);
				
				log.info("Message has got");
				
				String request = consoleReader.readLine();
				out.writeUTF(request);
				out.flush();
				
				log.info("Request \"" + request + "\" has sent to server");
				
				if(request.equalsIgnoreCase("exit")) {
				log.info("Client has left to the server");
					break;
				}
				buf = in.readUTF();
				System.out.println(buf);
				log.info("Response was gotten");
			}
		} finally {
			clientSocket.close();
			consoleReader.close();
			in.close();
			out.close();
			
			log.info("Client has disabled \n All streams have closed");
		}
	}
}