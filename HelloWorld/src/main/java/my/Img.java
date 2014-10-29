package my;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Img extends TagSupport
{
  private String src;

  public String getSrc() { return src; }
  public void setSrc( String src ) { this.src = src; }

  public int doStartTag() throws JspTagException
  {
    
    try {
        //Get the writer object for output.
        JspWriter out = pageContext.getOut();

        //Perform substr operation on string.
        int pointPos=src.lastIndexOf(".");
        
        String lang=pageContext.getResponse().getLocale().getLanguage();
        
        String file=src.substring(0, pointPos)+"_"+lang+"."+src.substring(pointPos+1);
        
        out.println("<img src=\""+file+"\"/>");

    } catch (IOException e) {
        e.printStackTrace();
    }
    return SKIP_BODY;
  }

}