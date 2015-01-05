/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.converter;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.packages.mongodb.model.automobile;
import org.bson.types.ObjectId;

/**
 *
 * @author ankit
 */
public  class automobileconverter {
    
    public static DBObject toDBObject(automobile p) {

	 	BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
	.append("address", p.getaddress()).append("email", p.getemail()).append("type",p.gettype())
                        .append("comment", p.getcomments()).append("name", p.getname()).append("dealer", p.getdealer())
                        .append("phone", p.getphone()).append("brand", p.getbrand());
		if (p.getid() != null)
			builder = builder.append("_id", new ObjectId(p.getid()));
		return builder.get();
	}

    public static automobile toautomobile(DBObject doc) {
		automobile p = new automobile();
                p.settype((String)doc.get("type"));
                
		p.setaddress((String)doc.get("address"));
                p.setemail((String) doc.get("email"));
		p.setbrand((String) doc.get("brand"));
		p.setcomments((String) doc.get("comments"));
                p.setname((String) doc.get("name"));
                p.setdealer((String) doc.get("dealer"));
                p.setphone((String) doc.get("phone"));
                ObjectId id = (ObjectId) doc.get("_id");
		p.setid(id.toString());
                
		return p;

	}
}