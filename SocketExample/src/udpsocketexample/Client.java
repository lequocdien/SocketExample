/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpsocketexample;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author ASUS
 */
public class Client {
    private int portServer = 7777;
    private byte buff[] = new byte[50];
    private static String IPServer = "127.0.0.1";
    
    public Client(){
        try{
            DatagramSocket ds = new DatagramSocket();
            
            //Gui du lieu den Server
            String chuoiCanGui = "Hello Server, I am Client";
            DatagramPacket dpOutput = new DatagramPacket(chuoiCanGui.getBytes(), chuoiCanGui.getBytes().length, InetAddress.getByName(IPServer), portServer);
            ds.send(dpOutput);
            
            //Nhan du lieu tu Server
            DatagramPacket dpInput = new DatagramPacket(buff, buff.length);
            ds.receive(dpInput);
            String dataFromServer = new String(dpInput.getData(), 0, dpInput.getData().length);
            System.out.println("Data nhan tu Server: "+ dataFromServer);
            
            //Dong ket noi
            ds.close();
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
        }
    }
    
    public static void main(String[] args) {
        new Client();
    }
}
