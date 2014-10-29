package my.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.model.nav.Navigatable;
import my.model.nav.Navigation;

public class Cmd implements Handler {

	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("HEADER", "header.jsp");	
		
		String page=request.getParameter("page");
		
		Navigation nav=Navigation.getNavigation();
		
		if(nav.exists(page)==null)
			page="home.jsp";
		
		request.setAttribute("CONTENT", page);
		
		
		request.setAttribute("FOOTER", "footer.jsp");		
		
		return "index.jsp";
	}

}
