<%@ page import="my.model.nav.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%! Navigation nav = Navigation.getNavigation(); %>
<% String currentPage =  request.getAttribute("CONTENT").toString(); %>


<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/cmd">Praktikum 1</a>
		</div>
		<div class="collapse navbar-collapse">

			<ul class="nav navbar-nav">
				<% for (Navigatable tab:nav.getChilds()) { %>
					<li <% if (tab.isActive(currentPage)) { %>
      					 class="active"
      				<% } %>>
      							<a href="?page=<%=tab.getPage()%>"><%=tab.getName()%></a>
      						</li>
	   			<% } %>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>
</div>