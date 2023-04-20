import java.nio.file.Files;
import java.nio.file.Path;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
public class Server {
    public static void main(String[] args) throws Exception  {

        String readClient;
        Scanner input = new Scanner(System.in);
        boolean finish = true;
        try{
        ServerSocket sSocket = new ServerSocket(5616);

        Socket keepConnect = sSocket.accept();
        System.out.println("client Connected");


        BufferedReader inputClient = new BufferedReader(new InputStreamReader(keepConnect.getInputStream()));
        DataOutputStream toClient = new DataOutputStream(keepConnect.getOutputStream());

        toClient.writeBytes("Program initialize...."+'\n');
        toClient.writeBytes("Cloud Calculator Activate"+'\n');
        toClient.writeBytes("choose between(Multiply/Divide/ADD/SUB)"+'\n');

        String firstNUm;
        String secondNum;




        while(!sSocket.isClosed() ) {

            readClient = inputClient.readLine();
            firstNUm = inputClient.readLine();
            secondNum = inputClient.readLine();


          //  System.out.println(readClient);
//
            if(readClient.equals("Multiply"))
            {

              int num1 = Integer.parseInt(firstNUm);
              int num2 = Integer.parseInt(secondNum);
              int Mult = num1*num2;
              String returner = "The Multiplication is equal to "+Mult;

              toClient.writeBytes(returner+'\n');


            }
            else if(readClient.equals("Divide"))
            {

                double num1 = Integer.parseInt(firstNUm);
                double num2 = Integer.parseInt(secondNum);
                double Div = num1/num2;
                if(Div< 1||Div % 2 != 0)
                {
                    String returner = "The division is equal to "+Div;
                    toClient.writeBytes(returner+'\n');

                }
                else
                {
                    int Div2 = (int)Div;
                    String returner = "The division is equal to "+Div2;
                    toClient.writeBytes(returner+'\n');

                }




            }
            else if(readClient.equals("ADD"))
            {

                int num1 = Integer.parseInt(firstNUm);
                int num2 = Integer.parseInt(secondNum);
                int adding = num1+num2;
                String returner = "The Sum is equal to "+adding;

                toClient.writeBytes(returner+'\n');


            }
            else if(readClient.equals("SUB"))
            {

                int num1 = Integer.parseInt(firstNUm);
                int num2 = Integer.parseInt(secondNum);
                int sub = num1-num2;
                String returner = "the Subtraction is equal to "+sub;

                toClient.writeBytes(returner+'\n');


            }
            if (readClient.equals("bye")) {


               sSocket.close();

            }

           else
           {

               toClient.writeBytes("unknown command. try again" + '\n');

           }
//           }
            toClient.flush();

        }





        }
       catch (Exception e)
       {
           System.out.println("client Disconnect");
       }

    }
}