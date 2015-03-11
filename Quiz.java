package  com.mong;
import java.io.IOException;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Set;

public class Quiz extends HttpServlet{

	public  void Connection() throws IOException{
		// TODO Auto-generated method stub
		  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		try{   
			 // To connect to mongodb server
	     
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "test" );
			 System.out.println("Connection to database successfull");
	      //   boolean authenti = db.auth("MongoDB","mongodb");
			DBCollection coll = db.createCollection("testCollection", new BasicDBObject("capped", true)
	        .append("size", 1048576));
			 Set<String> colls = db.getCollectionNames();
			 for (String s : colls)
				 System.out.println(s);
			
			// System.out.println("Authentication: "+auth); 
	      }catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		  }
		finally
		{
			mongoClient.close();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(user + pass);
	}

}

