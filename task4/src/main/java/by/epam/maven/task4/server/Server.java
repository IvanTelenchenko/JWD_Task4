package by.epam.maven.task4.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import by.epam.maven.task4.service.ServiceEdit;
import by.epam.maven.task4.service.ServiceFactory;
import by.epam.maven.task4.service.ServiceParser;

public class Server {

	private static ServerSocket serverSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static Socket clientSocket;
	private static final Logger log = Logger.getLogger(Server.class);

	public static void main(String args[]) throws IOException {

		serverSocket = new ServerSocket(8000);
		boolean isTrue = true;

		log.info("Server socket has been created");

		try {

			log.info("Server is waiting a client");

			clientSocket = serverSocket.accept();
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());

			log.info("Client has just connected");

			while (isTrue) {

				welcomeMessage(out);

				log.info("Welcome message has been sent");

				String response = in.readUTF();
				log.info("Request has got");

				if (response.equalsIgnoreCase("exit")) {
					log.info("Client has disconnected");
					isTrue = false;
				} else {
					out.writeUTF(sendResponse(response));
					out.flush();
					log.info("Response has sent");
				}
			}

		} finally {
			clientSocket.close();
			serverSocket.close();
			in.close();
			out.close();
			log.info("Server has closed \n All streams has closed");
		}
	}

	public static void welcomeMessage(ObjectOutputStream outStream) throws IOException {

		StringBuilder buffer = new StringBuilder()
				.append("1. Найти наибольшее количество предложений текста, в которых есть одинаковые слова.\n")
				.append("2. Вывести все предложения заданного текста в порядке возрастания\r\n"
						+ "количества слов в каждом из них.\n")
				.append("3. Найти такое слово(слова) в первом предложении, которого нет ни в одном из остальных\r\n"
						+ "предложений.\n")
				.append("4. В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.\r\n")
				.append("5. Напечатать слова текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.\r\n")
				.append("6. Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.\r\n")
				.append("7. Рассортировать слова текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове).\r\n")
				.append(">  exit  < - to exit.");

		outStream.writeUTF(buffer.toString());
		outStream.flush();
	}

	public static String sendResponse(String str) {

		String result = "";

		ServiceFactory servFactory = ServiceFactory.getInstance();
		ServiceParser parser = servFactory.getParserSevice();
		ServiceEdit edit = servFactory.getEditService();

		try {
			result = edit.run(parser.parser(), str);
			log.info("Method run has done");
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}

		return result + "\n";
	}
}