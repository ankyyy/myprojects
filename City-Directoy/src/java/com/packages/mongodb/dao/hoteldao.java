/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.dao;

import com.packages.mongodb.converter.hotelconverter;
import com.packages.mongodb.model.hotels;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author ankit
 */
public class hoteldao {
 private DBCollection col;
    public hoteldao(MongoClient mongo) {
		this.col = mongo.getDB("project").getCollection("hotel");
	}

	public hotels createhotel(hotels p) {
		DBObject doc = hotelconverter.toDBObject(p);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		p.setid(id.toString());
		return p;
	}

	public void updatehotel(hotels p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		this.col.update(query, hotelconverter.toDBObject(p));
	}

	public List<hotels> readAllhotel() {
		List<hotels> data;
                data = new ArrayList<>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			hotels p = hotelconverter.tohotel(doc);
			data.add(p);
		}
		return data;
	}

	public void deletehotel(hotels p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		this.col.remove(query);
	}

	public hotels readhotel(hotels p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		DBObject data = this.col.findOne(query);
		return hotelconverter.tohotel(data);
	}

}
