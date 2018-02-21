/**
 * Jit
*/
import java.net.*;
import java.io.*;
public class webclient_image
{
    public static void main(String[] args)throws IOException
    {
        //try{
        InetAddress IPobject=InetAddress.getByName("www.bits-pilani.ac.in");
        Socket FromClient=new Socket(IPobject,80);
        PrintWriter OutToServer=new PrintWriter(FromClient.getOutputStream());
        OutToServer.println("GET //Uploads/Campus/BITS_Dubai_campus_logo.gif HTTP/1.1");
        OutToServer.println("HOST: www.bits-pilani.ac.in");
        OutToServer.println("");
        OutToServer.flush();
        InputStream ifs = FromClient.getInputStream();
        File obj=new File ("C:\\Users\\admin\\Downloads\\Image.gif");
        FileOutputStream output=new FileOutputStream (obj);
        byte[] imagebyte=new byte[2048];
        int length;
        boolean eohFound=false;
        while ((length=ifs.read(imagebyte))!=-1)
        {
       
            if (eohFound)
            output.write(imagebyte,0,length);
            else
            {
                for (int i=0;i<=2045;i++)
                {
                if(imagebyte[i]==13 && imagebyte[i+1]==10 && imagebyte[i+2]==13 && imagebyte[i+3]==10)
                {
                    eohFound=true;
                    output.write(imagebyte,i+4,length-i-4);
                    break;
                }
                }
            
        }
        }
        //output.write(imagebyte,0,length);
        output.flush();
        }
        /**catch (Exception E)
        {
            System.out.println(E);
        }*/
    }
