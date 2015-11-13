package br.com.exemploMongo;

import java.net.UnknownHostException;
import java.sql.Connection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoDAO {
		
	private static final String host = "localhost";
	private static final int port = 27017;
	DBCollection tableUser;
	DBCollection tableScan;
		
	public boolean inserirPing(Ping ping) {
			try {
				Mongo mongo = new Mongo(host, port);
				DB db = mongo.getDB("test");
				tableUser = db.getCollection("PingWrapper");
				BasicDBObject document = new BasicDBObject();
				document.put("url", ping.getUrl());
				String line_separator = System.getProperty("line.separator");  
				String result = ping.getHops().replaceAll("\\n|"+line_separator, " ");
				document.put("hops", result); 
				tableUser.insert(document); 
			} catch (UnknownHostException e) {	
				e.printStackTrace();
				return false; 
			}
			return true;
		}
	
	  public boolean inserirScan(Scan scan) {
		  try {
			  Mongo mongo = new Mongo(host,port);
			  DB db = mongo.getDB("test");
			  tableScan = db.getCollection("Scan");
			  BasicDBObject document = new BasicDBObject();
			  document.put("url", scan.getUrl());
			  String line_separator = System.getProperty("line.separator");  
			  String result = scan.getPorts().replaceAll("\\n|"+line_separator, " ");  
			  document.put("ports", result);
			  tableScan.insert(document);
		  } catch (UnknownHostException e) {
			  e.printStackTrace();
		  }
		  
		  return true;
	  }
	
	

	}



