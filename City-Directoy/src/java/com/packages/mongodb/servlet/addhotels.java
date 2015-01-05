/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.servlet;
import com.mongodb.MongoClient;
import com.packages.mongodb.dao.hoteldao;
import com.packages.mongodb.model.hotels;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ankit
 */

@WebServlet("/addhotels")
public class addhotels extends HttpServlet {

  

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
          
         
           String name=request.getParameter("name");
           String email=request.getParameter("email");
           String rating=request.getParameter("rating");
           String budget=request.getParameter("budget");
           String message=request.getParameter("message");
           String address=request.getParameter("address");
           String phone=request.getParameter("phone");
           
            
            
        if ((name == null || name.equals(""))) {
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/hotel.html");
			rd.forward(request, response);
		} else {
			hotels p = new hotels();
			p.setaddress(address);
                        p.setbudget(budget);
                        p.setemail(email);
                        p.setmessage(message);
                        p.setname(name);
                        p.setphone(phone);
                        p.setrating(rating);
                      
                     MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			hoteldao personDAO = new hoteldao(mongo);
			personDAO.createhotel(p);
			
                           response.setContentType("text/html;charset=UTF-8");
                           PrintWriter out1 = response.getWriter();
                           out1.println("<html>");
                           out1.print(" <link rel=\"stylesheet\" href=\"css/layouts/main.css\">\n" +
"    <link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/css?family=Lato:100,300,400\">");
                           out1.println(" <section class=\"row-alt\">\n" +
"      <div class=\"lead container\">\n" +
"\n" +
"        <h1>Data Added Successfully!!!</h1>\n" +
"\n" +
"      </div>\n" +
"    </section>");
                           
                            out1.println("<span style=\"display:inline-block; width: 5;\"></span>");
                     out1.println("    <input class=\"btn btn-default\" type=\"button\" name=\"submit\" value=\"Home\" onclick=\"parent.location='home.html'\">");
                     out1.println("    <input class=\"btn btn-default\" type=\"button\" name=\"submit\" value=\"Add More\" onclick=\"parent.location='hotel.html'\">");
                    out1.println("<br>");
            
                    out1.println("</html>");                       
		
                                   
    
                      
        
     
                }
                
	}

}    
      
      
      
     
        
 
 

