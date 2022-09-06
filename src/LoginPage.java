import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel l1 = new JLabel("HOTEL LANG BUANA");
    JLabel userIDLabel = new JLabel("USERNAME");
    JLabel userPasswordLabel = new JLabel("PASSWORD");
    JLabel messageLabel = new JLabel();
    JButton regLabel = new JButton("Register new customer");
    HashMap<String,String> logininfo = new HashMap<String,String>();

    LoginPage(HashMap<String,String> loginInfoOriginal){

        logininfo = loginInfoOriginal;

        //design page
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setForeground(Color.WHITE);
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1.setForeground(Color.BLACK);
        l1.setBackground(Color.WHITE);
        l1.setFont(new Font("Arial", Font.BOLD, 19));
        l1.setBounds(140,40,200,40);

        userIDLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        userIDLabel.setBounds(70,120,75,25);

        userPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        userPasswordLabel.setBounds(70,190,75,25);

        userIDField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userIDField.setColumns(10);
        userIDField.setBounds(70,150,350,25);

        userPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userPasswordField.setColumns(10);
        userPasswordField.setBounds(70,220,350,25);

        loginButton.setBackground(new Color(153,130,188));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setBounds(70,260,350,35);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBackground(new Color(222,62,68));
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(new Font("Arial", Font.BOLD, 15));
        resetButton.setBounds(70,310,350,35);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        regLabel.setBackground(Color.white);
        regLabel.setForeground(Color.BLUE.darker());
        regLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regLabel.setBounds(160,380,170,30);
        regLabel.addActionListener(this);

        //add frame
        frame.add(l1);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(regLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,500,500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)) {
                if(logininfo.get(userID).equals(password)) {
                    //messageLabel.setForeground(Color.green);
                    //messageLabel.setText("Login successful");
                    frame.dispose();
                    HomePage homePage = new HomePage();
                }
                else {
                    //messageLabel.setForeground(Color.red);
                    //messageLabel.setText("Wrong password");
                    JOptionPane.showMessageDialog(frame,"Wrong Input!");
                }

            }
            else {
                //messageLabel.setForeground(Color.red);
                //messageLabel.setText("username not found");
                JOptionPane.showMessageDialog(frame,"Username Not Found!");
            }
        }

        if (e.getSource()==regLabel) {
            RegisterForm registerForm = new RegisterForm();
            registerForm.setVisible(true);
        }
    }
}
