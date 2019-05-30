package com.mql.manage.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ManageWebPathListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext application = sce.getServletContext();
		String path = application.getContextPath();
		System.out.println(path);
		application.setAttribute("APP_PATH", path);
	}
}
