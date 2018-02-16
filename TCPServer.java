import java.net.*;

import java.io.*;

public class TCPServer

{

    public static void main(String[] args)throws IOException

    {

        ServerSocket serversocketobj=new ServerSocket(6969);

        System.out.println("waiting for connection from client");

        Socket clientsocket= serversocketobj.accept();

    BufferedReader infromClient= new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

    String inputstring= infromClient.readLine();

    System.out.println("From Client:"+ inputstring);                
    }

}

