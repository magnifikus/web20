<%@page import="java.util.ArrayList"%>


<%  
java.util.List<String> entries = java.util.Arrays.asList("Home","News","About","Impressum");
%>



<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body style="padding-top:70px;">
 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">Praktikum 1</a>
        </div>
        <div class="collapse navbar-collapse">
        
          <ul class="nav navbar-nav">
			<% for (String entry:entries) { %>
				<li class="active">
					<a href="?page=<%=entry.toLowerCase()%>"><%=entry%></a>
				</li>
			<% } %>
		  </ul>
		  
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
      <div class="starter-template">
        <h1>Praktikum 1</h1>
        <p class="lead" id="time"><%=new java.util.Date() %></p>
        <% my.abc a=new my.abc(request.getParameter("page"),"llo");
        %>
        <%= a.test() %>
      </div>
      <form method="POST" action="?">
      <input name="test" value="geheim" />
      <button type="submit">OK</button>
      </form>
		
		
		
	  <!-- <div class="progress">
  		<div class="progress-bar progress-bar-success" id="x" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
    		<span class="sr-only">40% Complete (success)</span>
  		</div>
		</div>	 -->
		
		
		<a href="/Hello">HelloServlet</a>
	
    </div>


	



</body>
<script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-dateFormat/1.0/jquery.dateFormat.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</html>
<script>


function zeroPad(num, places) {
	  var zero = places - num.toString().length + 1;
	  return Array(+(zero > 0 && zero)).join("0") + num;
	}
	
jQuery(document).ready(function () {

	var i = <%=System.currentTimeMillis() %>; // server time
	var browser = $.now()-i; // diff browser
	var x = function() {
		var now = new Date($.now()+browser); // time now on server
		$('#time').text($.format.date(now,"MMM dd yyyy HH:mm:ss") +"."+zeroPad(now % 1000,3) );
		//$('#x').css("width",(now%1000)/10+"%")
		setTimeout(x,1);
	}
	setTimeout(x,1);
});

</script>