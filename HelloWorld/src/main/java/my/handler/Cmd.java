package my.handler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.model.nav.Navigatable;
import my.model.nav.Navigation;

public class Cmd implements Handler {

	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String path = request.getRequestURI();
		if (path.startsWith("/"))
			path = path.substring(1);
		
		String page= path.replaceAll(".cmd", ".jsp");//request.getParameter("page");
		
		
		System.out.println(path);
		
		Navigation nav=Navigation.getNavigation();
		
		request.setAttribute("NAV", nav);
		
		request.setAttribute("HEADER", "header.jsp");	
		
		Locale loc = null;
		if (request.getParameter("lang") != null) {
			loc = new Locale(request.getParameter("lang"));
			request.getSession().setAttribute("LOCALE", loc.getLanguage());
		} else {
			String sloc = (String)request.getSession().getAttribute("LOCALE");
			if (sloc != null)
				loc = new Locale(sloc);
			else 
				loc = request.getLocale();
		}
		response.setLocale(loc);
		
		
		
		if(nav.exists(path)==null)
			page="home.jsp";
		
		request.setAttribute("CONTENT", page);
		request.setAttribute("PATH", path);
		
		request.setAttribute("FOOTER", "footer.jsp");		
		
		return "/index.jsp";
	}

}
