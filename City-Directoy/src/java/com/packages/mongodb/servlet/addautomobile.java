/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.servlet;
import com.mongodb.MongoClient;
import com.packages.mongodb.dao.automobilsdao;
import com.packages.mongodb.model.automobile;
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

@WebServlet("/addautomobile")
public class addautomobile extends HttpServlet {

  

        @Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
          
         
           String type=request.getParameter("type");
           String name=request.getParameter("name");
           String brand=request.getParameter("brand");
           String dealer=request.getParameter("dealer");
           String email=request.getParameter("email");
           String address=request.getParameter("address");
           String phone=request.getParameter("phone");
           String comments=request.getParameter("comments");
           
            
            
        if ((name == null || name.equals(""))) {
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/automobile.html");
			rd.forward(request, response);
		} else {
			automobile p = new automobile();
			p.setaddress(address);
                        p.setbrand(brand);
                        p.setcomments(comments);
                        p.setdealer(dealer);
                        p.setemail(email);
                        p.setphone(phone);
                        p.settype(type);
                         p.setname(name);
                      
                      
                     MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			automobilsdao personDAO = new automobilsdao(mongo);
			personDAO.createautomobile(p);
			
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
                     out1.println("    <input class=\"btn btn-default\" type=\"button\" name=\"submit\" value=\"Add More\" onclick=\"parent.location='automobile.html'\">");
                    out1.println("<br>");
            
                    out1.println("</html>");                       
		
                                   
    
                      
        
     
                }
                
	}

}    
      
      
      
     
        
 
 

