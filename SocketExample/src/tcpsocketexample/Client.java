/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpsocketexample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class Client {
    public Client(){
        try{
            Socket s = new Socket("localhost", 7777);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            //Gui du lieu den Server
            dos.writeUTF("Hello Server, I am Client");
            //Nhan du lieu tu Server
            String dataFromServer = dis.readUTF(); System.out.println(dataFromServer);
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
        }
    }
    
    public static void main(String[] args) {
        new Client();
    }
}
