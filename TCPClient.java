import java.net.*;
import java.io.*;
public class TCPClient
{
    public static final String LOCAL_HOST = "localhost";
    public static void main(String[] args)
    {
        try
        {
        Socket c2s=new Socket(LOCAL_HOST,6969);
        PrintWriter output=new PrintWriter(c2s.getOutputStream());
        BufferedReader in=new BufferedReader (new InputStreamReader (c2s.getInputStream()));//read server
        BufferedReader in1=new BufferedReader (new InputStreamReader (System.in)); //read from keyboard
        while (true){
        String a=in1.readLine();
        output.println(a);
        output.flush();
        String fromserver=in.readLine();
        System.out.println(fromserver);
        }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
