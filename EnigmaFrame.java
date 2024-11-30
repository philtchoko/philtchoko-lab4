
import javax.swing.*;
import java.awt.*;


public class EnigmaFrame extends JFrame {
/* 
a few gui elements needed for the gui:
jcombobox
jtextfield
jtextarea
jbutton
jlabel
*/
    public static void main (String args[]) {
        
     

        final Integer [] index = {1, 2, 3, 4, 5}; 
   
       
        JFrame frame = new JFrame();

        frame.setTitle("Enigma GUI");
        
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        frame.add(north, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(south, BorderLayout.SOUTH);
        north.add(new JLabel("Inner "));
        JComboBox <Integer> innerDrop = new JComboBox<Integer>(index);
        JComboBox <Integer> middleDrop = new JComboBox <Integer>(index);
        JComboBox <Integer> outerDrop = new JComboBox <Integer>(index);
        JButton encryptBut = new JButton("Encrypt");
        JButton decryptBut = new JButton("Decrypt");
        JTextField init = new JTextField(3);
        JTextArea input = new JTextArea(5, 45);
        JTextArea output = new JTextArea(5, 45);

        north.add(innerDrop);
        north.add(new JLabel("Middle "));
        north.add(middleDrop);
        north.add(new JLabel("Outer "));
        north.add(outerDrop);
        north.add(new JLabel("Initial Positions "));
        north.add(init);
        north.add(encryptBut);
        north.add(decryptBut);


        center.add(new JLabel("Input "));
        center.add(input);
        south.add(new JLabel("Output "));
        south.add(output);

        /* 
        innerDrop.addActionListener((e) -> {
            int id1 = innerDrop.getSelectedIndex();
        });
        middleDrop.addActionListener((e) -> {
            int id2 = middleDrop.getSelectedIndex();
        });
        outerDrop.addActionListener((e) -> {
            int id3 = outerDrop.getSelectedIndex();
        });

        init.addActionListener((e) -> {
            String start = init.getText();
        });
        */

        // create enigma


        encryptBut.addActionListener((e) -> {
            int id1 = innerDrop.getSelectedIndex() + 1;
            int id2 = middleDrop.getSelectedIndex() + 1;
            int id3 = outerDrop.getSelectedIndex() + 1;
            String start = init.getText();
            Enigma enigma = new Enigma(id1, id2, id3, start);
            //DEBUG
            System.out.println(start);
            System.out.println(id1);
            System.out.println(id2);
            System.out.println(id3);
            output.setText(enigma.encrypt(input.getText()));

        });
        

        decryptBut.addActionListener((e) -> {
            //enigma.decrypt(gettextfieldinput);
            int id1 = innerDrop.getSelectedIndex() + 1;
            int id2 = middleDrop.getSelectedIndex() + 1;
            int id3 = outerDrop.getSelectedIndex() + 1;
            String start = init.getText();
            Enigma enigma = new Enigma(id1, id2, id3, start);
            //DEBUG
            System.out.println(start);
            System.out.println(id1);
            System.out.println(id2);
            System.out.println(id3);
            output.setText(enigma.decrypt(input.getText()));
        });
        
        
        frame.setSize(700, 300);
        frame.setLocation(100, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }   

    public void validateInputs(){
        // 

    }

}