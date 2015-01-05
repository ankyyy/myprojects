/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.servlet;
import com.packages.mongodb.model.individual;

import com.mongodb.MongoClient;
import com.packages.mongodb.dao.automobilsdao;
import com.packages.mongodb.model.automobile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ankit
 */
@WebServlet("/searchautomobile")
public class searchautomobile extends HttpServlet {

	private static final long serialVersionUID = -7060758261496829905L;
   

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
                
		  
			automobile p = new automobile();
                         p.settype(type);
                          
                        MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			automobilsdao personDAO = new automobilsdao(mongo);
			List<automobile> persons = personDAO.readAllautomobile();
                    
                       

                          response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
             out.println(" <body background=\"back2.jpg\">");
           
            out.println("<link rel=\"stylesheet\" href=\"css/layouts/hbutton.css\">\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"	<meta charset=\"utf-8\" />\n" +
"	<title>Data</title>\n" +
"	<meta name=\"viewport\" content=\"initial-scale=1.0; maximum-scale=1.0; width=device-width;\">\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<div class=\"table-title\">\n" +
"<h3>Data Table</h3>\n" +
"</div>\n" +
"<table class=\"table-fill\">\n" +
"<thead>\n" +
"<tr>\n" +
"<th class=\"text-left\">Type</th>\n" +
"<th class=\"text-left\">Name</th>\n" +
"<th class=\"text-left\">Brand</th>\n" +
"<th class=\"text-left\">Dealer</th>\n" +

"<th class=\"text-left\">Email</th>\n" +
"<th class=\"text-left\">Phone</th>\n" +
"<th class=\"text-left\">Address</th>\n" +
"\n" +
                    

"\n" +
"</tr>\n" +
"</thead>\n" +
"<tbody class=\"table-hover\">") ;
            
              for (automobile p2 : persons) {
                   if(p2.gettype().equals(p.gettype()))
                        { 
            out.println("<tr>\n" +
"<td class=\"text-left\">"+
                   p2.gettype()
                    + "</td>\n" +
"<td class=\"text-left\">"+
                    p2.getname()+
                    "</td>\n" +
          "<td class=\"text-left\">"+
                    p2.getbrand()+
                    "</td>\n" +
                    "<td class=\"text-left\">"+
                 p2.getdealer()+
                    "</td>\n" +
                    "<td class=\"text-left\">"+
         "<a href='email.html' >"+         
                    
                    p2.getemail()+
                    " </a></td>\n" +
"<td class=\"text-left\">"+
                    p2.getphone()+
                    "</td>\n" +
          
"<td class=\"text-left\">"+
                  p2.getaddress()+
                    "</td>\n" 

 );
                  out.println("</tr>");
              
              }
             }
                     
		out.println("</tbody>\n" +
"</table>\n" +
"  \n" +
"\n" +
"  </body>");
		}
	}

}

