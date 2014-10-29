<%@ page import="my.model.nav.*" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/lab4inf.tld"        prefix="lab4" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/cmd">Praktikum 3</a>
		</div>
		<div class="collapse navbar-collapse">

			<ul class="nav navbar-nav">
		
				<c:forEach items="${NAV.childs}" var="tab">
							<li class=${tab.isActive(PATH) ? 'active' : ''}>	 
      							<a href="<c:url value="/${tab.page}"/>"><c:out value="${tab.name}"/></a>
      						</li>
	   			</c:forEach>
	   			<li>
	   				<lab4:img src="http://campingbegur.com/assets/flag.jpg"/>
	   			</li>
			</ul>
			
		</div>
		<!--/.nav-collapse -->
	</div>
</div>

<div class="navbar navbar-inverse navbar-fixed-left" role="navigation">
	<div class="container">
	<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<c:forEach items="${NAV.getSubPages(PATH)}" var="tab">
							<li class=${tab.isActive(PATH) ? 'active' : ''}>	 
      							<a href="<c:url value="/${tab.page}"/>"><c:out value="${tab.name}"/></a>
      						</li>
	   			</c:forEach>
			</ul>
	</div>
		</div>
</div>