package by.epam.maven.task4.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.epam.maven.task4.entity.imp.Text;

public interface ServiceParser {
	
	Text parser() throws FileNotFoundException, IOException;
}
