import java.io.*;
import java.net.*;

public class udp_server extends Thread
{
	public static void main(String args[])
	{
    Scanner sc=new Scanner(System.in);
		DatagramSocket sock = null;
    System.out.println("Enter no of packets");
    int n = sc.nextInt();
    try
		{
			//creating a server socket, parameter
			sock = new DatagramSocket(20000);
			
			//buffer to receive incoming data
			byte[] buffer = new byte[65536];
			DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
      for(int i=1;i<n;i++)
      {
           while(true)
			     {
				        sock.receive(incoming);
				        byte[] data = incoming.getData();
				        String s = new String(data, 0, incoming.getLength());
                DatagramPacket dp = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
				        sock.send(dp);
                System.out.println("Sends Packet "+i);
			}
		}
		
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}
	
      
      
