
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <a href="home.jsp">Home</a>
   <h3>Entrer le numero du de a lancer puis cliquer sur le bouton</h3>  
	    <form action="Game" method="POST">
		<label >Numero de de (between 1 and 3):</label> <input type="Integer"  name="num"><br>
		<input type="submit" value="Lancer le de">



	</form>
	
	<%
   
   out.print( request.getAttribute("msg"));
   
   %>
	

</body>
</html>