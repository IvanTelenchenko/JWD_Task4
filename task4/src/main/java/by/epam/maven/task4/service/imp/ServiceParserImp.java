package by.epam.maven.task4.service.imp;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.epam.maven.task4.dao.FactoryDAO;
import by.epam.maven.task4.dao.ParserDAO;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.service.ServiceParser;

public class ServiceParserImp implements ServiceParser{

	
	@Override
	public Text parser() throws FileNotFoundException, IOException{
		
		FactoryDAO factory = FactoryDAO.getInstance();
		ParserDAO parser = factory.getParserDAO();
		
		Text text = new Text();
		text = parser.parser();
		
		return text;
	}
}
