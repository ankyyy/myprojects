/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.model;

/**
 *
 * @author ankit
 */
public class hotels {
    
    private String id;
    private String name;
    private String budget;
    private String email;
    private String phone;
    private String address;
    private String message;
    private String rating;
    
     public void setid(String id)
    {
        this.id=id;
        
    }
    public void setname(String name)
    {
        this.name=name;
        
    }
    public void setbudget(String budget)
    {
        this.budget=budget;
        
    }
    public void setemail(String email)
    {
        this.email=email;
        
    }
    public void setphone(String phone)
    {
        this.phone=phone;
        
    }
    public void setaddress(String address)
    {
        this.address=address;
        
    }
    public void setmessage(String message)
    {
        this.message=message;
        
    }
    public void setrating(String rating)
    {
        this.rating=rating;
        
    }
    
       public String getname()
    {
        return name;
        
    }
    public String getbudget()
    {
        return budget;
        
    }
    public String getemail()
    {
        return email;
        
    }
    public String getphone()
    {
        return phone;
        
    }
    public String getaddress()
    {
        return address;
        
    }
    public String getmessage()
    {
        return message;
        
    }
    public String getrating()
    {
        return rating;
        
    }
      public String getid()
    {
        return id;
        
    }
    
    
}
