<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="padding-top:70px;">
<jsp:include page="<%= request.getAttribute("HEADER").toString() %>" />
<jsp:include page="<%= request.getAttribute("CONTENT").toString() %>" />
<jsp:include page="<%= request.getAttribute("FOOTER").toString() %>" />
 </body>
 </html>