import java.io.*;
import java.net.*;
import java.util.Scanner;

public class udp_client extends Thread
{
	public static void main(String args[])
	{
		DatagramSocket sock = null;
		int port = 20000;
		String s;
		
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			sock = new DatagramSocket();
      InetAddress host = InetAddress.getByName(args[0]);
      while(true)
			{
				//take input and send the packet
				System.out.println("Enter no of packets");
        int n = sc.nextInt(); 
				byte[] b = s.getBytes();
        
				for(int i=0;i<n;i++)
        {
            System.out.println("Send packet"+i);
				    DatagramPacket  dp = new DatagramPacket(b , b.length , host , port);
				    sock.send(dp);
            Thread.sleep(60000)
         }
				
				//now receive reply
				//buffer to receive incoming data
        	for(int i=0;i<n;i++)
        {
            System.out.println("Receive packet"+i);
				     byte[] buffer = new byte[65536];
				     DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				      sock.receive(reply);
        }
				
				byte[] data = reply.getData();
				s = new String(data, 0, reply.getLength());
			}
		}
		
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}
      
