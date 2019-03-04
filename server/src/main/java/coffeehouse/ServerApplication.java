package coffeehouse;

import coffeehouse.net.Server;
//import java.io.*;
//import java.net.*;
  
public class ServerApplication {
	public static void main(String[] args) {
		if (args.length < 1) {

			System.err.println("Insufficient arguments provides, usage: program <port>");
		}	
				
		
		int port = Integer.parseInt(args[0]);
		
		Server server;	
		
		try{
			server= new Server(port);
			
		}catch(Exception e){
			System.out.println("Could not start server on that port");
			return;
		}
		//server.waitForThreads();
		//server.close();
	}
}
