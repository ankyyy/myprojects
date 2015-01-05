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
public class individual {
    private String image;
    private String id;
    private String first_name;
    private String last_name;
    private String phone_no;
    private String email;
    private String pincode;
    private String houseno;
    private String area;
    private String city;
    
   public void setimage(String image)
   {
       this.image=image;
   }
    public void setid(String id)
    {
        this.id=id;
    }
    public void setcity(String city)
    {
        this.city=city;
    }
    
    public void setarea(String area)
    {
        this.area=area;
    }
     
     public void sethouseno(String houseno)
    {
        this.houseno=houseno;
    }
      public void setpincode(String pincode)
    {
        this.pincode=pincode;
    }
       public void setemail(String email)
    {
        this.email=email;
    }
        public void setphone_no(String phone_no)
    {
        this.phone_no=phone_no;
    }
         public void setlast_name(String last_name)
    {
        this.last_name=last_name;
    }
         public void setfirst_name(String first_name)
    {
        this.first_name=first_name;
    }
    public String getphone_no()
    {
        return phone_no;
    }
    
    public String getpincode()
    {
        return pincode;
    }
    public String getfirst_name()
    {
        return first_name;
    }
    public String getlast_name()
    {
        return last_name;
    }
    public String getemail()
    {
        return email;
    }            
    public String gethouseno()
    {
        return houseno;
    }
    public String getarea()
    {
        return area;
    }
    public String getcity()
    {
        return city;
    }
    public String getid()
    {
        return id;
    }
    public String getimage()
    {
        return image;
    }
   
}
