/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.converter;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.packages.mongodb.model.hotels;
import org.bson.types.ObjectId;

/**
 *
 * @author ankit
 */
public  class hotelconverter {
    
    public static DBObject toDBObject(hotels p) {

	 	BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
	.append("address", p.getaddress()).append("email", p.getemail()).append("rating",p.getrating())
                        .append("message", p.getmessage()).append("name", p.getname()).append("budget", p.getbudget())
                        .append("phone", p.getphone());
		if (p.getid() != null)
			builder = builder.append("_id", new ObjectId(p.getid()));
		return builder.get();
	}

    public static hotels tohotel(DBObject doc) {
		hotels p = new hotels();
		p.setaddress((String)doc.get("address"));
                p.setemail((String) doc.get("email"));
		p.setrating((String) doc.get("rating"));
		p.setmessage((String) doc.get("message"));
                p.setname((String) doc.get("name"));
                p.setbudget((String) doc.get("budget"));
                p.setphone((String) doc.get("phone"));
                ObjectId id = (ObjectId) doc.get("_id");
		p.setid(id.toString());
                
		return p;

	}
}