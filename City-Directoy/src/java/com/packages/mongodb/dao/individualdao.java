/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packages.mongodb.dao;

import com.packages.mongodb.converter.individualconverter;
import com.packages.mongodb.model.individual;
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
public class individualdao {
 private DBCollection col;
    public individualdao(MongoClient mongo) {
		this.col = mongo.getDB("project").getCollection("individual");
	}

	public individual createindividual(individual p) {
		DBObject doc = individualconverter.toDBObject(p);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		p.setid(id.toString());
		return p;
	}

	public void updateindividual(individual p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		this.col.update(query, individualconverter.toDBObject(p));
	}

	public List<individual> readAllindividual() {
		List<individual> data;
                data = new ArrayList<>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			individual p = individualconverter.toindividual(doc);
			data.add(p);
		}
		return data;
	}

	public void deleteindividual(individual p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		this.col.remove(query);
	}

	public individual readindividual(individual p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getid())).get();
		DBObject data = this.col.findOne(query);
		return individualconverter.toindividual(data);
	}

}
