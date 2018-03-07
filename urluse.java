import java.net.*;
import java.io.*;
public class urluse
{
    public static void main()throws IOException
    {
        String output="C:\\Users\\USER56\\Desktop\\Image.jpg";
        InputStream in;
        FileOutputStream out;
        try
        {
            URL u1=new URL ("http://www.avajava.com/images/avajavalogo.jpg");
            HttpURLConnection con=(HttpURLConnection)u1.openConnection();
            con.connect();
            int response = con.getResponseCode();
            System.out.println("HTTP Response: "+response);
            int length = con.getContentLength();
            System.out.println("Content Length: "+length);
            in=con.getInputStream();
            out=new FileOutputStream(output);
            int c;
            byte[] b=new byte[2048];            
            while ((c=in.read(b))!=-1)
            {
                out.write(b,0,c);
            }
            in.close();
            out.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
