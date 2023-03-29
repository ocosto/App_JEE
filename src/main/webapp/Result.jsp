
<%@page import="pack1.User"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
<a href="home.jsp" >home</a>

<h1>Partie Termine!</h1>


    <%if ( request.getAttribute("score") != null && (int) request.getAttribute("score") == -1) {%>
         <h1>Erreur : ce de a deja ete lance</h1> <p>  votre score est de -1 | votre meilleur score : <%= request.getAttribute("BestScore") %> |</p>
        
    <%} else {%>
         <p>| <%= request.getAttribute("msg") %> | votre meilleur score : <%= request.getAttribute("BestScore") %> |</p>
        
    <%} %>


</body>
</html>