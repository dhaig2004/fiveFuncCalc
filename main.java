import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

class Main{
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame();
        frame.setSize(413, 638);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create buttons
        ArrayList<JButton> buttons = new ArrayList<>();
        ArrayList<String> buttonText = new ArrayList<>();
        buttonText.addAll(Arrays.asList("CLEAR","+","-","1","2","3","*","4","5","6","/","7","8","9","^","0","="));
        for (int i=0; i<buttonText.size(); i++){
            buttons.add(new JButton(buttonText.get(i)));
            frame.add(buttons.get(i));
            buttons.get(i).setFocusable(false);
            buttons.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        }
        buttons.get(0).setBounds(0,140,200,92);
        buttons.get(1).setBounds(200,140,100,92);
        buttons.get(2).setBounds(300,140,100,92);
        buttons.get(3).setBounds(0,232,100,92);
        buttons.get(4).setBounds(100,232,100,92);
        buttons.get(5).setBounds(200,232,100,92);
        buttons.get(6).setBounds(300,232,100,92);
        buttons.get(7).setBounds(0,324,100,92);
        buttons.get(8).setBounds(100,324,100,92);
        buttons.get(9).setBounds(200,324,100,92);
        buttons.get(10).setBounds(300,324,100,92);
        buttons.get(11).setBounds(0,416,100,92);
        buttons.get(12).setBounds(100,416,100,92);
        buttons.get(13).setBounds(200,416,100,92);
        buttons.get(14).setBounds(300,416,100,92);
        buttons.get(15).setBounds(0,508,100,92);
        buttons.get(16).setBounds(100,508,300,92);
    }
}