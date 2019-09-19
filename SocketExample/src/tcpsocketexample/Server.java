/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpsocketexample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class Server {
    public Server(){
        try{
            ServerSocket ss = new ServerSocket(7777);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            //Nhan du lieu tu Client
            String dataFromClient = dis.readUTF(); System.out.println(dataFromClient);
            //Gui du lieu den Client
            dos.writeUTF("Hello Client, I am Server");
            s.close();
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
        }
    }
    
    public static void main(String[] args) {
        new Server();
    }
}
