/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.listener;

import com.mongodb.MongoClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author ankit
 */
@WebListener
public class mongodbcontextlistener implements ServletContextListener {
 
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MongoClient mongo = (MongoClient) sce.getServletContext()
                            .getAttribute("MONGO_CLIENT");
        mongo.close();
        System.out.println("MongoClient closed successfully");
    }
 
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       // try {
            ServletContext ctx = sce.getServletContext();
            MongoClient mongo;
            try {
                mongo = new MongoClient(ctx.getInitParameter("MONGODB_HOST"), 
                        Integer.parseInt(ctx.getInitParameter("MONGODB_PORT")));
                  sce.getServletContext().setAttribute("MONGO_CLIENT", mongo);
            } catch (java.net.UnknownHostException ex) {
                Logger.getLogger(mongodbcontextlistener.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("MongoClient initialized successfully");
          
     //   }
       // catch (UnknownHostException e) {
         //   throw new RuntimeException("MongoClient init failed");
        //}
    }
 
}
