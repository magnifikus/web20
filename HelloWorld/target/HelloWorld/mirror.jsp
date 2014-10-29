<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%
	java.util.List<String> entries = java.util.Arrays.asList("Home","News","About","Impressum");
%>



<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body style="padding-top: 70px;">
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Praktikum 1</a>
			</div>
			<div class="collapse navbar-collapse">

				<ul class="nav navbar-nav">
					<%
						for (String entry:entries) {
					%>
					<li class="active"><a href="?page=<%=entry.toLowerCase()%>"><%=entry%></a>
					</li>
					<%
						}
					%>
				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">

		<h1>Request Attributes</h1>
		<table border="1">
			<tr>
				<td>Key</td>
				<td colspan=1000>Values</td>
			</tr>
			<c:forEach items="${attributes}" var="entry">
				<tr>
					<td>${entry.key}</td>
					<c:forEach items="${entry.value}" var="val">
						<td>${val}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>




		<h1>Request Parameters</h1>
		<table border="1">
			<tr>
				<td>Key</td>
				<td colspan=1000>Values</td>
			</tr>
			<c:forEach items="${parameters}" var="entry">
				<tr>
					<td>${entry.key}</td>
					<c:forEach items="${entry.value}" var="val">
						<td>req.getCookies()[0].get ${val}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>

		<h1>Kekse</h1>
		<table border="1">
			<tr>
				<td>Key</td>
				<td>Value</td>
				<td>Domain</td>
				<td>maxAge</td>
				<td>path</td>
				<td>secure</td>
				<td>version</td>
			</tr>
			<c:forEach items="${cookies}" var="c">
				<tr>
					<td>${c.name}</td>
					<td>${c.value}</td>
					<td>${c.domain}</td>
					<td>${c.maxAge}</td>
					<td>${c.path}</td>
					<td>${c.secure}</td>
					<td>${c.version}</td>
				</tr>
			</c:forEach>
		</table>


		<h1>Session</h1>
		<table border="1">
			<tr>
				<td>Key</td>
				<td>Value</td>
			</tr>
			<c:forEach items="${session.attributeNames}" var="an">
				<tr>
					<td>${an}</td>
					<td>${session.getAttribute(an)}</td>
				</tr>
			</c:forEach>
		</table>
		<h1>Header</h1>
		<table border="1" id="header">
			<tr>
				<td>Key</td>
				<td>Value</td>
			</tr>
			<c:forEach items="${headers}" var="head">
				<tr>
					<td>${head.key}</td>
					<td>${head.value}</td>
				</tr>
			</c:forEach>
		</table>



	</div>






</body>
<script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-dateFormat/1.0/jquery.dateFormat.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</html>
<script>
	function zeroPad(num, places) {
		var zero = places - num.toString().length + 1;
		return Array(+(zero > 0 && zero)).join("0") + num;
	}

	jQuery(document).ready(
			function() {

				var i =
<%=System.currentTimeMillis()%>
	; // server time
				var browser = $.now() - i; // diff browser
				var x = function() {
					var now = new Date($.now() + browser); // time now on server
					$('#time').text(
							$.format.date(now, "MMM dd yyyy HH:mm:ss") + "."
									+ zeroPad(now % 1000, 3));
					//$('#x').css("width",(now%1000)/10+"%")
					setTimeout(x, 1);
				}
				setTimeout(x, 1);
			});
</script>