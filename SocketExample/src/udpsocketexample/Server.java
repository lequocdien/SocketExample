/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpsocketexample;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author ASUS
 */
public class Server {
    private int portServer = 7777;
    private byte buff[] = new byte[50];
    
    public Server(){
        try{
            DatagramSocket ds = new DatagramSocket(portServer);
            
            //Nhan du lieu tu Client
            DatagramPacket dpInput = new DatagramPacket(buff, buff.length);
            ds.receive(dpInput);
            String dataFromClient = new String(dpInput.getData(), 0, dpInput.getData().length);
            System.out.println("Data nhan tu Client: "+dataFromClient);
            
            //Gui du lieu den Client
            String chuoiCanGui = "Hello Client, I am Server";
            DatagramPacket dpOutput = new DatagramPacket(chuoiCanGui.getBytes(), chuoiCanGui.getBytes().length, dpInput.getAddress(), dpInput.getPort());
            ds.send(dpOutput);
            
            //Dong ket noi
            ds.close();
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
        }
    }
    
    public static void main(String[] args) {
        new Server();
    }
}
