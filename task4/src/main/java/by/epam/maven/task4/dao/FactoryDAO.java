package by.epam.maven.task4.dao;

import by.epam.maven.task4.dao.imp.ParserDAOImp;

public class FactoryDAO {
	
	private static final FactoryDAO instance = new FactoryDAO();
	
	private final ParserDAO parser = new ParserDAOImp();
	
	private FactoryDAO() {
	}
	
	public static FactoryDAO getInstance() {
		return instance;
	}
	
	public ParserDAO getParserDAO() {
		return parser;
	}
}
