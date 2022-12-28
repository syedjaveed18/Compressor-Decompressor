/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import compressordecompressor.Decompressor;
import compressordecompressor.compressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ssd
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        
        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 100, 200, 20);
        
        decompressButton = new JButton("Selct file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,20);
        
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500, 200);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
         if(e.getSource() == compressButton){
             JFileChooser filechooser = new JFileChooser();
             int response = filechooser.showSaveDialog(null);
             
             if(response == JFileChooser.APPROVE_OPTION){
                 File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                 System.out.println(file);
                 try{
                     compressor.compressorMethod(file);
                 }
                 catch(Exception excp){
                     JOptionPane.showMessageDialog(null, excp.toString());
                 }                
             }
         }
         
         if(e.getSource() == decompressButton){
             JFileChooser filechooser = new JFileChooser();
             int response = filechooser.showSaveDialog(null);
             
             if(response == JFileChooser.APPROVE_OPTION){
                 File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                 System.out.println(file);
                 try{
                     Decompressor.DecompressorMethod(file);
                 }
                 catch(Exception excp){
                     JOptionPane.showMessageDialog(null,excp.toString());
                 }
             }
         }
    }
 
}
