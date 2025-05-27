import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;


class Main{
    final public String eval(String s){
        return "hi";
    }
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame();
        frame.setSize(414, 637);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Five-Function Calculator");
        // Create buttons
        ArrayList<JButton> buttons = new ArrayList<>();
        ArrayList<String> buttonText = new ArrayList<>();
        buttonText.addAll(Arrays.asList("CLEAR","+","-","1","2","3","*","4","5","6","/","7","8","9","^","0",".","="));
        for (int i=0; i<buttonText.size(); i++){
            buttons.add(new JButton(buttonText.get(i)));
            frame.add(buttons.get(i));
            buttons.get(i).setFocusable(false);
            buttons.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            buttons.get(i).setFont(new Font("Arial",Font.BOLD,20));
            //Color buttons
            Color clear = new Color(242,75,75);
            Color funcs = new Color(255,0,230);
            Color equ = new Color(29,225,55);
            Color nums = new Color(0,179,255);
            if (i==0){
                buttons.get(i).setBackground(clear);
            }
            else if (Arrays.asList(1,2,6,10,14).contains(i)){
                buttons.get(i).setBackground(funcs);
            }
            else if (i==17){
                buttons.get(i).setBackground(equ);
            }
            else{
                buttons.get(i).setBackground(nums);
            }
        }
        //Set positions of buttons
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
        buttons.get(16).setBounds(100,508,100,92);
        buttons.get(17).setBounds(200,508,200,92);

        //Header
        JLabel title = new JLabel("CALCULATOR",SwingConstants.CENTER);
        title.setBounds(0,0,400,40);
        title.setFont(new Font("Arial",Font.BOLD | Font.ITALIC,25));
        title.setBackground(new Color(194,252,252));
        title.setOpaque(true);
        frame.add(title);

        //Text field
        JTextField text = new JTextField("",20);
        text.setBounds(0,40,400,100);
        text.setEditable(false);
        text.setBackground(Color.WHITE);
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setFont(new Font("Arial",Font.PLAIN,18));
        frame.add(text);

        frame.setVisible(true);

        

        // CLEAR
        buttons.get(0).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText("");

            }
        });
        // 1
        buttons.get(3).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"1");

            }
        });
        // 2
        buttons.get(4).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"2");

            }
        });
        // 3
        buttons.get(5).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"3");

            }
        });
        // 4
        buttons.get(7).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"4");

            }
        });
        // 5
        buttons.get(8).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"5");

            }
        });
        // 6
        buttons.get(9).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"6");

            }
        });
        // 7
        buttons.get(11).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"7");

            }
        });
        // 8
        buttons.get(12).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"8");

            }
        });
        // 9
        buttons.get(13).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"9");

            }
        });
        // 0
        buttons.get(15).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"0");

            }
        });
        // Decimal
        buttons.get(16).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opLoc = -1;
                String str = text.getText();
                for (int i=0; i<str.length(); i++) {
                    if (Arrays.asList('+','-','*','/','^').contains(str.charAt(i))){
                        opLoc = i;
                    }
                }
                // Doesn't let user put multiple decimal points in the same number
                if (opLoc==-1){
                    if (str.contains(".") == false){
                        text.setText(str+".");
                    }
                }
                else{
                    if (str.substring(opLoc).contains(".") == false){
                        text.setText(str+".");
                    }
                }

            }
        });
        // +
        buttons.get(1).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = text.getText();
                if (str.contains("+") || str.substring(1,str.length()).contains("-") || str.contains("*") || str.contains("/") || str.contains("^")){
                    // Replace operation at end of string
                    if (Arrays.asList('+','-','*','/','^').contains(str.charAt(str.length()-1))){
                        text.setText(str.substring(0,str.length()-1)+"+");
                    }
                    else{
                        int opLoc = -1;
                        for (int i=0; i<str.length(); i++) {
                            if (Arrays.asList('+','-','*','/','^').contains(str.charAt(i))){
                                opLoc = i;
                            }
                        }
                        String first = str.substring(0,opLoc);
                        String second = str.substring(opLoc+1,str.length());
                        char op = str.charAt(opLoc);
                        if (second.equals(".")){
                            
                        }
                        // Calculate operation and add plus sign to end of answer
                        else if (op=='+'){
                            text.setText(Float.toString(Float.parseFloat(first)+Float.parseFloat(second))+"+");
                        }
                        else if (op=='-'){
                            text.setText(Float.toString(Float.parseFloat(first)-Float.parseFloat(second))+"+");
                        }
                        else if (op=='*'){
                            text.setText(Float.toString(Float.parseFloat(first)*Float.parseFloat(second))+"+");
                        }
                        else if (op=='/'){
                            text.setText(Float.toString(Float.parseFloat(first)/Float.parseFloat(second))+"+");
                        }
                        else if (op=='^'){
                            text.setText(Double.toString(Math.pow(Float.parseFloat(first),Float.parseFloat(second)))+"+");
                        }


                    }
                }
                else if (str.isEmpty() == false && str.equals(".") == false){
                    text.setText(str+"+");
                }

            }
        });
        // -
        buttons.get(2).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = text.getText();
                if (str.contains("+") || str.substring(1,str.length()).contains("-") || str.contains("*") || str.contains("/") || str.contains("^")){
                    // Replace operation at end of string
                    if (Arrays.asList('+','-','*','/','^').contains(str.charAt(str.length()-1))){
                        text.setText(str.substring(0,str.length()-1)+"-");
                    }
                    else{
                        int opLoc = -1;
                        for (int i=0; i<str.length(); i++) {
                            if (Arrays.asList('+','-','*','/','^').contains(str.charAt(i))){
                                opLoc = i;
                            }
                        }
                        String first = str.substring(0,opLoc);
                        String second = str.substring(opLoc+1,str.length());
                        char op = str.charAt(opLoc);
                        if (second.equals(".")){
                            
                        }
                        // Calculate operation and add minus sign to end of answer
                        else if (op=='+'){
                            text.setText(Float.toString(Float.parseFloat(first)+Float.parseFloat(second))+"-");
                        }
                        else if (op=='-'){
                            text.setText(Float.toString(Float.parseFloat(first)-Float.parseFloat(second))+"-");
                        }
                        else if (op=='*'){
                            text.setText(Float.toString(Float.parseFloat(first)*Float.parseFloat(second))+"-");
                        }
                        else if (op=='/'){
                            text.setText(Float.toString(Float.parseFloat(first)/Float.parseFloat(second))+"-");
                        }
                        else if (op=='^'){
                            text.setText(Double.toString(Math.pow(Float.parseFloat(first),Float.parseFloat(second)))+"-");
                        }


                    }
                }
                else if (str.isEmpty() == false && str.equals(".") == false){
                    text.setText(str+"-");
                }

            }
        });
        // *
        buttons.get(6).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = text.getText();
                if (str.contains("+") || str.substring(1,str.length()).contains("-") || str.contains("*") || str.contains("/") || str.contains("^")){
                    // Replace operation at end of string
                    if (Arrays.asList('+','-','*','/','^').contains(str.charAt(str.length()-1))){
                        text.setText(str.substring(0,str.length()-1)+"*");
                    }
                    else{
                        int opLoc = -1;
                        for (int i=0; i<str.length(); i++) {
                            if (Arrays.asList('+','-','*','/','^').contains(str.charAt(i))){
                                opLoc = i;
                            }
                        }
                        String first = str.substring(0,opLoc);
                        String second = str.substring(opLoc+1,str.length());
                        char op = str.charAt(opLoc);
                        if (second.equals(".")){
                            
                        }
                        // Calculate operation and add asterisk to end of answer
                        else if (op=='+'){
                            text.setText(Float.toString(Float.parseFloat(first)+Float.parseFloat(second))+"*");
                        }
                        else if (op=='-'){
                            text.setText(Float.toString(Float.parseFloat(first)-Float.parseFloat(second))+"*");
                        }
                        else if (op=='*'){
                            text.setText(Float.toString(Float.parseFloat(first)*Float.parseFloat(second))+"*");
                        }
                        else if (op=='/'){
                            text.setText(Float.toString(Float.parseFloat(first)/Float.parseFloat(second))+"*");
                        }
                        else if (op=='^'){
                            text.setText(Double.toString(Math.pow(Float.parseFloat(first),Float.parseFloat(second)))+"*");
                        }


                    }
                }
                else if (str.isEmpty() == false && str.equals(".") == false){
                    text.setText(str+"*");
                }

            }
        });
        // / (Division)
        buttons.get(10).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = text.getText();
                if (str.contains("+") || str.substring(1,str.length()).contains("-") || str.contains("*") || str.contains("/") || str.contains("^")){
                    // Replace operation at end of string
                    if (Arrays.asList('+','-','*','/','^').contains(str.charAt(str.length()-1))){
                        text.setText(str.substring(0,str.length()-1)+"/");
                    }
                    else{
                        int opLoc = -1;
                        for (int i=0; i<str.length(); i++) {
                            if (Arrays.asList('+','-','*','/','^').contains(str.charAt(i))){
                                opLoc = i;
                            }
                        }
                        String first = str.substring(0,opLoc);
                        String second = str.substring(opLoc+1,str.length());
                        char op = str.charAt(opLoc);
                        if (second.equals(".")){
                            
                        }
                        // Calculate operation and add slash at end of answer
                        else if (op=='+'){
                            text.setText(Float.toString(Float.parseFloat(first)+Float.parseFloat(second))+"/");
                        }
                        else if (op=='-'){
                            text.setText(Float.toString(Float.parseFloat(first)-Float.parseFloat(second))+"/");
                        }
                        else if (op=='*'){
                            text.setText(Float.toString(Float.parseFloat(first)*Float.parseFloat(second))+"/");
                        }
                        else if (op=='/'){
                            text.setText(Float.toString(Float.parseFloat(first)/Float.parseFloat(second))+"/");
                        }
                        else if (op=='^'){
                            text.setText(Double.toString(Math.pow(Float.parseFloat(first),Float.parseFloat(second)))+"/");
                        }


                    }
                }
                else if (str.isEmpty() == false && str.equals(".") == false){
                    text.setText(str+"/");
                }

            }
        });
        // ^ (Exponent)
        buttons.get(14).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = text.getText();
                if (str.contains("+") || str.substring(1,str.length()).contains("-") || str.contains("*") || str.contains("/") || str.contains("^")){
                    // Replace operation at end of string
                    if (Arrays.asList('+','-','*','/','^').contains(str.charAt(str.length()-1))){
                        text.setText(str.substring(0,str.length()-1)+"^");
                    }
                    else{
                        int opLoc = -1;
                        for (int i=0; i<str.length(); i++) {
                            if (Arrays.asList('+','-','*','/','^').contains(str.charAt(i))){
                                opLoc = i;
                            }
                        }
                        String first = str.substring(0,opLoc);
                        String second = str.substring(opLoc+1,str.length());
                        char op = str.charAt(opLoc);
                        if (second.equals(".")){
                            
                        }
                        // Calculate operation and add exponent sign to end of answer
                        else if (op=='+'){
                            text.setText(Float.toString(Float.parseFloat(first)+Float.parseFloat(second))+"^");
                        }
                        else if (op=='-'){
                            text.setText(Float.toString(Float.parseFloat(first)-Float.parseFloat(second))+"^");
                        }
                        else if (op=='*'){
                            text.setText(Float.toString(Float.parseFloat(first)*Float.parseFloat(second))+"^");
                        }
                        else if (op=='/'){
                            text.setText(Float.toString(Float.parseFloat(first)/Float.parseFloat(second))+"^");
                        }
                        else if (op=='^'){
                            text.setText(Double.toString(Math.pow(Float.parseFloat(first),Float.parseFloat(second)))+"^");
                        }


                    }
                }
                else if (str.isEmpty() == false && str.equals(".") == false){
                    text.setText(str+"^");
                }

            }
        });
        // =
        buttons.get(17).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = text.getText();
                int opLoc = -1;
                for (int i=0; i<str.length(); i++) {
                    if (Arrays.asList('+','-','*','/','^').contains(str.charAt(i))){
                        opLoc = i;
                    }
                }
                if (opLoc!=-1){
                    String first = str.substring(0,opLoc);
                    String second = str.substring(opLoc+1,str.length());
                    char op = str.charAt(opLoc);
                    if (second.equals(".") || second.isEmpty()){
                                
                    }
                    else if (op=='+'){
                        text.setText(Float.toString(Float.parseFloat(first)+Float.parseFloat(second)));
                    }
                    else if (op=='-'){
                        text.setText(Float.toString(Float.parseFloat(first)-Float.parseFloat(second)));
                    }
                    else if (op=='*'){
                        text.setText(Float.toString(Float.parseFloat(first)*Float.parseFloat(second)));
                    }
                    else if (op=='/'){
                        text.setText(Float.toString(Float.parseFloat(first)/Float.parseFloat(second)));
                    }
                    else if (op=='^'){
                        text.setText(Double.toString(Math.pow(Float.parseFloat(first),Float.parseFloat(second))));
                    }
                }

            }
        });
    }
}