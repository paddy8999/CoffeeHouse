package coffeehouse.net;

import java.net.Socket;
import java.io.*;
import coffeehouse.net.Server;
import java.net.UnknownHostException;

public class ClientThread extends Thread {
	private int port;
	private Socket socket;
	private Server server;
	private InputStream inStream;
	private OutputStream outStream;

	ClientThread(Socket inSocket, Server inServer) {
		socket = inSocket;
		server = inServer;
		port = server.getPort();
		try{
			outStream = socket.getOutputStream();
			inStream = socket.getInputStream();
		}catch (Exception e) {
			System.out.println("input/output stream error");
		}
		//System.out.println(port);
	}
	
	public void run(){
		System.out.println("clientConnected" );	
		Reader reader = new InputStreamReader(inStream);
		while (!socket.isInputShutdown()){	
			//Packet message = Packet.readPacket(reader);	
			//System.out.println(message.getType());
		}
		
		server.removeFromList(this);

		try{
			reader.close();
		}catch (Exception e){
			System.out.println("reader close error");	
		}
		

	}
	
	
	
	
}
