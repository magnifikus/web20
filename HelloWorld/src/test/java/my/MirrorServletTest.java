package my;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.TableRow;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

import junit.framework.TestCase;

public class MirrorServletTest extends TestCase {
	private String url = "http://localhost:8080/mirror/";
	
	
	
	public void testUserAgent() throws Exception
	{
		if (1==1)
			return;
		String testAgent = "Hello This is HttpUNIT";
		WebConversation conversation = new WebConversation();
		conversation.setUserAgent(testAgent);
		
		WebRequest      request      = new GetMethodWebRequest( url );
		WebResponse     response     = conversation.getResponse( request );
		assertNotNull( "Kein Response von URL '" + url + "'.", response );
		assertTrue(response.getResponseMessage().contains("OK"));
		
		WebTable headtable = response.getTableWithID("header");
		
		boolean found = false;
		for (int i =0; i < headtable.getRowCount(); i++) {
			String key = headtable.getCellAsText(i, 0); 
			if (key.equals("User-Agent")) {
				String value = headtable.getCellAsText(i, 1); 
				assertEquals(testAgent, value);
				found = true;
			}
			
		}
		assertTrue(found);
	}
	
	

	public static void main( String[] args ) throws Exception
	{
		junit.textui.TestRunner.run( MirrorServletTest.class );
	}


}
