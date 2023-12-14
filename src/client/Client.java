/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w
 */
public class Client {
    
    Socket mySocket;
    DataInputStream in;
    PrintStream out;

    public void connect(String ip, int port) {
        try {
            mySocket = new Socket(ip, port);
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        startListening();
    }

    public void closeConnection() {
        //TODO
    }
    
    public void sendRequest(String gson) {
        out.println(gson);
    }

    public void startListening() {
        new Thread(() -> {
            try {
                while (mySocket != null && !(mySocket.isClosed())) {
                    String gsonResponse = in.readLine();
                    handleResponse(gsonResponse);
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
    public void handleResponse(String responce) {
        // TODO
        
    }
}
