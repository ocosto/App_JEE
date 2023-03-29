package pack2;

import jakarta.servlet.http.HttpServlet;
 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Dictionary;
import java.util.HashMap;

import pack1.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Game")
public class Game extends HttpServlet {
	
	Map<Integer, Integer> dic = new HashMap<>(); 
	private List<Integer> res = new ArrayList<Integer>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("connecteduser");
		
		StringBuffer sb = new StringBuffer();
		
		
        if (user != null) {
			
			 ServletContext cntx = getServletContext();
			 PrintWriter out = response.getWriter();
			 int nbrLancees = 0;
			 int score=0;
			
			
		
			 // Récupérer le numéro de dé à lancer depuis la page JSP
			 int rollNum = Integer.parseInt(request.getParameter("num"));
	
			 
			 if (nbrLancees < 4) {
				 
				 
				// Lancer le dé et ajouter le numéro à la liste des dés lancés
			      Random rd = new Random();
			      int rollResult = 1 + rd.nextInt(6);
			      if (rollNum!=1 && rollNum!=2 && rollNum!=3) {
			    	   sb.append("Ces dés sont numérotés 1, 2 et 3.");}
			   
			   
			      // Vérifier si le dé a déjà été lancé
			     else if (!(dic.containsKey(rollNum))) {
				       
			
			    	   dic.put(rollNum, rollResult);
			           
			           sb.append("resultat=" + rollResult);
			    	   
		        	  
		        	   }
			   
			      else {
			    	   sb.append(" | Votre score est de " +(score=-1));
		        	   request.setAttribute("msg", sb.toString());
		        	   request.setAttribute("score", -1);
		        	   request.setAttribute("BestScore", user.getBestScore());
		        	   request.getRequestDispatcher("Result.jsp").forward(request, response);
		        	   
		        	   //rolls.clear();
		        	   dic.clear();
		        	   nbrLancees=0;}
			       }
			if (dic.size() == 2) {
				if (dic.containsKey(1) && dic.containsKey(2)) {
		           int roll1 = dic.get(1);
		           int roll2 = dic.get(2);
                 
		           if (roll1 < roll2 && roll2==6) {
		        	    sb.append(" | Votre score est de " +(score=0));
		        	    request.setAttribute("msg", sb.toString());
		        	    request.setAttribute("BestScore", user.getBestScore());
		        	    //rolls.clear();
		        	    dic.clear();
		        	    nbrLancees=0;
		        	    request.getRequestDispatcher("Result.jsp").forward(request, response);
		        	    }
		        	  
		           else if (roll1 > roll2 && roll2==1) {
		        	    sb.append(" | Votre score est de " +(score=0));
		        	    request.setAttribute("msg", sb.toString());
		        	    request.setAttribute("BestScore", user.getBestScore());
		        	    //rolls.clear();
		        	    dic.clear();
		        	    nbrLancees=0;
		        	    request.getRequestDispatcher("Result.jsp").forward(request, response);   }
		           }
				}
		        	 
		      
		      if (dic.size() == 3) {
		    	      int roll1 = dic.get(1);
		              int roll2 = dic.get(2);
			          int roll3 = dic.get(3);
			          //rolls.clear();// vider la liste pour le prochain tour
                      dic.clear();
                     
			          if (roll1 < roll2 && roll2 < roll3){
			                 score = roll1 + roll2 + roll3;} 
			          else if (roll1 > roll2 && roll2 > roll3) {
			                 score = roll1 * roll2 * roll3; }
			          
			          sb.append(" | Votre score est de " +score);  
				      s.setAttribute("score", score);
				      
		
				      int totalScore = (Integer) s.getAttribute("score");
				      if (totalScore > user.getBestScore()) {
					       user.setBestScore(totalScore);}
				      
				      request.setAttribute("msg", sb.toString());
					  request.setAttribute("BestScore", user.getBestScore());
					  
				      request.getRequestDispatcher("Result.jsp").forward(request, response);
			          }

			   s.setAttribute("nbrLancees", nbrLancees + 1);
			   request.setAttribute("msg", sb.toString());
			   //request.setAttribute("BestScore", user.getBestScore());
		
			   request.getRequestDispatcher("lancement.jsp").forward(request, response);
			   return;
			     
		
			    // request.getRequestDispatcher("Result.jsp").forward(request, response);
		         
			 
		}else {

			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;

				}}
		
		
} 
		
