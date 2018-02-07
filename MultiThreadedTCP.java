import java.net.*;
import java.io.*;

public class MultiThreadTCP implements Runnable
{
    Socket clientsocket;
    public MultiThreadTCP(Socket socket)
    {
        clientsocket=socket;
       
    }
    public void run()
    {
      while(true)
      {
        try
      {
          
        //Assuming a client got connected and clientsocket available for server
       //let us try to write code to send and receive(from the server)
       //via the clientsocket
       BufferedReader infromClient= new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
    //Read from client
       String inputstring= infromClient.readLine();
    System.out.println("From Client:"+ inputstring);
    PrintWriter OutToclient=new PrintWriter(clientsocket.getOutputStream());
      String output=inputstring.toUpperCase();
      //send to client
      OutToclient.println("From Server:"+output);
      OutToclient.flush();
    }
    catch(Exception e)
    {
        System.out.println("error");
    }
     }// end of while             
    }// end of run
   public static void main(String[] args)throws Exception
   {
       //create a TCP server tht listens via serversocet(welcomesocket)
       ServerSocket serverobj= new ServerSocket(6969);
       while(true)
       {
       Socket DueToclientconnection=serverobj.accept();//blocking call
       MultiThreadTCP Serverobj= new MultiThreadTCP(DueToclientconnection);
       Thread ForEveryClient= new Thread(Serverobj);
       ForEveryClient.start();
    }
       
       
    }
    
}
