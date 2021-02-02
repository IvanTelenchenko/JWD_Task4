package by.epam.maven.task4.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.epam.maven.task4.entity.imp.Text;

public interface ParserDAO {
	
	Text parser() throws FileNotFoundException, IOException;

}
