package com.mlg420blazeit;

import java.io.IOException;
import javax.swing.JFrame;

// Author: Pseudo
// Version: 1.0.1
public class UDowner extends JFrame {
        
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public UDowner() {
        
    }
    public static void main(String[] args) {
        GUI ui;
        
        String version = "1.0.1";
        
        JFrame frame = new JFrame("U-Downer " + version);
        
        ui = new GUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(ui);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
    public void download(String condition) {
        String[] command = {"cmd.exe", "/c", "start " + condition};
        //String[] command = {"youtube-dl", "-x", "https://www.youtube.com/watch?v=E9Q4-wcPDBQ"};
        ProcessBuilder builder = new ProcessBuilder(command);
        try {
         builder.start();
                                                                                                                                                                                                                                              
        
         
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
