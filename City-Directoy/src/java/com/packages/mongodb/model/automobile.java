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
public class automobile {
    
    private String type;
    private String name;
    private String brand;
    private String dealer;
    private String phone;
    private String address;
    private String email;
    private String comments;
    private String id;
    
    public void setid(String id)
    {
        this.id=id;
    }
   
    public void settype(String type)
    {
        this.type=type;
    }
    
    public void setname(String name)
    {
        this.name=name;
    }
    public void setbrand(String brand)
    {
        this.brand=brand;
    }
    public void setdealer(String dealer)
    {
        this.dealer=dealer;
    }
    public void setphone(String phone)
    {
        this.phone=phone;
    }
    public void setaddress(String address)
    {
        this.address=address;
    }
    public void setemail(String email)
    {
        this.email=email;
    }
    public void setcomments(String comments)
    {
        this.comments=comments;
    }
    
    public String gettype()
    {
        return type;
    }
    
    public String getname()
    {
        return name;
    }
    public String getbrand()
    {
        return brand;
    }
    public String getdealer()
    {
        return dealer;
    }
    public String getphone()
    {
        return phone;
    }
    public String getaddress()
    {
        return address;
    }
    public String getemail()
    {
        return email;
    }
    public String getcomments()
    {
        return comments;
    }
    
    public String getid()
    {
        return id;
    }
      
            
}
