/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clint.Connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

/**
 *
 * @author DELL
 */
public class Connect {
    private BufferedWriter write;
    private BufferedReader read;
    
    
    public Connect() throws IOException    {
        connect();
    }
    
    public void connect()  {
        try{
       Socket serversoc = new Socket("127.0.0.1", 6000);
       
       write = new BufferedWriter(new OutputStreamWriter(serversoc.getOutputStream()));
       write.write("JOIN#");
       System.out.println("Success");
       
       write.close();
       
       ServerSocket clientserversoc = new ServerSocket(7000);
       Socket clientsoc = clientserversoc.accept();
       read = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
       
       System.out.println(read.readLine()); // do the job, I just print out the msg
       read.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException{
        new Connect();
        
    }
    
 
    
}
