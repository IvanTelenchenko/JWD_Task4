package by.epam.maven.task4.service;

import by.epam.maven.task4.service.imp.ServiceEditImp;
import by.epam.maven.task4.service.imp.ServiceParserImp;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final ServiceParser parserService = new ServiceParserImp();
	
	private final ServiceEdit serviceEdit = new ServiceEditImp();
	
	private ServiceFactory() {
	}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public ServiceParser getParserSevice() {
		return parserService;
	}
	
	public ServiceEdit getEditService() {
		return serviceEdit;
	}
}
