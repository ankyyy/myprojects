/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.servlet;
import com.packages.mongodb.dao.individualdao;
import com.packages.mongodb.model.individual;

import com.mongodb.MongoClient;
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
@WebServlet("/searchindividual")
public class searchindividual extends HttpServlet {

	private static final long serialVersionUID = -7060758261496829905L;
   

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
	/*	String last_name = request.getParameter("last_name");
                String email = request.getParameter("email");
                String houseno = request.getParameter("houseno");
                String area = request.getParameter("area");
                String city = request.getParameter("city");
                String phone_no = request.getParameter("phone_no");
                String pincode = request.getParameter("pincode");
               
               
          */    
		  
			individual p = new individual();
	/*		p.setarea(area);
                        p.setcity(city);
                        p.setemail(email);
                        p.setfirst_name(first_name);
                        p.sethouseno(houseno);
                        p.setlast_name(last_name);
                        p.setphone_no(phone_no);
                        p.setpincode(pincode);
          */            p.setfirst_name(first_name);
                          
                        MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			individualdao personDAO = new individualdao(mongo);
			List<individual> persons = personDAO.readAllindividual();
                    
                       

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
"<th class=\"text-left\">First Name</th>\n" +
"<th class=\"text-left\">Last Name</th>\n" +
"<th class=\"text-left\">Email</th>\n" +
"<th class=\"text-left\">Phone</th>\n" +
"<th class=\"text-left\">Houseno</th>\n" +
"<th class=\"text-left\">Area</th>\n" +
"\n" +
"<th class=\"text-left\">City</th>\n" +
"<th class=\"text-left\">Pincode</th>\n" +
                    

"\n" +
"</tr>\n" +
"</thead>\n" +
"<tbody class=\"table-hover\">") ;
            
              for (individual p2 : persons) {
                   if(p2.getfirst_name().equals(p.getfirst_name()))
                        { 
            out.println("<tr>\n" +
"<td class=\"text-left\">"+
                   p2.getfirst_name()
                    + "</td>\n" +
"<td class=\"text-left\">"+
                    p2.getlast_name()+
                    "</td>\n" +
"<td class=\"text-left\">"+
         "<a href='email.html' >"+         
                    
                    p2.getemail()+
                    " </a></td>\n" +
"<td class=\"text-left\">"+
                    p2.getphone_no()+
                    "</td>\n" +
                    "<td class=\"text-left\">"+
                    p2.gethouseno()+
                    "</td>\n" +
"<td class=\"text-left\">"+
                  p2.getarea()+
                    "</td>\n" +
"<td class=\"text-left\">"+
                 p2.getcity()+
                    "</td>\n" +
"<td class=\"text-left\">"+
                 p2.getpincode()+
                    "</td>\n" );
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

