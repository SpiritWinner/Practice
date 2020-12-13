import javax.swing.*;

public class mainframe extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button2;
    private JButton button3;
    private JTextField textField6;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    public mainframe(){
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
      mainframe mf = new mainframe();
      mf.setSize(800,600);
    }
}
