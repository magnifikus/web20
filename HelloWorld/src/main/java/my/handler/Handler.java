package my.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	
	public String process(HttpServletRequest request, HttpServletResponse response);
}
