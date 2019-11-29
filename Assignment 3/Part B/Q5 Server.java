import java.io.*;
import java.net.*;

public class udp_server extends Thread
{
	public static void main(String args[])
	{
    	
		DatagramSocket sock = null;
 
    		try
		{
			//creating a server socket, parameter
			sock = new DatagramSocket(20000);
			
			//buffer to receive incoming data
			byte[] buffer = new byte[65536];
			DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
     
           	while(true)
		 {
			sock.receive(incoming);
			byte[] data = incoming.getData();
			String s = new String(data, 0, incoming.getLength());
                	DatagramPacket dp = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
				        sock.send(dp);
                
		}
		
		
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}
	
      
      
