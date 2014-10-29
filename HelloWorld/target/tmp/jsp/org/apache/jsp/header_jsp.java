package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import my.model.nav.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 Navigation nav = Navigation.getNavigation(); 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
 String currentPage =  request.getAttribute("CONTENT").toString(); 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\n");
      out.write("\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\n");
      out.write("\t\t\t\t\tclass=\"icon-bar\"></span>\n");
      out.write("\t\t\t</button>\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"/cmd\">Praktikum 1</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\">\n");
      out.write("\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t");
 for (Navigatable tab:nav.getChilds()) { 
      out.write("\n");
      out.write("\t\t\t\t\t<li ");
 if (tab.isActive(currentPage)) { 
      out.write("\n");
      out.write("      \t\t\t\t\t class=\"active\"\n");
      out.write("      \t\t\t\t");
 } 
      out.write(">\n");
      out.write("      \t\t\t\t\t\t\t<a href=\"?page=");
      out.print(tab.getPage());
      out.write('"');
      out.write('>');
      out.print(tab.getName());
      out.write("</a>\n");
      out.write("      \t\t\t\t\t\t</li>\n");
      out.write("\t   \t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t</ul>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--/.nav-collapse -->\n");
      out.write("\t</div>\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
