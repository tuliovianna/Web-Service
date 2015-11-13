package br.com.exemploMongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class ConectaMongo {
		
	
	
	private static final String host = "localhost";
	private static final int port = 27017;
	DBCollection tableUser;
	
		public static void obterConexao() throws UnknownHostException {
			Mongo mongo = new Mongo(host, port);
			DB db = mongo.getDB("test");
			DBCollection tableUser = db.getCollection("Usuario");
		}
		
		public DBCollection getTableUser() {
			return tableUser;
		}
		
		public void setTableUser(DBCollection tableUser) {
			this.tableUser = tableUser;
		}

	
	
	
}
