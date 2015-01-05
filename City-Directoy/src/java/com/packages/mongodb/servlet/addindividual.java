/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.servlet;
import com.mongodb.MongoClient;
import com.packages.mongodb.dao.individualdao;
import com.packages.mongodb.model.individual;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ankit
 */
@MultipartConfig
@WebServlet("/addindividual")
public class addindividual extends HttpServlet {

	
 

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
          
         
           String first_name=request.getParameter("first_name");
           String last_name=request.getParameter("last_name");
           String email=request.getParameter("email");
           String houseno=request.getParameter("houseno");
           String area=request.getParameter("area");
           String city=request.getParameter("city");
           String pincode=request.getParameter("pincode");
           String phone_no=request.getParameter("phone_no");
           
            
            
        if ((first_name == null || first_name.equals(""))
				|| (last_name == null || last_name.equals(""))) {
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/index.html");
			rd.forward(request, response);
		} else {
			individual p = new individual();
			p.setarea(area);
                        p.setcity(city);
                        p.setemail(email);
                        p.setfirst_name(first_name);
                        p.sethouseno(houseno);
                        p.setlast_name(last_name);
                        p.setphone_no(phone_no);
                        p.setpincode(pincode);
                      
                     MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			individualdao personDAO = new individualdao(mongo);
			personDAO.createindividual(p);
			
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
                     out1.println("    <input class=\"btn btn-default\" type=\"button\" name=\"submit\" value=\"Add More\" onclick=\"parent.location='index.html'\">");
                    out1.println("<br>");
            
                    out1.println("</html>");                       
		
                                   
    
                      
        
     
                }
                
	}

}    
      
      
      
     
        
 
 

