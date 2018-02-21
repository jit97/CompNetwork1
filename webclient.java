import java.net.*;
import java.io.* ;

public class WebClient
{
    // instance variables - replace the example below with your own
    public static void main(String[] args) throws Exception
    {
        //open a socket to the URL www.java2s.com"
        InetAddress IPobject=InetAddress.getByName("www.java2s.com");
        Socket FromClient=new Socket(IPobject,80);
        

        PrintWriter OutToServer=new PrintWriter(FromClient.getOutputStream());
        OutToServer.println("get/http/1.1");
        OutToServer.println("host:www.java2s.com");
        OutToServer.println("");
        OutToServer.flush();
        BufferedReader FromServer=new BufferedReader(new InputStreamReader(FromClient.getInputStream()));
        String InfoFromServer ;
        FileOutputStream FileOutobj = new FileOutputStream(("C:\\users\\admin\\desktop\\output.txt"));
        PrintWriter ToFile = new PrintWriter(FileOutobj);
        while((InfoFromServer =FromServer.readLine())!=null)
        {
            System.out.println(InfoFromServer);
            ToFile.println(InfoFromServer);
        }
        ToFile.flush();
        FileOutobj.close();
    }
}
