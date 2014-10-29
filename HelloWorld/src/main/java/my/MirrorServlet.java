package my;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MirrorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		req.getSession(true).setAttribute("test", "xy");
		
		req.setAttribute("parameters", req.getParameterMap());

		Map<String, String> attri = new TreeMap<String, String>();
		attri.put("LocalAddr", req.getLocalAddr());
		attri.put("LocalName", req.getLocalName());
		attri.put("LocalPort", req.getLocalPort() + "");
		attri.put("Method", req.getMethod());
		attri.put("Protocol", req.getProtocol());
		attri.put("RemoteAddr", req.getRemoteAddr());
		attri.put("RemotHost", req.getRemoteHost());
		attri.put("RemotePort", req.getRemotePort() + "");
		attri.put("RemoteUser", req.getRemoteUser());
		attri.put("Path Info", req.getPathInfo());
		attri.put("Path", req.getRequestURI());

		req.setAttribute("attributes", attri);
		req.setAttribute("cookies",req.getCookies());
		req.setAttribute("session",req.getSession(true));
		
		
		
		Map<String, String> heads = new TreeMap<String, String>();
		Enumeration<String> fu = req.getHeaderNames();
		while (fu.hasMoreElements()) {
			String fu2u = fu.nextElement();
			heads.put(fu2u,req.getHeader(fu2u));
		}
		
			
		req.setAttribute("headers", heads);
		
		
		
		
		
		req.getRequestDispatcher("/mirror.jsp").forward(req, resp);

	}
}
