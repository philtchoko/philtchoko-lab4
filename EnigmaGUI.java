import javax.swing.JFrame;

public class EnigmaGUI {
// this class is written to launch the gui, we finna worry bout this later lol
public static void main(String args[]) {
        EnigmaFrame f = new EnigmaFrame();
        f.setSize(300, 200);
        f.setLocation(100, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


}