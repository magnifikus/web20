package my;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.handler.Handler;

public class ControllerServlet extends HttpServlet {
	private Handler handler;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String handlerStr = config.getInitParameter("handler");
		if (handlerStr == null)
			throw new ServletException("no Handler defined");
		try {
			
			Class handlerClass = Class.forName(handlerStr);
			handler = (Handler) handlerClass.newInstance();
			
		} catch (ClassNotFoundException e) {
			throw new ServletException("Handler not found",e);
		} catch (InstantiationException e) {
			throw new ServletException("Illegal Handler",e);
		} catch (IllegalAccessException e) {
			throw new ServletException("Illegal Handler",e);
		} 
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String nextpage = handler.process(request, response);
		if (nextpage != null)
			request.getRequestDispatcher(nextpage).include(request, response);
	}
}
