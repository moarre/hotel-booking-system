import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class RegisterForm extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    private JTextField nameText;
    private JTextField idText;
    private JTextField passText;
    private JButton regButton;
    private JButton clearButton;
    private JLabel userName;
    private JPanel regForm;
    private JLabel userID;
    private JLabel userPass;
    private JLabel sign;
    JLabel label = new JLabel("Please enter your password:");
    JPasswordField jpf = new JPasswordField();

    public RegisterForm() {
        super();
        super.setContentPane(regForm);

        super.setTitle("Register New User");
        super.setBounds(100,100,500,500);
        //super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //register button to action listener
        regButton.addActionListener(this);
        clearButton.addActionListener(this);

        //super.setVisible(true);

        //design page
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setForeground(Color.WHITE);
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sign.setForeground(Color.BLACK);
        sign.setBackground(Color.WHITE);
        sign.setFont(new Font("Arial", Font.BOLD, 19));
        sign.setBounds(100,40,200,40);

        userName.setFont(new Font("Arial", Font.PLAIN, 12));
        userName.setBounds(70,120,75,25);

        userID.setFont(new Font("Arial", Font.PLAIN, 12));
        userID.setBounds(70,190,75,25);

        userPass.setFont(new Font("Arial", Font.PLAIN, 12));
        userPass.setBounds(70,260,75,25);

        nameText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameText.setColumns(10);
        nameText.setBounds(70,150,350,25);

        idText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idText.setColumns(10);
        idText.setBounds(70,220,350,25);

        passText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passText.setColumns(10);
        passText.setBounds(70,290,350,25);

        regButton.setBackground(new Color(51,51,51));
        regButton.setForeground(Color.WHITE);
        regButton.setFont(new Font("Arial", Font.BOLD, 15));
        regButton.setBounds(70,260,350,35);
        regButton.setFocusable(false);
        regButton.addActionListener(this);

        clearButton.setBackground(new Color(51,51,51));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 15));
        clearButton.setBounds(70,310,350,35);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);


    }

    //public static void main(String args[]) {RegisterForm of = new RegisterForm();}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            nameText.setText("");
            idText.setText("");
            passText.setText("");
        }
        if (e.getSource() == regButton) {

            String name = nameText.getText();
            String id = idText.getText();
            String passW = passText.getText();

            try {
                FileWriter fw = new FileWriter("customer.txt", true);
                fw.write("\n");
                fw.write(name);
                fw.write(";");
                fw.write(id);
                fw.write(";");
                fw.write(passW);
                fw.close();
                JOptionPane.showMessageDialog(rootPane, "Success");
            }
            catch (Exception m) {
                JOptionPane.showMessageDialog(rootPane,"Error");
            }

        }
    }
}
