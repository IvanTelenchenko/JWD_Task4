package by.epam.maven.task4.dao.imp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import by.epam.maven.task4.dao.ParserDAO;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.parser.Parser;

public class ParserDAOImp implements ParserDAO{
	
	private File file = new File("2.txt");
	
	@Override
	public Text parser() throws FileNotFoundException, IOException {
				
		Parser parser = new Parser();
		
		Text text = new Text();
		text = parser.parser(file);
		
		return text;
	}
}
