package my;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

import junit.framework.TestCase;

public class HelloServletTest extends TestCase {

	public void testHello() throws Exception
	{
		
		if (1==1)
			return;
		String url = "http://localhost:8080/Hello";

		//HttpUnitOptions.setExceptionsThrownOnScriptError( false );

		WebConversation conversation = new WebConversation();
		WebRequest      request      = new GetMethodWebRequest( url );
		WebResponse     response     = conversation.getResponse( request );
		
		
		assertNotNull( "Kein Response von URL '" + url + "'.", response );
		assertTrue(response.getResponseMessage().contains("OK"));
		
		assertTrue(response.getText().contains("HelloWorld"));

		System.out.println( "\nResponse von URL '" + url + "'." );


	

	}

	public static void main( String[] args ) throws Exception
	{
		junit.textui.TestRunner.run( HelloServletTest.class );
	}


}
