package by.epam.maven.task4.service.imp;

import org.apache.log4j.Logger;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.editor.imp.Task1;
import by.epam.maven.task4.editor.imp.Task2;
import by.epam.maven.task4.editor.imp.Task3;
import by.epam.maven.task4.editor.imp.Task4;
import by.epam.maven.task4.editor.imp.Task5;
import by.epam.maven.task4.editor.imp.Task6;
import by.epam.maven.task4.editor.imp.Task7;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.service.ServiceEdit;

public class ServiceEditImp implements ServiceEdit {
	
	private static final Logger log = Logger.getLogger(ServiceEditImp.class);
	
	@Override
	public String run(Text text, String str) {
		
		String result = "";
		Task task = selectTask(str);

		if (task == null) {
			result = "Please enter the correct request format!";
		} else {
			result = task.run(text);
		}
		return result;
	}

	public static Task selectTask(String str) {

		Task task = null;

		if (str.equals("1")) {
			task = new Task1();
			log.info("Class Task1 has created");
		} else if (str.equals("2")) {
			task = new Task2();
			log.info("Class Task2 has created");
		} else if (str.equals("3")) {
			task = new Task3();
			log.info("Class Task3 has created");
		} else if (str.equals("4")) {
			task = new Task4();
			log.info("Class Task4 has created");
		} else if (str.equals("5")) {
			task = new Task5();
			log.info("Class Task5 has created");
		} else if (str.equals("6")) {
			task = new Task6();
			log.info("Class Task6 has created");
		} else if(str.equals("7")) {
			task = new Task7();
			log.info("Class Task7 has created");
		}

		return task;
	}
}
