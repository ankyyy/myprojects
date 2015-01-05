/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.dao;

import com.packages.mongodb.converter.automobileconverter;
import com.packages.mongodb.model.automobile;
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
public class automobilsdao {
 private DBCollection col;
    public automobilsdao(MongoClient mongo) {
		this.col = mongo.getDB("project").getCollection("automobile");
	}

	public automobile createautomobile(automobile p) {
		DBObject doc = automobileconverter.toDBObject(p);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		p.setid(id.toString());
		return p;
	}

	public void updateautomobile(automobile p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		this.col.update(query, automobileconverter.toDBObject(p));
	}

	public List<automobile> readAllautomobile() {
		List<automobile> data;
                data = new ArrayList<>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			automobile p = automobileconverter.toautomobile(doc);
			data.add(p);
		}
		return data;
	}

	public void deleteautomobile(automobile p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		this.col.remove(query);
	}

	public automobile readautomobile(automobile p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		DBObject data = this.col.findOne(query);
		return automobileconverter.toautomobile(data);
	}

}
