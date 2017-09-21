package com.omniwyse.test;

import java.net.UnknownHostException;

import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoExample {

    public static void main(String[] args) throws UnknownHostException {

	// Old version, uses Mongo
	// Mongo mongo = new Mongo("localhost", 27017);

	// Since 2.10.0, uses MongoClient
	MongoClient mongo = new MongoClient("localhost", 27017);
	DB db = mongo.getDB("mybd");
	System.out.println("Connect to database successfully");
	boolean auth = db.authenticate("username", "password".toCharArray());
	System.out.println("Authentication: " + auth);
	DBCollection coll = db.getCollection("movie");
	System.out.println("Collection movie selected successfully");
	DBCursor cursor = coll.find();
	System.out.println(cursor.getCollection());
	JSONObject obj;
	int i = 1;
	while (cursor.hasNext()) {
	    System.out.println("Inserted Document: " + cursor);
	    //System.out.println(cursor.next());
	    obj = new JSONObject(cursor.next().toString());
	    System.out.println("Name : " + obj.getString("name")+"   ,   id : "+obj.getJSONObject("_id"));
	    i++;
	    System.out.println("hahahah....  "+obj.toString());
	}
	
    }

}
