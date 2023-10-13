
import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select file to compress");
        this.setTitle("File Compressor/Decompressor");
        this.getContentPane().setBackground(new Color(240, 240, 240));//**
        this.setLayout(new FlowLayout()); //**

        Font buttonFont = new Font("Calibri", Font.BOLD, 20);

        compressButton = new JButton("Select file to compress");
        compressButton.setFont(buttonFont);
        compressButton.setBounds(20, 20, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setFont(buttonFont);
        decompressButton.setBounds(20, 20, 200, 30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.pack();
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int respond = fileChooser.showSaveDialog(null);
            if(respond == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                    JOptionPane.showMessageDialog(this, "File compressed successfully!");
                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex.toString());
                    JOptionPane.showMessageDialog(this, "Compression error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int respond = fileChooser.showSaveDialog(null);
            if(respond == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                    JOptionPane.showMessageDialog(this, "File decompressed successfully!");
                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex.toString());
                    JOptionPane.showMessageDialog(this, "Decompression error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}