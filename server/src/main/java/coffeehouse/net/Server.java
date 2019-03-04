package coffeehouse.net;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.*;
import coffeehouse.net.ClientThread;
import java.net.UnknownHostException;

public class Server{
	final int port;
	//private Thread ConnectionListener;
	private List clientThreads;  
	
	private ServerSocket serverSocket;
	private Socket socket;
	
	public Server(int serverPort){// throws UnknownHostException{
		port = serverPort;
		clientThreads = new ArrayList<ClientThread>();
		try{
			serverSocket = new ServerSocket(port);
		}catch(Exception e){
			System.out.println("serversocket error");
			e.printStackTrace();
		}
		
		while (true){
			System.out.println("Number of clients connected: " + clientThreads.size());
			try{
				socket= serverSocket.accept();
			}catch(Exception e){
				System.out.println("error in accepting connection: "+ e);
			}
			try {
				ClientThread temp = new ClientThread(socket, this);
				temp.start();
				clientThreads.add(temp);
			
			}catch(Exception e){}
		}	
	}

	public int getPort(){
		return port;
	}
	
	public void removeFromList(ClientThread inClient){
		if(clientThreads.contains(this)){
			System.out.println("in");
		}else{
			System.out.println("out");
		}
		clientThreads.remove(inClient);
	}
	//public void startNewClientThread(){
		
	//}
}
