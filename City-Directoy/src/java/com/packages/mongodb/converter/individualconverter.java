/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.packages.mongodb.model.individual;
import org.bson.types.ObjectId;

/**
 *
 * @author ankit
 */
public class individualconverter {
    
    public static DBObject toDBObject(individual p) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
	.append("area", p.getarea()).append("city", p.getcity()).append("first_name",p.getfirst_name())
                        .append("houseno", p.gethouseno()).append("last_name", p.getlast_name()).append("image", p.getimage())
                        .append("email", p.getemail()).append("phone_no", p.getphone_no()).append("pincode", p.getpincode());
		if (p.getid() != null)
			builder = builder.append("_id", new ObjectId(p.getid()));
		return builder.get();
	}

    public static individual toindividual(DBObject doc) {
		individual p = new individual();
		p.setimage((String)doc.get("image"));
                p.setarea((String) doc.get("area"));
		p.setcity((String) doc.get("city"));
		p.setemail((String) doc.get("email"));
                p.setfirst_name((String) doc.get("first_name"));
                p.sethouseno((String) doc.get("houseno"));
                p.setlast_name((String) doc.get("last_name"));
                p.setphone_no((String) doc.get("phone_no"));
                p.setpincode((String) doc.get("pincode"));
                ObjectId id = (ObjectId) doc.get("_id");
		p.setid(id.toString());
                
		return p;

	}
}